package com.demo.collectionapi.config;

import com.demo.collectionapi.order.OrderPayloadRequest;
import com.demo.collectionapi.order.OrderSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderSerializer.class);

        return properties;
    }

    @Bean
    public ProducerFactory<String, OrderPayloadRequest> producerFactory() {
        return new DefaultKafkaProducerFactory<>(this.producerConfig());
    }

    @Bean
    public KafkaTemplate<String, OrderPayloadRequest> kafkaTemplate() {
        return new KafkaTemplate<>(this.producerFactory());
    }

}
