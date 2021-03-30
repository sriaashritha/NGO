package com.ngo.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.cg.entity.NeedyRequest;

public interface NeedyRequestRepo extends JpaRepository<NeedyRequest, Integer> {


}
