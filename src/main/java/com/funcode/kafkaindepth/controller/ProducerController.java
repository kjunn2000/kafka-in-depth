package com.funcode.kafkaindepth.controller;

import com.funcode.kafkaindepth.dto.KafkaMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class ProducerController {
    private final KafkaTemplate<String, String> template;

    public ProducerController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @PostMapping
    public void addToKafka(@RequestBody KafkaMessage message) {
        template.send("funCode", message.value());
    }
}
