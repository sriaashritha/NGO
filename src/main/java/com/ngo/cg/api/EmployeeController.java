package com.ngo.cg.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.cg.dto.EmployeeDto;
import com.ngo.cg.exception.DuplicateDonationException;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchEmployeeException;
import com.ngo.cg.exception.NoSuchNeedyPeopleException;
import com.ngo.cg.model.DonationDistributionModel;
import com.ngo.cg.model.NeedyPeopleModel;
import com.ngo.cg.service.IEmployeeService;



@RestController
@RequestMapping("/needypeople")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping("/findneedypeople/{id}")
	public ResponseEntity<NeedyPeopleModel> findNeedyPeopleById(@PathVariable Integer id)
			throws NoSuchNeedyPeopleException {
		return new ResponseEntity<NeedyPeopleModel>(employeeService.findNeedyPeopleById(id), HttpStatus.OK);
	}

	@PostMapping("/addneedypeople")
	public ResponseEntity<Boolean> addNeedyPeople(@RequestBody NeedyPeopleModel person)
			throws DuplicateNeedyPersonException {
		return new ResponseEntity<Boolean>(employeeService.addNeedyPerson(person), HttpStatus.OK);
	}

	@DeleteMapping("/removeneedypeople")
	public ResponseEntity<Boolean> removeNeedyPeople(@RequestBody NeedyPeopleModel person)
			throws NoSuchNeedyPeopleException {
		return new ResponseEntity<Boolean>(employeeService.removeNeedyPerson(person), HttpStatus.OK);
	}

	@GetMapping("/findallneedypeople")
	public ResponseEntity<List<NeedyPeopleModel>> findAllNeedyPeople() throws NoSuchNeedyPeopleException {
		return new ResponseEntity<List<NeedyPeopleModel>>(employeeService.findAllNeedyPeople(), HttpStatus.OK);
	}

	@PostMapping("/helpneedypeople")
	public ResponseEntity<String> helpNeedyPeople(@RequestBody DonationDistributionModel distribute)
			throws DuplicateDonationException {
		return new ResponseEntity<String>(employeeService.helpNeedyPerson(distribute), HttpStatus.OK);
	}

	@GetMapping("/findneedypeoplebyname/{name}")
	public ResponseEntity<List<NeedyPeopleModel>> findNeedyPeopleByName(@PathVariable String name)
			throws NoSuchNeedyPeopleException {
		return new ResponseEntity<List<NeedyPeopleModel>>(employeeService.findNeedyPeopleByName(name), HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody EmployeeDto employee) throws NoSuchEmployeeException {
		return new ResponseEntity<Boolean>(employeeService.login(employee), HttpStatus.OK);
	}

}