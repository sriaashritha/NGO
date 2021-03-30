package com.ngo.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.DonationDistributionEntity;

@Repository
public interface DonationDistributionRepo extends JpaRepository<DonationDistributionEntity, Integer> {

}