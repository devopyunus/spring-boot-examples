package com.yunus.spring.rabbit;

import com.yunus.spring.rabbit.model.Notification;
import com.yunus.spring.rabbit.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class RabbitApplication {

    @Autowired
    private NotificationProducer notificationProducer;


    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class,args);
    }
}
