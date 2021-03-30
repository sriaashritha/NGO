package com.ngo.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ngo.cg.entity.AdminEntity;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, Integer> {

}
