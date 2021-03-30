package com.ngo.cg.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.cg.dto.NeedyPeopleDto;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchNeedyException;
import com.ngo.cg.model.NeedyPeopleModel;
import com.ngo.cg.model.NeedyRequestModel;
import com.ngo.cg.service.INeedyPeopleService;



@RestController
@RequestMapping("/needy")
public class NeedyController {
	@Autowired
	private INeedyPeopleService NeedyPeopleService;

	@PostMapping("/register")
	public ResponseEntity<Boolean>register(@RequestBody NeedyPeopleModel person)throws DuplicateNeedyPersonException{
		return new ResponseEntity<Boolean>(NeedyPeopleService.registerNeedyPerson(person),HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody NeedyPeopleDto person) throws  NoSuchNeedyException {		
		return new ResponseEntity<Boolean>(NeedyPeopleService.SignIn(person),HttpStatus.OK);
	}
	@PostMapping("/requestForHelp")
	public ResponseEntity<Boolean>requestForHelp(@RequestBody NeedyRequestModel person) throws DuplicateNeedyPersonException {		
		return new ResponseEntity<Boolean>(NeedyPeopleService.requestForHelp(person),HttpStatus.OK);
	}

}
