package com.deliveryboy.deliveryboy.controller;

import com.deliveryboy.deliveryboy.entity.Order;
import com.deliveryboy.deliveryboy.service.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/location")
public class LocationController {

    private final KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestBody Order order) {
//        kafkaService.updateLocation("(" + Math.round(Math.random()*100) +  ", "
//                + Math.round(Math.random()*100) +  ")");
        kafkaService.updateLocation(order);
        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }


}
