package com.demo.collectionapi.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfig {
    private final ConfigProperties configProperties;

    @Bean
    public NewTopic ordersTopic() {
        return TopicBuilder
                .name(this.configProperties.getOrderTopicName())
                .build();
    }
}
