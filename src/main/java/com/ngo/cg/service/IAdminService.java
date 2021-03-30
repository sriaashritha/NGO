package com.ngo.cg.service;

import java.util.List;

import com.ngo.cg.exception.DuplicateAdminException;
import com.ngo.cg.exception.DuplicateDonationException;
import com.ngo.cg.exception.DuplicateEmployeeException;
import com.ngo.cg.exception.NoSuchAdminException;
import com.ngo.cg.exception.NoSuchDonationException;
import com.ngo.cg.exception.NoSuchEmployeeException;
import com.ngo.cg.model.AdminModel;
import com.ngo.cg.model.DonationDistributionModel;
import com.ngo.cg.model.EmployeeModel;


public interface IAdminService {

	public boolean addEmployee(EmployeeModel employee) throws DuplicateEmployeeException;
	public EmployeeModel modifyEmployee(EmployeeModel employee) throws NoSuchEmployeeException;
	public boolean removeEmployee(int employee1) throws NoSuchEmployeeException;
	public EmployeeModel findEmployeeById(int employeeId) throws NoSuchEmployeeException;
	public List<EmployeeModel> findEmployeeByName(String name) throws NoSuchEmployeeException;
	public List<EmployeeModel> findAllEmployee() throws NoSuchEmployeeException;
	public boolean approveDonation(DonationDistributionModel distribution) throws DuplicateDonationException, NoSuchDonationException;

	boolean addAdmin(AdminModel admin) throws DuplicateAdminException;
	public boolean login(AdminModel admin) throws NoSuchAdminException;
	

}