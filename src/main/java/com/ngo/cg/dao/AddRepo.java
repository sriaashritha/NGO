package com.ngo.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.AddressEntity;



@Repository
public interface AddRepo extends JpaRepository<AddressEntity,Integer>{



}
