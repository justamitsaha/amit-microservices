package com.saha.amit.inventoryService.service;

import com.netflix.discovery.EurekaClient;
import com.saha.amit.inventoryService.DTO.ResponseDTO;
import com.saha.amit.inventoryService.config.InventoryUtil;
import com.saha.amit.inventoryService.model.Inventory;
import com.saha.amit.inventoryService.repositiry.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.saha.amit.inventoryService.DTO.AddInventoryDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryService {
    private final WebClient.Builder webClientBuilder;
    @Autowired
    InventoryRepository inventoryRepository;

    public void addInventory(AddInventoryDTO inventoryDTO) {
        ResponseDTO response = webClientBuilder.build().get()
                .uri(InventoryUtil.PRODUCT_SERVICE_HOST+InventoryUtil.GET_PRODUCT_BY_ID + inventoryDTO.getProductId())
                .retrieve().bodyToMono(ResponseDTO.class)
                .block();
        if (response.getStatusCode() == HttpStatus.OK.value()) {
            System.out.println("Inventory Service --> " + inventoryDTO.getProductId());
            Inventory inventory = Inventory
                    .builder()
                    .productId(inventoryDTO.getProductId())
                    .classificationName(inventoryDTO.getInventoryClassificationName())
                    .classification(inventoryDTO.getInventoryClassification())
                    .inventoryCount(inventoryDTO.getInventoryCount())
                    .build();
            inventoryRepository.insert(inventory);
        } else {
            System.out.println("Product doesn't exist");
        }
    }
}
