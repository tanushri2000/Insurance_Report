package com.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.EligEntity;

public interface EligRepository extends JpaRepository<EligEntity,Integer> {

	@Query("FROM EligEntity WHERE caseNum= :caseNum")
	public EligEntity findByCseNum(Long caseNum);
	
	@Query("FROM EligEntity WHERE planStatus= :planStatus")
	public List<String> findByPlanStatus(String planStatus);
}
