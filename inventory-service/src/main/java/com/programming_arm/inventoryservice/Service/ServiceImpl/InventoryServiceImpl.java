package com.programming_arm.inventoryservice.Service.ServiceImpl;

import com.programming_arm.inventoryservice.Repositoty.InventoryRepository;
import com.programming_arm.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    final private  InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @Override
    public Boolean isInStock(String skuCode) {
        //TODO true หากมีข้อมูล และ false
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
