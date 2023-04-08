package com.programming_arm.orderservice.Service.ServiceImpl;

import com.programming_arm.orderservice.Dto.InventoryResponse;
import com.programming_arm.orderservice.Dto.OderRequestDto;
import com.programming_arm.orderservice.Dto.convertDto.OderLineItemsDtoConverter;
import com.programming_arm.orderservice.Exception.OrderException;
import com.programming_arm.orderservice.Model.OderLineItems;
import com.programming_arm.orderservice.Model.Order;
import com.programming_arm.orderservice.Repository.OrderRepository;
import com.programming_arm.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    final private OrderRepository orderRepository;
    final private OderLineItemsDtoConverter oderLineItemsDtoConverter;
    final private WebClient webClient;

    @Transactional
    @Override   // สถานที่การสั่งซื้อ
    public void placeOrder(OderRequestDto oderRequestDto) throws OrderException {
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

        List<String> skuCodes = order.getOderLineItems()
                .stream()
                .map(OderLineItems::getSkuCode).toList();

        // call Inventory Service
        //stock
        InventoryResponse[] InventoryResultArray = webClient.get()
                .uri("http://localhost:7000/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("sku-code",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        if(ObjectUtils.isEmpty(InventoryResultArray)){
            throw new OrderException("inventory NotFount");
        }
        //ถ้ามีสมาชิกใดๆ ที่ไม่เป็นจริง (false) อย่างน้อยหนึ่งตัว คำสั่ง allMatch จะ return false ทันทีและไม่ตรวจสอบสมาชิกต่อไปแล้ว
        boolean allInStock = Arrays.stream(InventoryResultArray)
                .allMatch(InventoryResponse::isInStock);

        // CheckStock == true
        if (allInStock) {
            orderRepository.save(order);
        } else {
            throw new OrderException("inventory Stock NotFount");
        }
        log.info("order: {}  ", order.getId());
    }
}
