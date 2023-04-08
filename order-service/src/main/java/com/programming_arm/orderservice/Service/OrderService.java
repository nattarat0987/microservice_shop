package com.programming_arm.orderservice.Service;

import com.programming_arm.orderservice.Dto.OderRequestDto;
import com.programming_arm.orderservice.Exception.OrderException;

public interface OrderService {

    void placeOrder(OderRequestDto oderRequestDto) throws OrderException;
}
