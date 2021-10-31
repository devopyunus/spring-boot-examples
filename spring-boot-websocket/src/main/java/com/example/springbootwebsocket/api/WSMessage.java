package com.example.springbootwebsocket.api;

import lombok.Data;

@Data
public class WSMessage {
    private String sender;
    private String message;
}
