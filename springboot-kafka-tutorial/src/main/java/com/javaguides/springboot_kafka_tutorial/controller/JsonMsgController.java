package com.javaguides.springboot_kafka_tutorial.controller;

import com.javaguides.springboot_kafka_tutorial.kafka.JsonKafkaProducer;
import com.javaguides.springboot_kafka_tutorial.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
@Slf4j
public class JsonMsgController {

    private static final Logger log = LoggerFactory.getLogger(JsonMsgController.class);
    private JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        log.info("User from frontend: {}",user.toString());
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json User sent to kafka topic");
    }

}
