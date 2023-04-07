package com.programming_arm.productservice.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
