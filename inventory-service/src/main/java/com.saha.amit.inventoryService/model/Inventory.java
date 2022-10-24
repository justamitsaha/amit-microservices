package com.saha.amit.inventoryService.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("inventory")
public class Inventory {
	
	@Field(name = "product_id")
	private String productId;
	@Field(name = "classification_name")
	private String classificationName;
	@Field(name = "classification")
	private List< String> classification;
	@Field(name = "inventory_count")
	private int inventoryCount;
}
