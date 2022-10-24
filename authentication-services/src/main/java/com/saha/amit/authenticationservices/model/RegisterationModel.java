package com.saha.amit.authenticationservices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REGISTERED_CUSTOMERS")
public class RegisterationModel {

	@Id
	@Column(name = "EMAIL")
	private String emailId;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "SALT")
	private String salt;
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int customerNumber;

}
