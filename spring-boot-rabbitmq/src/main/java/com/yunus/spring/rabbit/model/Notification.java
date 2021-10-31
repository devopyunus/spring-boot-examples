package com.yunus.spring.rabbit.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notification implements Serializable {

    private String notifiationId;
    private Date insertedDate;
    private Boolean seen;
    private String message;
}
