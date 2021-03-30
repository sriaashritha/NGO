package com.ngo.cg.NeedyPersonTestImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ngo.cg.entity.AddressEntity;
import com.ngo.cg.entity.DonationDistributionStatus;
import com.ngo.cg.entity.DonationItemEntity;
import com.ngo.cg.entity.EmployeeEntity;
import com.ngo.cg.entity.NeedyPeopleEntity;
import com.ngo.cg.exception.DuplicateDonationException;
import com.ngo.cg.exception.DuplicateEmployeeException;
import com.ngo.cg.exception.NoSuchAdminException;
import com.ngo.cg.exception.NoSuchDonationException;
import com.ngo.cg.exception.NoSuchEmployeeException;
import com.ngo.cg.model.AddressModel;
import com.ngo.cg.model.AdminModel;
import com.ngo.cg.model.DonationDistributionModel;
import com.ngo.cg.model.EmployeeModel;
import com.ngo.cg.service.AdminServiceImpl;
import com.ngo.cg.service.IAdminService;



@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {
	@Mock
	private IAdminService adminService;

	@InjectMocks
	private AdminServiceImpl service;

	@BeforeEach
	void runBeforeAllTestCase() {
		service = new AdminServiceImpl();
	}

	@AfterEach
	void cleanAfterAllTestCase() {
		service = null;
	}

	@Test
	@DisplayName("Admin login")
	void testLogin() throws NoSuchAdminException {
		AdminModel admin = new AdminModel(1, "divya", "divya@123");
		Mockito.when(adminService.login(admin)).thenReturn(true);
		assertTrue(adminService.login(admin));

	}

	@Test
	@DisplayName("Employee should add")
	void testaddEmployee() throws DuplicateEmployeeException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "677676", "Gandhi Hospital");
		EmployeeModel employee1 = new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya",
				"meg2123456", a1);
		Mockito.when(adminService.addEmployee(employee1)).thenReturn(true);
		assertTrue(adminService.addEmployee(employee1));
	}

	@Test
	@DisplayName("Employee details should modify")
	void testmodifyEmployee() throws NoSuchEmployeeException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "600062", "Veltech");
		EmployeeModel employee = new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya", "meg2123456",
				a1);
		Mockito.when(adminService.modifyEmployee(employee)).thenReturn(employee);
		EmployeeModel expected = new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya", "meg2123456",
				a1);
		EmployeeModel actual = adminService.modifyEmployee(employee);
		assertEquals(expected, actual);

	}

	@Test
	@DisplayName("EmployeeDetails should delete")
     void testRemoveEmployee() throws NoSuchEmployeeException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "677676", "Gandhi Hospital");
		EmployeeModel employee1 =   new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya",
		"meg2123456", a1);
		Mockito.when(adminService.removeEmployee(employee1.getEmployeeId())).thenReturn(true);
		assertTrue(adminService.removeEmployee(employee1.getEmployeeId()));

	}

	@Test
	@DisplayName("EmployeeDetails should display by using Id")
	public void testfindEmployeeById() throws NoSuchEmployeeException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "600062", "Veltech");
		int id = 1;
		EmployeeModel employee = new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya", "meg2123456",
				a1);
		Mockito.when(adminService.findEmployeeById(id)).thenReturn(employee);
		EmployeeModel expected = new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya", "meg2123456",
				a1);
		EmployeeModel actual = adminService.findEmployeeById(id);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("EmployeeDetails should display by using Name")
	public void testfindEmployeeByName() throws NoSuchEmployeeException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "600062", "Veltech");
		AddressModel a2 = new AddressModel(10001, "chennai", "TamilNadu", "600062", "Veltech");
		String name = "divya";
		List<EmployeeModel> list = new ArrayList<>();
		EmployeeModel[] testData = {
				new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya", "navya123", a1),
				new EmployeeModel(102, "divya", "divya@gmail.com", "778024088", "divya", "divya123", a2) };
		for (EmployeeModel p : testData) {
			list.add(p);
		}
		Mockito.when(adminService.findEmployeeByName(name)).thenReturn(list);

		List<EmployeeModel> actual = adminService.findEmployeeByName(name);
		assertEquals(list, actual);

	}

	@Test
	@DisplayName("All EmployeeDetails should display")
	public void testfindAllEmployee() throws NoSuchEmployeeException {
		AddressModel a1 = new AddressModel(10001, "chennai", "TamilNadu", "600062", "Veltech");
		AddressModel a2 = new AddressModel(10001, "chennai", "TamilNadu", "600062", "Veltech");
		List<EmployeeModel> list = new ArrayList<>();
		EmployeeModel[] testData = {
				new EmployeeModel(101, "navya", "navya@gmail.com", "9090700123", "navya", "meg2123456", a1),
				new EmployeeModel(102, "divya", "divya@gmail.com", "778024088", "divya", "divya123", a2) };
		for (EmployeeModel p : testData) {
			list.add(p);
		}
		Mockito.when(adminService.findAllEmployee()).thenReturn(list);

		List<EmployeeModel> actual = adminService.findAllEmployee();
		assertEquals(list, actual);

	}

	@Test
	void testApproveDonation() throws DuplicateDonationException, NoSuchDonationException {

		AddressEntity a1 = new AddressEntity(10001, "Bangalore", "Karnataka", "714323", "MGRoad");
		String name = "divya";
		NeedyPeopleEntity model = new NeedyPeopleEntity(1, "divya", "89654334212", 89000, "Divya@123", a1);
		DonationItemEntity donat = null;
		EmployeeEntity emp = null;

		DonationDistributionStatus status = DonationDistributionStatus.APPROVED;
		DonationDistributionModel testData = new DonationDistributionModel(1, 12.0, LocalDate.parse("2021-03-20"),
				LocalDate.parse("2021-03-21"), status, model, emp, donat);

		Mockito.when(adminService.approveDonation(testData)).thenReturn(true);

		boolean result = adminService.approveDonation(testData);
		assertTrue(result);

	}

}