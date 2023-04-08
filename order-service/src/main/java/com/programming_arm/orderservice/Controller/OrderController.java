package com.programming_arm.orderservice.Controller;

import com.programming_arm.orderservice.Dto.OderRequestDto;
import com.programming_arm.orderservice.Exception.BaseException;
import com.programming_arm.orderservice.Exception.OrderException;
import com.programming_arm.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    final private OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<String>  placeOrder(@RequestBody OderRequestDto oderRequestDto) throws BaseException {
        orderService.placeOrder(oderRequestDto);
        return new ResponseEntity<>("Order Placed Successfully", HttpStatus.OK);
    }
}

