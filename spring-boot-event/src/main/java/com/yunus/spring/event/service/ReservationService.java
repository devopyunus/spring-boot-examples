package com.yunus.spring.event.service;

import com.yunus.spring.event.event.ReservationCreatedEvent;
import com.yunus.spring.event.model.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Async
    public void publishReservationEvent(ReservationRequest reservationRequest){
        eventPublisher.publishEvent(new ReservationCreatedEvent(reservationRequest));
    }
}
