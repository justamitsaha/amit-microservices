package com.saha.amit.authenticationservices.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

	@NotNull(message = "Username cannot be blank")
	@NotEmpty(message = "Username cannot be blank")
	private String email;
	@NotNull(message = "Password cannot be blank")
	@NotEmpty(message = "Password cannot be blank")
	private String password;
}

