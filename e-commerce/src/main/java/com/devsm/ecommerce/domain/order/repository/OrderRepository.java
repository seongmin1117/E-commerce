package com.devsm.ecommerce.domain.order.repository;

import com.devsm.ecommerce.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
