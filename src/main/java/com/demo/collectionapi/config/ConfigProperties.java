package com.demo.collectionapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigProperties {
    @Value(value = "kafka.topics.orders")
    private String orderTopicName;
}
