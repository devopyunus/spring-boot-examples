package com.yunus.spring.event.api;

import com.yunus.spring.event.model.ReservationRequest;
import com.yunus.spring.event.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
@Slf4j
public class ReservationApi {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void reserve(@RequestBody ReservationRequest reservationRequest){

        reservationService.publishReservationEvent(reservationRequest);
        log.info("Reservation is success. It is started.");

    }

}
