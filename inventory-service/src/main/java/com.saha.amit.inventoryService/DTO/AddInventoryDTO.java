package com.saha.amit.inventoryService.DTO;

import java.util.List;


public class AddInventoryDTO {	
	private String productId;
	private String inventoryClassificationName;
	private List< String> inventoryClassification;
	private int inventoryCount;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getInventoryClassificationName() {
		return inventoryClassificationName;
	}
	public void setInventoryClassificationName(String inventoryClassificationName) {
		this.inventoryClassificationName = inventoryClassificationName;
	}
	public List<String> getInventoryClassification() {
		return inventoryClassification;
	}
	public void setInventoryClassification(List<String> inventoryClassification) {
		this.inventoryClassification = inventoryClassification;
	}
	public int getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
		
}
