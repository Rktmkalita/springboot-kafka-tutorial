package com.javaguides.springboot_kafka_tutorial.kafka;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringKafkaProducer {
    private static final Logger log = LoggerFactory.getLogger(StringKafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;

    public StringKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        log.info("Message send {}", message);
        kafkaTemplate.send("javaguides",message);
    }
}
