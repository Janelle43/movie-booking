package com.example.moviebooking.controller;

import com.example.moviebooking.model.Booking;
import com.example.moviebooking.service.MovieBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookingData")
public class MovieBookingController {

    @Autowired
    private MovieBookingService service;
    private static final String TOPIC = "movie_book";

    @Autowired
    private KafkaTemplate<String, Booking> kafkaTemplate;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getBookingData(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getUserBookings(userId));
    }

    @GetMapping
    public String bookMovie(@RequestParam("userId") Long userId,
                            @RequestParam("movieId") Long movieId) {

        service.addBooking(userId, movieId);


        kafkaTemplate.send(TOPIC, new Booking(1L, userId, movieId));

        return "Your request sent successful!";
    }


}
