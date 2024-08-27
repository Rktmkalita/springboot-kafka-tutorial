package com.javaguides.springboot_kafka_tutorial.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private int id;
    private String firstName;
    private String lastName;
}
