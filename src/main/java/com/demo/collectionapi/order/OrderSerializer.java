package com.demo.collectionapi.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@NoArgsConstructor
public class OrderSerializer implements Serializer<OrderPayloadRequest> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, OrderPayloadRequest orderPayloadRequest) {
        try {
            if (orderPayloadRequest == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(orderPayloadRequest);
        } catch (Exception e) {
            throw new OrderSerializationException();
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, OrderPayloadRequest data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
