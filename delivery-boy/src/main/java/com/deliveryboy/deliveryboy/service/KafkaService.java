package com.deliveryboy.deliveryboy.service;

import com.deliveryboy.deliveryboy.config.AppConstants;
import com.deliveryboy.deliveryboy.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, Order>kafkaTemplate;
    public Boolean updateLocation(Order location) {
//        Gson gson = new Gson();
//        String jsonString2 = gson.toJson(location);
//        this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,
//                jsonString2);
        kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,
                location);
        log.info("message produced");
        return true;
    }
}
