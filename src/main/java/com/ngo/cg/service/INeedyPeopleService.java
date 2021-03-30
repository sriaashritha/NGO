package com.ngo.cg.service;

import com.ngo.cg.dto.NeedyPeopleDto;
import com.ngo.cg.exception.DuplicateNeedyPersonException;
import com.ngo.cg.exception.NoSuchNeedyException;
import com.ngo.cg.model.NeedyPeopleModel;
import com.ngo.cg.model.NeedyRequestModel;

public interface INeedyPeopleService {

	public boolean registerNeedyPerson(NeedyPeopleModel person) throws DuplicateNeedyPersonException;
	public boolean SignIn(NeedyPeopleDto person)throws NoSuchNeedyException;
	//public boolean requestForHelp(RequestForHelpModel person) throws  NoSuchNeedyException;;

	public boolean requestForHelp(NeedyRequestModel person) throws DuplicateNeedyPersonException  ;
}

