package com.programming_arm.orderservice.Repository;

import com.programming_arm.orderservice.Model.OderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemsRepository extends JpaRepository<OderLineItems,String> {
}
