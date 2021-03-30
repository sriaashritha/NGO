package com.ngo.cg.service;

import com.ngo.cg.exception.UserException;
import com.ngo.cg.model.UserModel;

public interface IUserService {
	UserModel signIn(UserModel user) throws UserException;
	UserModel findById(int userId);

}
