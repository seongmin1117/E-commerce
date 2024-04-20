package com.devsm.ecommerce.domain.order.entity;

import com.devsm.ecommerce.global.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantity;
    private Long order_price;
    private String receiver;
    private String address;
    private String phoneNumber;
}
