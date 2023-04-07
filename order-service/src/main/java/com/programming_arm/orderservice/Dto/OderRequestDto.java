package com.programming_arm.orderservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OderRequestDto {

    private List<OderLineItemsDto>  oderLineItemsDto;
}
