package com.ies.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "USERS_DTLS")
public class UsersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String fullName;

	private String email;

	private String pwd;

	private Long phone;

	private String gender;

	private LocalDate dob;

	private Long ssn;

	private String activeSwitch;

	private String accountStatus;

	@CreationTimestamp
	private LocalDate createDate;

	@UpdateTimestamp
	private LocalDate updateDate;

	@ManyToOne
	@JoinColumn(name = "createdBy", updatable = false)
	private UsersEntity createdBy;

	@ManyToOne
	@JoinColumn(name = "updatedBy", insertable = false)
	private UsersEntity updatedBy;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	private UserRoleEntity role;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<PlanEntity> plans;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ApplicationEntity> app;

}
