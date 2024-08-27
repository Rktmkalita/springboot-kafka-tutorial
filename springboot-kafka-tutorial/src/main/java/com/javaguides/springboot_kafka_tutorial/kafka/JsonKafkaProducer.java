package com.javaguides.springboot_kafka_tutorial.kafka;

import com.javaguides.springboot_kafka_tutorial.model.User;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JsonKafkaProducer {

    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user){
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC,"javaguides_json")
                .build();
        kafkaTemplate.send(message);
    }
}
