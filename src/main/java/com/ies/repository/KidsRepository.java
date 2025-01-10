package com.ies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ies.entity.KidsEntity;

public interface KidsRepository extends JpaRepository<KidsEntity,Integer>{
	
	@Query("FROM KidsEntity WHERE caseNum= :caseNum")
	public List<KidsEntity> findByCaseNum(Long caseNum);
	

}