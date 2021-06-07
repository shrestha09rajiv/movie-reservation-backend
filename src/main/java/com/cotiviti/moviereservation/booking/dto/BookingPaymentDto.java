package com.cotiviti.moviereservation.booking.dto;

import com.cotiviti.moviereservation.payment.dto.PaymentMethodDto;
import lombok.Data;

@Data
public class BookingPaymentDto {
    private PaymentMethodDto paymentMethodDto;
    private Long bookingId;
}
