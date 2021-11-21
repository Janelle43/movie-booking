package com.example.moviebooking.controller;

import com.example.moviebooking.service.MovieBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookingData")
public class MovieBookingController {

    @Autowired
    private MovieBookingService service;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getBookingData(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getUserBookings(userId));
    }
}
