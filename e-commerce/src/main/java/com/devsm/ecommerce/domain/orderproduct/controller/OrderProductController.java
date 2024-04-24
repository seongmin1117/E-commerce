package com.devsm.ecommerce.domain.orderproduct.controller;

import com.devsm.ecommerce.domain.orderproduct.service.OrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order-product")
public class OrderProductController {

    private final OrderProductService orderProductService;
}
