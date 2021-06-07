package com.cotiviti.moviereservation.booking.dto;

import lombok.Data;

@Data
public class PaymentDetailsDto {
    private Long bookingId;
    private Long paymentMethod;
}
