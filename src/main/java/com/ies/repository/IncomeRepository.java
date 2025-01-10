package com.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.IncomeEntity;

public interface IncomeRepository extends JpaRepository<IncomeEntity,Integer>{
	
	@Query("FROM IncomeEntity WHERE caseNum= :caseNum")
	public IncomeEntity findByCaseNum(Long caseNum);

}
