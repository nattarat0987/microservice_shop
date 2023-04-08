package com.programming_arm.inventoryservice.Service;

import com.programming_arm.inventoryservice.Dto.InventoryResponse;

import java.util.List;

public interface InventoryService {

    List<InventoryResponse> isInStock(List<String> skuCode);
}
