package com.demo.collectionapi.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderDeserializer implements Deserializer<OrderPayloadRequest> {
    private final ObjectMapper objectMapper;

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public OrderPayloadRequest deserialize(String s, byte[] bytes) {
        return null;
    }

    @Override
    public OrderPayloadRequest deserialize(String topic, Headers headers, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), OrderPayloadRequest.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
