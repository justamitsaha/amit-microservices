package com.saha.amit.productServices.service;

import com.saha.amit.productServices.DTO.ProductRequestDTO;
import com.saha.amit.productServices.model.Product;
import com.saha.amit.productServices.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(ProductRequestDTO productRequest) {
        Product product = Product
                .builder()
                .name(productRequest.getName())
                .srearchName(productRequest.getName().toLowerCase())
                .description(productRequest.getDescription())
                .prise(productRequest.getPrise())
                .build();
        this.productRepository.insert(product);
    }

    public Product getProductById(String id) {
        Optional<Product> opt = productRepository.getProductbyId(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

    public List<Product> getAllProductsByName(String name) {
        return productRepository.getAllProductsByName(name);
    }
}
