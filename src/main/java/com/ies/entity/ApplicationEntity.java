package com.ies.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="APPLICATION_DTLS")
public class ApplicationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long caseNum;
	
	private String fullname;
	private String email;
	private String phone;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	private String stateName;
	private String cityName;
	private Integer houseNum;
	
	@CreationTimestamp
	private LocalDate createDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private UsersEntity user;
	
	@OneToOne
	private PlansSelectionEntity planSel;

	@OneToOne
	private IncomeEntity income;

	@OneToOne
	private EducationEntity education;

	@OneToMany
	private List<KidsEntity> kids;
	
	@OneToOne
	private EligEntity elig;
	
	
	
	


}
