package com.demo.collectionapi.order;

public interface OrderService {
    OrderPayloadResponse publishOrderEvent(OrderPayloadRequest orderPayloadRequest);
}
