package com.cotiviti.moviereservation.booking.repo;

import com.cotiviti.moviereservation.booking.domain.Booking;
import com.cotiviti.moviereservation.booking.dto.BookingDto;
import com.cotiviti.moviereservation.enums.BookingStatus;
import com.cotiviti.moviereservation.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<BookingDto> findBookingsByBookingStatus(BookingStatus bookingStatus);

    @Query(value = "SELECT count(id) AS count FROM booking where booking_status = 'BOOKED'", nativeQuery = true)
    Map<String, Object> getTotalBookings();

    @Query(value = "SELECT sum(total_cost) AS income FROM booking where booking_status = 'BOOKED'", nativeQuery = true)
    Map<String, Object> getTotalIncome();

    @Query(value = "SELECT DATE_FORMAT(booked_date,'%M %Y') AS Month,COUNT(id) AS count FROM booking WHERE booking_status = 'BOOKED' GROUP BY month(booked_date)", nativeQuery = true)
    List<Map> totalMonthlyBooking();

    @Query(value = "SELECT DATE_FORMAT(booked_date,'%M %Y') AS Month,SUM(total_cost) AS total FROM booking WHERE booking_status = 'BOOKED' GROUP BY month(booked_date)", nativeQuery = true)
    List<Map> monthlyIncomeReport();

    Booking findBookingById(Long id);

    @Query("SELECT b FROM Booking b WHERE b.user.id=:userId")
    List<Booking> findBookingByUser(Long userId);
}
