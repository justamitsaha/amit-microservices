package com.saha.amit.productServices.controller;


import com.saha.amit.productServices.DTO.ProductRequestDTO;
import com.saha.amit.productServices.model.Product;
import com.saha.amit.productServices.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Product")
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
    ProductService productService;
	
	@ApiOperation(value = "Add Product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/add")
	public ResponseEntity<?> addProduct( @RequestBody ProductRequestDTO productDto) {
		productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable String  id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}
	
	@GetMapping("/isProductPresent/{id}")
	public ResponseEntity<Boolean> isProductPresent(@PathVariable String  id) {
		System.out.println("isProductPresent "+ id );
		Product product = productService.getProductById(id);
		if (product  != null) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
	}
	
	@GetMapping("/getProductByName/{name}")
	public  ResponseEntity<List<Product>> getAllProductsByName(@PathVariable String  name){
		var response = productService.getAllProductsByName(name);
		System.out.println(response.size());
		return ResponseEntity.ok(response);
	}
}
 