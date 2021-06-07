package com.cotiviti.moviereservation.booking.service;

import com.cotiviti.moviereservation.booking.dto.BookingDto;
import com.cotiviti.moviereservation.booking.dto.BookingPaymentDto;
import com.cotiviti.moviereservation.booking.dto.PaymentDetailsDto;
import com.cotiviti.moviereservation.booking.dto.PaymentRequestDto;
import com.cotiviti.moviereservation.enums.BookingStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface BookingService {

    BookingDto save(BookingDto bookingDto);

    List<BookingDto> findAll();

    List<BookingDto> findPendingBooking(BookingStatus bookingStatus);

    BigDecimal findUnitPrice(Long id);

    BookingDto getBookingInfo(Long bookingId);

    BookingPaymentDto pay(PaymentDetailsDto bookingPaymentDto);

    PaymentRequestDto getById(Long id);

    List<BookingDto> getUserBookingHistory();

    Map<String, Object> dashboardData();
}
