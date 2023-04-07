package com.programming_arm.orderservice.Dto.convertDto;

import com.programming_arm.orderservice.Dto.OderLineItemsDto;
import com.programming_arm.orderservice.Model.OderLineItems;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OderLineItemsDtoConverter {

    public OderLineItems convertToOderLineItems(OderLineItemsDto from){
        return new OderLineItems(
                from.getSkuCode(),
                from.getPrice(),
                from.getQuantity()
        );
    }
    public OderLineItemsDto convertToOderLineItemsDto(OderLineItems from){
        return new OderLineItemsDto(
                from.getId(),
                from.getSkuCode(),
                from.getPrice(),
                from.getQuantity()
        );
    }
}
