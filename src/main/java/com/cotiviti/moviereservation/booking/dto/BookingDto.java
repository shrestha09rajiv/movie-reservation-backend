package com.cotiviti.moviereservation.booking.dto;

import com.cotiviti.moviereservation.enums.BookingStatus;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingDto {
    private Long id;

    private BigDecimal totalCost;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

//    private Long paymentMethodId;

    private List<Ticket> ticketList;

    private Long movieId;

    private Long userId;

    private String email;

    private String name;

    private String phoneNumber;

    private Date bookedDate;

    private Integer totalTickets;

    private String movieName;
}
