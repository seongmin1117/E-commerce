package com.devsm.ecommerce.domain.orderproduct.repository;

import com.devsm.ecommerce.domain.orderproduct.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
