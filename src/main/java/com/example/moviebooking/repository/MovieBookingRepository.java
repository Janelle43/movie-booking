package com.example.moviebooking.repository;

import com.example.moviebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieBookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT * FROM booking b WHERE b.account_id=?1", nativeQuery = true)
    List<Booking> findAllUserBookings(Long id);

}
