package com.ngo.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.DonorEntity;


@Repository
public interface DonorRepo extends JpaRepository<DonorEntity, Integer>{


	
}
