package com.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.PlansSelectionEntity;

public interface PlanSelRepository extends JpaRepository<PlansSelectionEntity,Integer>{

	@Query("FROM planSelRepo where caseNum= :caseNum")
	public PlansSelectionEntity findByCaseNum(Long caseNum);
}
