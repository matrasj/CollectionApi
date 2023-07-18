package com.demo.collectionapi.infrastructure;

import com.demo.collectionapi.config.ConfigProperties;
import com.demo.collectionapi.product.OrderPayloadRequest;
import com.demo.collectionapi.product.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer implements OrderService {
    private final ConfigProperties configProperties;


    @Override
    public void publishOrderEvent(OrderPayloadRequest orderPayloadRequest) {
        
    }
}
