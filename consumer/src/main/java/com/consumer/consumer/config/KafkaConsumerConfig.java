package com.consumer.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaConsumerConfig {

    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME , groupId = AppConstants.LOCATION_CONSUMER_GROUP_ID)
    public void updatedLocation(String location) {
        log.info("consumer-config :: {}", location);
    }
}
