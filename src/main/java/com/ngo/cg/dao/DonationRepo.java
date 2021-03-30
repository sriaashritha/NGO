package com.ngo.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.DonationEntity;

@Repository
public interface DonationRepo extends JpaRepository<DonationEntity, Integer> {

}
