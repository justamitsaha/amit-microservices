package com.saha.amit.authenticationservices.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredCustomersDTO {

	@NotEmpty(message = "Email cannot be blank")
	@Email(message = "Provide a valid email ID")
	private String emailId;
	@NotEmpty(message = "Password cannot be blank")
	private String password;
	@NotEmpty(message = "First name cannot be blank")
	private String firstName;
	@NotEmpty(message = "Last name cannot be blank")
	private String lastName;

}
