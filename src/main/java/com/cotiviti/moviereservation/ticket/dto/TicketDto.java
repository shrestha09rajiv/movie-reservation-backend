package com.cotiviti.moviereservation.ticket.dto;

import com.cotiviti.moviereservation.enums.GenreEnum;
import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long id;

    private String ticketNumber;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    private BigDecimal ticketPrice;

    private Integer totalTickets;

    private Long movieId;

    private String movieName;

    private Integer availableTickets;

    private GenreEnum genre;

    private Date releaseDate;
}
