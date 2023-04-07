package com.programming_arm.orderservice.Service.ServiceImpl;

import com.programming_arm.orderservice.Dto.OderRequestDto;
import com.programming_arm.orderservice.Dto.convertDto.OderLineItemsDtoConverter;
import com.programming_arm.orderservice.Model.OderLineItems;
import com.programming_arm.orderservice.Model.Order;
import com.programming_arm.orderservice.Repository.OrderRepository;
import com.programming_arm.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderRepository orderRepository;
    final private OderLineItemsDtoConverter oderLineItemsDtoConverter;


    @Transactional
    @Override   // สถานที่การสั่งซื้อ
    public void placeOrder(OderRequestDto oderRequestDto) {
        Order order = new Order();
        // create order
        order.setOrderNumber(UUID.randomUUID().toString());

        // create oderLineItems
        List<OderLineItems> oderLineItems = oderRequestDto.getOderLineItemsDto()
                .stream()
                .map(oderLineItemsDtoConverter::convertToOderLineItems)
                .peek(oderLineItem -> oderLineItem.setOrder(order))
                .collect(Collectors.toList());
        order.setOderLineItems(oderLineItems);
        orderRepository.save(order);
        log.info("order: {}  ",order.getId());
    }
}
