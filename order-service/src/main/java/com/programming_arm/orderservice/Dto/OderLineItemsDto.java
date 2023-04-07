package com.programming_arm.orderservice.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OderLineItemsDto {
    private String id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
