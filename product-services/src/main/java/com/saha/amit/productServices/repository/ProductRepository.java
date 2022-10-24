package com.saha.amit.productServices.repository;

import com.saha.amit.productServices.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
	@Query("{'_id': ?0}")
	Optional<Product> getProductbyId(String id);

	@Query("{product_search_name: {$regex: ?0}}")
	List<Product> getAllProductsByName(String regex);

	
	/*
	 * Trying to replicate the query {"product_name" : {$regex:/redmi/i}}  which works from mongo compass
	 * @Query("{product_name: {$regex: /?0/i}}") List<Product>
	 * getAllProductsByName(String regex);
	 */
}
