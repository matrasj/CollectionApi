package com.demo.collectionapi.infrastructure;

import com.demo.collectionapi.config.ConfigProperties;
import com.demo.collectionapi.infrastructure.helpers.RequestStatus;
import com.demo.collectionapi.order.OrderPayloadRequest;
import com.demo.collectionapi.order.OrderPayloadResponse;
import com.demo.collectionapi.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer implements OrderService {
    private final ConfigProperties configProperties;
    private final KafkaTemplate<String, OrderPayloadRequest> ordersKafkaTemplate;


    @Override
    public OrderPayloadResponse publishOrderEvent(OrderPayloadRequest orderPayloadRequest) {
        try {
            this.ordersKafkaTemplate.send("orders", orderPayloadRequest);

            return OrderPayloadResponse.builder()
                    .requestStatus(RequestStatus.SUCCESS)
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return OrderPayloadResponse.builder()
                    .requestStatus(RequestStatus.FAILURE)
                    .build();
        }
    }
}
