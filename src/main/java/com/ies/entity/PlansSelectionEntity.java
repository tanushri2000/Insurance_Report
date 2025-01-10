package com.ies.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "DC_PLAN_SEL_DTLS")
public class PlansSelectionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planSelID;

	private Integer planId;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "case_Num")
	private ApplicationEntity caseNum;

	@ManyToOne
	@JoinColumn(name="user_Id")
	private UsersEntity userId;

}
