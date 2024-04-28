package com.consumer.consumer.service;

import com.consumer.consumer.config.AppConstants;
import com.consumer.consumer.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaService {
    @KafkaListener(topics = AppConstants.LOCATION_TOPIC_NAME, groupId = AppConstants.LOCATION_CONSUMER_GROUP_ID, containerFactory = "userKafkaListenerFactory")
    public void listenWithHeaders(
            @Payload Order message,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
       log.info("received {}", message);
    }
}
