package com.ngo.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Integer>{

}