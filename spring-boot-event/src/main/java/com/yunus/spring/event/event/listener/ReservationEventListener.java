package com.yunus.spring.event.event.listener;

import com.yunus.spring.event.event.ReservationCreatedEvent;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            log.error("e:{}", e);
        }
        log.info("EventListener : {}" ,reservationCreatedEvent);
    }
}
