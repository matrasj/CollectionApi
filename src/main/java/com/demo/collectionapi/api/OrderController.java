package com.demo.collectionapi.api;

import com.demo.collectionapi.product.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderService orderService;
}
