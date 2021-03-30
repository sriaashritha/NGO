package com.ngo.cg.service;

import com.ngo.cg.model.DonationModel;
import com.ngo.cg.model.DonorModel;

public interface IDonationService {
	DonationModel add(DonationModel donationModel);
	void  sendThankYouMailToDonator(DonorModel donorModel) ;
}
