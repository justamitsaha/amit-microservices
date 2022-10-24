package com.saha.amit.productServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
	@NotEmpty(message = "Please provide product name")
	private String name;
	@NotEmpty(message = "Please provide product description")
	private String description;
	@NotEmpty(message = "Please provide product prise")
	private Double prise;
}
