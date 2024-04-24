package com.devsm.ecommerce.domain.orderproduct.service;

import com.devsm.ecommerce.domain.orderproduct.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderProductService {
    private final OrderProductRepository orderProductRepository;
}
