package com.programming_arm.inventoryservice;

import com.programming_arm.inventoryservice.Model.Inventory;
import com.programming_arm.inventoryservice.Repositoty.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}



	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Iphone_14Pro");
			inventory1.setQuantity(100);

			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("Iphone_15Pro");
			inventory2.setQuantity(0);

			Inventory inventory3 = new Inventory();
			inventory3.setSkuCode("Iphone_16Pro");
			inventory3.setQuantity(10);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);
		};
	}

}
