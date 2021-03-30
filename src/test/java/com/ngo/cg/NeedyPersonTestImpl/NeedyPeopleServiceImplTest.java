package com.ngo.cg.NeedyPersonTestImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ngo.cg.dto.NeedyPeopleDto;
import com.ngo.cg.entity.AddressEntity;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchNeedyException;
import com.ngo.cg.model.NeedyPeopleModel;
import com.ngo.cg.model.NeedyRequestModel;
import com.ngo.cg.service.INeedyPeopleService;
import com.ngo.cg.service.NeedyPeopleServiceImpl;

@ExtendWith(MockitoExtension.class)
public class NeedyPeopleServiceImplTest {
	@Mock
	private INeedyPeopleService needypeopleRepo;

	@InjectMocks
	private NeedyPeopleServiceImpl service;

	@BeforeEach
	void runBeforeAllTestCase() {
		service = new NeedyPeopleServiceImpl(null, null);
	}

	@AfterEach
	void cleanAfterAllTestCase() {
		service = null;
	}

	@Test
	@DisplayName("registration")
	void testCreateDonor() throws DuplicateNeedyPersonException {
		AddressEntity a1= new AddressEntity(10001,"chennai","TamilNadu","667762","avadi");
		NeedyPeopleModel person=new NeedyPeopleModel(1001,"SRI AASHRITHA","7330867459",20000.0,"Sriaashritha#1",a1);
		Mockito.when(needypeopleRepo.registerNeedyPerson(person)).thenReturn(true);
		assertTrue(needypeopleRepo.registerNeedyPerson(person));
	}
	@Test
	void testLogin() throws NoSuchNeedyException {
		NeedyPeopleDto dto = new NeedyPeopleDto(1001,"Sriaashritha#1");
		Mockito.when(needypeopleRepo.SignIn(dto)).thenReturn(true);
		assertTrue(needypeopleRepo.SignIn(dto));

	}
	@Test
	void testRequestForHelp() throws DuplicateNeedyPersonException {
		NeedyRequestModel person = new NeedyRequestModel(1001, "SRI AASHRITHA", "7330867459");
		Mockito.when(needypeopleRepo.requestForHelp(person)).thenReturn(true);
		assertTrue(needypeopleRepo.requestForHelp(person));

	}

}
	
	