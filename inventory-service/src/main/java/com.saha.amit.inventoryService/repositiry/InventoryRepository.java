package com.saha.amit.inventoryService.repositiry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.saha.amit.inventoryService.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

}
