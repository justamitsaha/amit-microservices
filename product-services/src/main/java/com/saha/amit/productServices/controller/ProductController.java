package com.saha.amit.productServices.controller;


import com.saha.amit.productServices.DTO.ProductRequestDTO;
import com.saha.amit.productServices.DTO.ResponseDTO;
import com.saha.amit.productServices.model.Product;
import com.saha.amit.productServices.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "Product")
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
    ProductService productService;
	
	@ApiOperation(value = "Add Product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addProduct(@Valid @RequestBody ProductRequestDTO productDto) {
		var product = productService.addProduct(productDto);
		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseDTO rs = ResponseDTO.builder()
				.statusCode(HttpStatus.OK.value())
				.status("Success")
				.response(product)
				.build();
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(rs);
	}

	@GetMapping("/getProductById/{id}")
	public ResponseEntity<ResponseDTO> getProductById(@PathVariable String  id) {
		var product = productService.getProductById(id);
		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseDTO rs = ResponseDTO.builder()
				.statusCode(HttpStatus.OK.value())
				.status("Success")
				.response((product !=null)? product : "No Product found")
				.build();
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(rs);
	}
	

	@GetMapping("/getProductByName/{name}")
	public  ResponseEntity<ResponseDTO> getAllProductsByName(@PathVariable String  name){
		var response = productService.getAllProductsByName(name);
		HttpHeaders responseHeaders = new HttpHeaders();
		ResponseDTO rs = ResponseDTO.builder()
				.statusCode(HttpStatus.OK.value())
				.status("Success")
				.response(response)
				.build();
		return ResponseEntity.status(HttpStatus.OK).headers(responseHeaders).body(rs);
	}
}
 