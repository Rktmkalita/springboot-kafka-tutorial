package com.javaguides.springboot_kafka_tutorial.kafka;

import com.javaguides.springboot_kafka_tutorial.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.internals.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaguides_json", groupId = "myGroup")
    public void receiveMessage(User user){
        log.info("User received in consumer: {}", user.toString());
    }
}
