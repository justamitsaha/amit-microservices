package com.saha.amit.productServices.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class Product {
	
	@Field(name = "product_name")
	private String name;
	@Field(name = "product_search_name")
	private String srearchName;
	@Field(name = "product_description")
	private String description;
	@Field(name = "product_cost")
	private Double prise;
	@Field(name = "product_rating")
	private float rating;
	@Field(name = "product_added_date")
	private Date productAddedDate;
}
