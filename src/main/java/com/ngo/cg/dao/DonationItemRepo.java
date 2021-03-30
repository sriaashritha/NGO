package com.ngo.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.DonationItemEntity;

@Repository
public interface DonationItemRepo  extends JpaRepository<DonationItemEntity, Integer>{

}
