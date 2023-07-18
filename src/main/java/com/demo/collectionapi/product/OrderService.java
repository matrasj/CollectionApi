package com.demo.collectionapi.product;

public interface OrderService {
    void publishOrderEvent(OrderPayloadRequest orderPayloadRequest);
}
