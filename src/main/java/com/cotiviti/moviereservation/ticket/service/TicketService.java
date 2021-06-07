package com.cotiviti.moviereservation.ticket.service;

import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import com.cotiviti.moviereservation.ticket.dto.TicketDto;
import com.cotiviti.moviereservation.ticket.dto.TotalTicketDto;

import java.util.List;
import java.util.Map;

public interface TicketService {
    TicketDto create(TicketDto ticketDto);
    List<TicketDto> findAll();
    List<TicketDto> findTicketByTicketStatus(TicketStatus ticketStatus);
    TicketDto findTicketById(Long id);
    TicketDto createTicket(TicketDto ticketDto,Long movieId);
    List<Map<String,Object>> findTicketOfMovie();
    List<Ticket> findTicketNumberByStatusForMovie(TicketStatus ticketStatus,Long movieId);
    List<Ticket> findTicketOfTicketNumbers(List<Ticket> ticketList,int totalNumberOfTickets);
    void updateTickets(List<Ticket> tickets);
}
