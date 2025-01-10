package com.ies.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "ELIG_DTLS")
public class EligEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer edgTraceId;
	

	private String planName;

	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "caseNum")
	private ApplicationEntity caseNum;


	private String planStatus;

	private Double benefitAmt;

	private LocalDate eligStartDate;

	private LocalDate eligEndDate;

	private String denialRsn;

}
