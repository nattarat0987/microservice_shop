package com.programming_arm.inventoryservice.Repositoty;

import com.programming_arm.inventoryservice.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public  interface InventoryRepository extends JpaRepository<Inventory,String> {

    Optional<Inventory> findBySkuCode(String skucode);
}
