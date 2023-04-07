package com.programming_arm.orderservice.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "tb_orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {

    private String orderNumber;
    // oneOrder to  ManyOrderItems
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    private List<OderLineItems> oderLineItems;

}
