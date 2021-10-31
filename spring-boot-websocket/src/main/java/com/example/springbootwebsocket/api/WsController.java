package com.example.springbootwebsocket.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/ws")
    //@SendTo(value = "/topic")
    //@SendToUser(value = "/topic")
    public void wsEndPoint(@Payload WSMessage wsMessage) {
        System.out.println("wsEndPoint");
        System.out.println("wsMessage :" + wsMessage.toString());
        messagingTemplate.convertAndSend("/topic",wsMessage);
    }
}
