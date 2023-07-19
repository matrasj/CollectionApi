package com.demo.collectionapi.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ConfigProperties {
    @Value(value = "kafka.topics.orders")
    private String orderTopicName;
}
