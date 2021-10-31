package com.yunus.spring.rabbit.listener;

import com.yunus.spring.rabbit.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "rabbit-test-queue")
    public void readMessage(Notification notification){
        System.out.println("Reading message......");
        System.out.println(notification.toString());
    }
}
