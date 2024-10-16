package com.tanu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tanu.entity.CitizenPlans;

public interface CitizenPlansRepository extends JpaRepository<CitizenPlans,Integer>{
	
	@Query("Select distinct(plansName) from CitizenPlans")
	public List<String> plansName();
	
	@Query("Select distinct(plansStatus) from CitizenPlans")
	public List<String> plansStatus();

}
