package com.programming_arm.productservice.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseProductDto {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
