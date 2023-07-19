package com.demo.collectionapi.infrastructure;

import com.demo.collectionapi.config.KafkaConsumerConfig;
import com.demo.collectionapi.order.OrderDeserializer;
import com.demo.collectionapi.order.OrderPayloadRequest;
import com.demo.collectionapi.order.OrderPayloadResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Slf4j
@RequiredArgsConstructor
public class Listener {
    private final KafkaConsumerConfig kafkaConsumerConfig;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "orders", groupId = "groupId")
    public void listener(String value) throws JsonProcessingException {
        OrderPayloadRequest object = objectMapper.readValue(value, OrderPayloadRequest.class);
        System.out.println(object.getComments());
        System.out.println(object.getPurchaserFirstName());
        System.out.println(object.getPurchaserLastName());
        System.out.println(object.getProductName());

    }
}
