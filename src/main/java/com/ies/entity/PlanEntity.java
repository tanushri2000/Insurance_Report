package com.ies.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PLANS_DTLS")
public class PlanEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer planId;
	
	private String planName;
	
	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	private String planCategory;
	
	private String activeStwitch;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;
	
	@ManyToOne
	@JoinColumn(name="createdBy",updatable=false)
	private UsersEntity createdBy;

	@ManyToOne
	@JoinColumn(name="updatedBy",insertable=false)
	private UsersEntity updatedBy;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	private UsersEntity user;	
	

 

	
	
	
}
