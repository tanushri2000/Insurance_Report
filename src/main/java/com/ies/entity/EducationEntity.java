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
@Table(name = "DC_EDUCATION_DTLS")
public class EducationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;

	private String highestDegree;

	private Integer graduationYear;

	private String university;

	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "caseNum")
	private ApplicationEntity caseNum;

	@ManyToOne
	@JoinColumn(name = "user_Id")
	private UsersEntity userId;

}
