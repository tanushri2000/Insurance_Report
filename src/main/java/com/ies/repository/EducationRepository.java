package com.ies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.EducationEntity;

public interface EducationRepository extends JpaRepository<EducationEntity,Integer>{

	@Query("FROM EducationEntity WHERE caseNum= :caseNum")
	public EducationEntity findByCaseNum(Long caseNum);
}
