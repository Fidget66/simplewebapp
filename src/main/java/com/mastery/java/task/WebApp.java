package com.mastery.java.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@EnableKafka
public class WebApp {

    @KafkaListener(topics="test")
    public void msgListener(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}