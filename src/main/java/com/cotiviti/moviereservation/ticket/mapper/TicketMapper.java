package com.cotiviti.moviereservation.ticket.mapper;

import com.cotiviti.moviereservation.ticket.domain.Ticket;
import com.cotiviti.moviereservation.ticket.dto.TicketDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface TicketMapper {
    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(source = "movieId", target = "movie.id")
    Ticket toEntity(TicketDto ticketDto);

    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "movie.movieName", target = "movieName")
    @Mapping(source = "movie.totalTickets", target = "totalTickets")
    @Mapping(source = "movie.availableTickets", target = "availableTickets")
    @Mapping(source = "movie.genre", target = "genre")
    @Mapping(source = "movie.releaseDate", target = "releaseDate", dateFormat = "yyyy-MM-dd hh:mm:ss")
    TicketDto toDto(Ticket ticket);

    List<TicketDto> toDto(List<Ticket> ticketList);
}
