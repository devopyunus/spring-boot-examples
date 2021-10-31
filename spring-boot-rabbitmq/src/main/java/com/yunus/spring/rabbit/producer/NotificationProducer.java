package com.yunus.spring.rabbit.producer;

import com.yunus.spring.rabbit.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init() {

        Notification notification = new Notification();
        notification.setNotifiationId(UUID.randomUUID().toString());
        notification.setInsertedDate(new Date());
        notification.setMessage("Hello Rabbit");
        notification.setSeen(false);
        send(notification);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Notification notification){
        System.out.println("Send notification id :"+notification.getNotifiationId());
        System.out.println("exchangeName : " + exchangeName);
        System.out.println("routingName : " + routingName);
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);

    }
}
