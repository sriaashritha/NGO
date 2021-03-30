package com.ngo.cg.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.cg.entity.NeedyPeopleEntity;


@Repository
public interface NeedyPeopleRepo extends JpaRepository<NeedyPeopleEntity, Integer>{
	Optional<NeedyPeopleEntity> findByNeedyPersonName(String needyPersonName);



}
