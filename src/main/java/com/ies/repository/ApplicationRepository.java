package com.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Long> {

	@Query(" FROM ApplicationEntity WHERE userId= :userId")
	public List<ApplicationEntity> fetchCwApplications(Integer userId);
	
	@Query(" FROM ApplicationEntity WHERE caseNum= :caseNum")
	public ApplicationEntity findByCaseNum(Long caseNum);
}
