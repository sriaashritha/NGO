package com.ngo.cg.service;

import java.util.List;

import com.ngo.cg.exception.DuplicateDonorException;
import com.ngo.cg.exception.NoSuchDonorException;
import com.ngo.cg.model.DonationModel;
import com.ngo.cg.model.DonorModel;



public interface IDonorService {
	public boolean login(DonorModel donor) throws NoSuchDonorException;

	public DonorModel add(DonorModel donor) throws DuplicateDonorException;

	public List<DonationModel> getAllDonations(int donorId) throws NoSuchDonorException;

	public DonorModel modifyPassword(DonorModel donorModel, int donorId) throws NoSuchDonorException;

	DonorModel getById(int donorId) throws NoSuchDonorException;


}
