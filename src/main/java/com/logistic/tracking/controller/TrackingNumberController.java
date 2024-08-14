package com.logistic.tracking.controller;

import com.logistic.tracking.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackingNumberController {

    @Autowired
    private TrackingNumberService trackingNumberService;

    @GetMapping("/tracking-number")
    public String generateTrackingNumber() {
         return trackingNumberService.generateTrackingNumber();
    }
}
