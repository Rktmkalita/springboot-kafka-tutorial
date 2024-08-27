package com.javaguides.springboot_kafka_tutorial.kafka;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(StringKafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void receiveMessage(String message){
        log.info("Message received {}",message);
    }
}
