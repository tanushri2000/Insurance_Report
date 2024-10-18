package com.tanu.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CitizenPlans {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer citizenId;
	private String citizenName;
	private String citizenPhone;
	private String citizenGender;
	private String plansName;
	private String plansStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private Integer benefitAmount;
	private String denialReason;
	private LocalDate terminationDate;
	private String terminationReason;
	
	

}
