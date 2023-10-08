package com.funcode.kafkaindepth.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "funCode", groupId = "groupId")
    public void logValue(String data) {
        System.out.println("Received data from funCode topic -> " + data);
    }
}
