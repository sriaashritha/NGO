package com.ngo.cg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.cg.dao.DonationDistributionRepo;
import com.ngo.cg.dao.EmployeeRepo;
import com.ngo.cg.dao.NeedyPeopleRepo;
import com.ngo.cg.dto.EmployeeDto;
import com.ngo.cg.entity.EmployeeEntity;
import com.ngo.cg.entity.NeedyPeopleEntity;
import com.ngo.cg.exception.DuplicateDonationException;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchEmployeeException;
import com.ngo.cg.exception.NoSuchNeedyPeopleException;
import com.ngo.cg.model.DonationDistributionModel;
import com.ngo.cg.model.NeedyPeopleModel;



@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private NeedyPeopleRepo needypeopleRepo;

	@Autowired
	private EmployeeRepo empRepo;

	@Autowired
	private DonationDistributionRepo donationRepo;

	@Autowired
	private EMParser parser;

	public EmployeeServiceImpl(NeedyPeopleRepo needypeopleRepo, EmployeeRepo empRepo,
			DonationDistributionRepo donationRepo, EMParser parser) {
		super();
		this.needypeopleRepo = needypeopleRepo;
		this.empRepo = empRepo;
		this.donationRepo = donationRepo;
		this.parser = new EMParser();
	}


	@Override
	public boolean addNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException {
		Boolean status = false;
		if (person != null) {
			if (needypeopleRepo.existsById(person.getNeedyPersonId())) {
				throw new DuplicateNeedyPersonException("Person " + person.getNeedyPersonId() + " is already Exists");
			} else {
				person = parser.parse(needypeopleRepo.save(parser.parse(person)));
				status = true;
			}
		}
		return status;

	}

	@Override
	public boolean removeNeedyPerson(NeedyPeopleModel person) throws NoSuchNeedyPeopleException {
		Boolean status = false;
		if (person != null) {
			if (needypeopleRepo.existsById(person.getNeedyPersonId())) {
				needypeopleRepo.delete(parser.parse(person));
				status = true;

			} else {
				throw new NoSuchNeedyPeopleException("Person " + person.getNeedyPersonId() + " is Not Exists");
			}
		}
		return status;
	}

	@Override
	public NeedyPeopleModel findNeedyPeopleById(int id) throws NoSuchNeedyPeopleException {
		if (!needypeopleRepo.existsById(id)) {
			throw new NoSuchNeedyPeopleException("Person does not Exists");
		} else {
			return parser.parse(needypeopleRepo.findById(id).orElse(null));
		}

	}

	@Override
	public List<NeedyPeopleModel> findAllNeedyPeople() throws NoSuchNeedyPeopleException {
		return needypeopleRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

	@Override
	public String helpNeedyPerson(DonationDistributionModel distribute) throws DuplicateDonationException {
		if (distribute != null) {
			if (donationRepo.existsById(distribute.getDistributionId())) {
				throw new DuplicateDonationException(
						"Distribution id  " + distribute.getDistributionId() + " is already Exists");
			} else {
				parser.parse(donationRepo.save(parser.parse(distribute)));

			}
		}

		return distribute.toString();
	}

	@Override
	public List<NeedyPeopleModel> findNeedyPeopleByName(String name) throws NoSuchNeedyPeopleException {
		NeedyPeopleEntity people = needypeopleRepo.findByNeedyPersonName(name).orElse(null);

		if (people == null) {
			throw new NoSuchNeedyPeopleException("No Such people");
		}

		return people.getAllNeedyPeople.stream().map(parser::parse).collect(Collectors.toList());

	}

	@Override
	public boolean login(EmployeeDto employee) throws NoSuchEmployeeException {
		Boolean status = false;
		Optional<EmployeeEntity> dt = empRepo.findById(employee.getEmployeeId());
		if (dt.isPresent()) {
			if (dt.get().getPassword().equals(employee.getPassword())) {
				status = true;
			}

		} else {
			throw new NoSuchEmployeeException("Invalid password / user");
		}
		return status;
	}

}
