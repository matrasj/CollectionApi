package com.demo.collectionapi.api;

import com.demo.collectionapi.order.OrderPayloadRequest;
import com.demo.collectionapi.order.OrderPayloadResponse;
import com.demo.collectionapi.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value = "", produces = "application/json")
    public OrderPayloadResponse makeOrderEvent(@RequestBody OrderPayloadRequest orderPayloadRequest) {
        return this.orderService.publishOrderEvent(orderPayloadRequest);
    }
}
