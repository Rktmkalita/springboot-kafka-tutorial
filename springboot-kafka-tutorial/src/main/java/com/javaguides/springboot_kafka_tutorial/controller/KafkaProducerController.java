package com.javaguides.springboot_kafka_tutorial.controller;

import com.javaguides.springboot_kafka_tutorial.kafka.StringKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@Slf4j
public class KafkaProducerController {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerController.class);

    @Autowired
    private StringKafkaProducer stringKafkaProducer;

//    http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        log.info("Message from frontend: "+message);
        stringKafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent!!!");
    }
}
