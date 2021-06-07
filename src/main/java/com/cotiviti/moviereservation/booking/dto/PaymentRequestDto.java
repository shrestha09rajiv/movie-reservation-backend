package com.cotiviti.moviereservation.booking.dto;

import com.cotiviti.moviereservation.enums.BookingStatus;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class PaymentRequestDto {
    private Long id;

    private BigDecimal totalCost;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    private Long paymentMethodId;

    private Long movieId;

    private Long userId;

    private String email;

    private String name;

    private String phoneNumber;

    private Integer totalTickets;
}
