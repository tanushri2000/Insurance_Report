package com.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity,Integer>{
	
	@Modifying
	@Query("UPDATE PlanEntity  u SET u.activeStwitch = :status WHERE u.planId = :planId")
	public Integer updatePlanStatus(Integer planId,String status);
	
	@Query("FROM PlanEntity WHERE planName= :planName")
	public List<String> findByPlanName(String planName);

}
