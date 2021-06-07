package com.cotiviti.moviereservation.ticket.dto;

import java.math.BigDecimal;

public interface TotalTicketDto {
    String getMovieName();

    Integer getTotalTickets();

    Integer getAvailableTickets();

    BigDecimal getTicketPrice();
}
