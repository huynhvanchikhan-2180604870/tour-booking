package com.hock.tour_booking.controller;

import com.hock.tour_booking.dto.reponse.ResponseHandler;
import com.hock.tour_booking.entity.Location;
import com.hock.tour_booking.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RequiredArgsConstructor
@RestController("/api/v2/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<Object> getLocations() {
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, locationService.findAll());
    }
}
