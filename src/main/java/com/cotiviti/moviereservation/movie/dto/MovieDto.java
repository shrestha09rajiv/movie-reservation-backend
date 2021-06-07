package com.cotiviti.moviereservation.movie.dto;

import com.cotiviti.moviereservation.enums.GenreEnum;
import com.cotiviti.moviereservation.ticket.dto.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long id;

    private String movieName;

    private GenreEnum genre;

    private Date releaseDate;

    private TicketDto ticketDto;

    private Long userId;

    private Integer totalTickets;

    private Integer availableTickets;

}

