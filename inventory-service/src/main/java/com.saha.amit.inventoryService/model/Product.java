package com.saha.amit.inventoryService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("products")
public class Product {

    private String srearchName;
    private String description;
    private Double prise;
    private float rating;
    private Date productAddedDate;
}
