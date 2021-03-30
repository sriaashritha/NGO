package com.ngo.cg.service;


import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.cg.dao.NeedyPeopleRepo;
import com.ngo.cg.dao.NeedyRequestRepo;
import com.ngo.cg.dto.NeedyPeopleDto;
import com.ngo.cg.entity.NeedyPeopleEntity;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchNeedyException;
import com.ngo.cg.model.NeedyPeopleModel;
import com.ngo.cg.model.NeedyRequestModel;


@Service
public class NeedyPeopleServiceImpl implements INeedyPeopleService {

	@Autowired
	private NeedyPeopleRepo needypeopleRepo;
	
	@Autowired
	private NeedyRequestRepo needyrequestRepo;

	@Autowired
	private EMParser parser;

	public NeedyPeopleServiceImpl(NeedyPeopleRepo needypeopleRepo, EMParser parser) {
		super();
		this.needypeopleRepo = needypeopleRepo;
		this.parser = parser;
	}

	public EMParser getParser() {
		return parser;
	}

	public void setParser(EMParser parser) {
		this.parser = parser;
	}

	public NeedyPeopleRepo getNeedypeopleRepo() {
		return needypeopleRepo;
	}

	public void setNeedypeopleRepo(NeedyPeopleRepo needypeopleRepo) {
		this.needypeopleRepo = needypeopleRepo;
	}
	@Override
	public boolean registerNeedyPerson(NeedyPeopleModel person)throws DuplicateNeedyPersonException{
		boolean status=false;
		if(person!=null) {
			if(needypeopleRepo.existsById(person.getNeedyPersonId())) {
				throw new DuplicateNeedyPersonException("person already exists");
			}
			person=parser.parse(needypeopleRepo.save(parser.parse(person)));
			status=true;
		}
		return status;
	}

	@Override
	public boolean SignIn(NeedyPeopleDto person)throws NoSuchNeedyException {
		boolean status = false;
		Optional<NeedyPeopleEntity> dt=needypeopleRepo.findById(person.getNeedyPersonId());
		if(dt.isPresent()) {
			if(dt.get().getNeedyPeoplePassword().equals(person.getNeedyPeoplePassword())){
				status = true;	
			}
		} else {
			throw new NoSuchNeedyException("Invalid password / user");
		}
		return status;
	}

	
	@Override
	public boolean requestForHelp(NeedyRequestModel person) throws DuplicateNeedyPersonException  {
		Boolean status = false;

		if (person != null) {
			if (needyrequestRepo.existsById(person.getNeedyPersonId())) {
				throw new DuplicateNeedyPersonException("request already raised");
			}
			person = parser.parse(needyrequestRepo.save(parser.parse(person)));                      
			status = true;

		}

		return status;
	}
}


	
	


	

