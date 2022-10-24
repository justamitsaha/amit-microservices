package com.saha.amit.inventoryService.service;

import com.netflix.discovery.EurekaClient;
import com.saha.amit.inventoryService.config.InventoryUtil;
import com.saha.amit.inventoryService.model.Inventory;
import com.saha.amit.inventoryService.repositiry.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        Boolean result = webClientBuilder.build().get()
                .uri(InventoryUtil.PRODUCT_SERVICE_HOST+InventoryUtil.IS_PRODUCT_PRESNT + inventoryDTO.getProductId())
                .retrieve().bodyToMono(Boolean.class)
                .block();
        if (result) {
            System.out.println("Inventory Service --> " + inventoryDTO.getProductId());
            Inventory inventory = Inventory
                    .builder()
                    .productId(inventoryDTO.getProductId())
                    .classificationName(inventoryDTO.getInventoryClassificationName())
                    .classification(inventoryDTO.getInventoryClassification())
                    .inventoryCount(inventoryDTO.getInventoryCount())
                    .build();
            inventoryRepository.insert(inventory);
        }
    }
}
