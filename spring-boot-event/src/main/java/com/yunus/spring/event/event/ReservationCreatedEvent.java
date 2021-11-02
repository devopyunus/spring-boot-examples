package com.yunus.spring.event.event;

import com.yunus.spring.event.model.ReservationRequest;
import org.springframework.context.ApplicationEvent;

public class ReservationCreatedEvent extends ApplicationEvent {

    public ReservationCreatedEvent(ReservationRequest reservationRequest) {
        super(reservationRequest);
    }
}
