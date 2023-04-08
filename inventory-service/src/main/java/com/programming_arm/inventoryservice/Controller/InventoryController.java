package com.programming_arm.inventoryservice.Controller;

import com.programming_arm.inventoryservice.Dto.InventoryResponse;
import com.programming_arm.inventoryservice.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    final private InventoryService inventoryService;


    // TODO http://localhost:7000/api/inventory?sku-code=Iphone_14Pro
    // TODO http://localhost:7000/api/inventory?sku-code=Iphone_14Pro&sku-code=Iphone_15Pro
    @GetMapping()
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam("sku-code") List<String> skuCode) {
        return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
    }




}
