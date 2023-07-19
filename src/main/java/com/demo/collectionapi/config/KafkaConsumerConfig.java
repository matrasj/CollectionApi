package com.demo.collectionapi.config;

import com.demo.collectionapi.order.OrderDeserializer;
import com.demo.collectionapi.order.OrderPayloadRequest;
import com.demo.collectionapi.order.OrderPayloadResponse;
import com.demo.collectionapi.order.OrderSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OrderSerializer.class);

        return properties;
    }

    @Bean
    public ConsumerFactory<String, OrderPayloadRequest> consumerFactor() {
        return new DefaultKafkaConsumerFactory<>(this.consumerConfig());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, OrderPayloadRequest>> factory() {
        ConcurrentKafkaListenerContainerFactory<String, OrderPayloadRequest>
                objectObjectConcurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        objectObjectConcurrentKafkaListenerContainerFactory.setConsumerFactory(this.consumerFactor());

        return objectObjectConcurrentKafkaListenerContainerFactory;
    }
}
