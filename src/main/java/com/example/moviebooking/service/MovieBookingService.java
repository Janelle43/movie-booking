package com.example.moviebooking.service;

import com.example.moviebooking.model.AccountBookings;
import com.example.moviebooking.model.Booking;
import com.example.moviebooking.repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieBookingService {

    @Autowired
    private MovieBookingRepository repository;

    public AccountBookings getUserBookings(Long userId) {
        List<Booking> bookings = repository.findAllUserBookings(userId);

        AccountBookings accountBookings = new AccountBookings();
        accountBookings.setBookings(bookings);
        return accountBookings;
    }
}
