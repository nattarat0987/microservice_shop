package com.programming_arm.orderservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@Table(name = "tb_order_line_items")
@AllArgsConstructor
@NoArgsConstructor
public class OderLineItems extends BaseEntity {

    private String skuCode; // code สินค้าที่ไม่ซ้ากัน
    private BigDecimal price;
    private Integer quantity; //ปริมาณ

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    public OderLineItems(String skuCode, BigDecimal price, Integer quantity) {
        this.skuCode = skuCode;
        this.price = price;
        this.quantity = quantity;
    }

}
