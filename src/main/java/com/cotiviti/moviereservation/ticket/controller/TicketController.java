package com.cotiviti.moviereservation.ticket.controller;

import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.ticket.dto.TicketDto;
import com.cotiviti.moviereservation.ticket.dto.TotalTicketDto;
import com.cotiviti.moviereservation.ticket.repo.TicketRepository;
import com.cotiviti.moviereservation.ticket.service.TicketService;
import com.cotiviti.moviereservation.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketRepository ticketRepository;
    private final TicketService ticketService;

    public TicketController(TicketRepository ticketRepository, TicketService ticketService) {
        this.ticketRepository = ticketRepository;
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody TicketDto ticketDto){
        return new Response().success(ticketService.create(ticketDto));
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<TicketDto> findTicketById(@PathVariable("ticketId") Long ticketId){
        return new ResponseEntity<>(ticketService.findTicketById(ticketId), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TicketDto>> findAll(){
        return new ResponseEntity<>(ticketService.findAll(),HttpStatus.CREATED);
    }

    @GetMapping("/movieTickets")
    public ResponseEntity<List<Map<String,Object>>> findTicketsOfMovie(){
        return new ResponseEntity<>(ticketService.findTicketOfMovie(),HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<TicketDto>> findAvailableTicket() {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.findTicketByTicketStatus(TicketStatus.AVAILABLE));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ArrayList<>());
        }
    }
}
