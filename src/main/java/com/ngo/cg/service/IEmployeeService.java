package com.ngo.cg.service;
import java.util.List;

import com.ngo.cg.dto.EmployeeDto;
import com.ngo.cg.exception.DuplicateDonationException;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchEmployeeException;
import com.ngo.cg.exception.NoSuchNeedyPeopleException;
import com.ngo.cg.model.DonationDistributionModel;
import com.ngo.cg.model.NeedyPeopleModel;



public interface IEmployeeService {

	public boolean addNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException;

	public boolean removeNeedyPerson(NeedyPeopleModel person) throws NoSuchNeedyPeopleException;

	public NeedyPeopleModel findNeedyPeopleById(int id) throws NoSuchNeedyPeopleException;

	public List<NeedyPeopleModel> findAllNeedyPeople() throws NoSuchNeedyPeopleException;

	public List<NeedyPeopleModel> findNeedyPeopleByName(String name) throws  NoSuchNeedyPeopleException;

	public String helpNeedyPerson(DonationDistributionModel distribute) throws DuplicateDonationException;

	public boolean login(EmployeeDto employee) throws NoSuchEmployeeException;


}