package com.saha.amit.inventoryService.controller;

import com.saha.amit.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saha.amit.inventoryService.DTO.AddInventoryDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags="Inverntory")
@RequestMapping("/api")
public class InventoryController {
	
	@Autowired
    InventoryService inventoryService;
	
	@ApiOperation(value = "Add Inventory", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/add")
	public ResponseEntity<?> addInventory(@RequestBody AddInventoryDTO inventoryDTO) {
		System.out.println(inventoryDTO.getProductId());
		inventoryService.addInventory(inventoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
