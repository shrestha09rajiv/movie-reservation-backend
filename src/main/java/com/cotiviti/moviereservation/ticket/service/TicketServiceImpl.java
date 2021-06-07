package com.cotiviti.moviereservation.ticket.service;

import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.movie.domain.Movie;
import com.cotiviti.moviereservation.movie.repo.MovieRepository;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import com.cotiviti.moviereservation.ticket.dto.TicketDto;
import com.cotiviti.moviereservation.ticket.mapper.TicketMapper;
import com.cotiviti.moviereservation.ticket.repo.TicketRepository;
import com.cotiviti.moviereservation.ticket.util.TicketNumberGenerator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository ticketRepository;
    private final MovieRepository movieRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, MovieRepository movieRepository) {
        this.ticketRepository = ticketRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public TicketDto create(TicketDto ticketDto) {
        TicketDto ticketDt = new TicketDto();
        Ticket ticket = ticketRepository.save(TicketMapper.INSTANCE.toEntity(ticketDto));
        if(ticket != null){
            ticketDt = TicketMapper.INSTANCE.toDto(ticket);
        }
        return ticketDt;
    }

    @Override
    public List<TicketDto> findAll() {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        ticketList = ticketRepository.findAll();
        if(!ticketList.isEmpty()){
            ticketDtoList = TicketMapper.INSTANCE.toDto(ticketList);
        }
        return ticketDtoList;
    }

    @Override
    public List<TicketDto> findTicketByTicketStatus(TicketStatus ticketStatus) {
        List<TicketDto> ticketDtos = new ArrayList<>();
        List<Ticket> ticketList = new ArrayList<>();
        ticketList = ticketRepository.findTicketsByTicketStatus(ticketStatus);
        if(!ticketList.isEmpty()){
            ticketDtos = TicketMapper.INSTANCE.toDto(ticketList);
        }
        return ticketDtos;
    }

    @Override
    public TicketDto findTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        TicketDto ticketDto = TicketMapper.INSTANCE.toDto(ticket.get());
        return ticketDto;
    }

    @Override
    @Transactional
    public TicketDto createTicket(TicketDto ticketDto, Long movieId) {
        if (ticketDto != null) {
            List<TicketDto> tickets = TicketNumberGenerator.createTicketNumberAndPopulateDto(ticketDto);
            if (!tickets.isEmpty()) {
                tickets.forEach(ticket -> {
                    ticket.setMovieId(movieId);
                    ticketRepository.save(TicketMapper.INSTANCE.toEntity(ticket));
                });
            }
        }
        return null;
    }

    @Override
    public List<Map<String,Object>> findTicketOfMovie() {
        return ticketRepository.findTicketOfMovie();
    }

    @Override
    public List<Ticket> findTicketNumberByStatusForMovie(TicketStatus ticketStatus, Long movieId) {
        return ticketRepository.findTicketsByTicketStatusAndMovie_Id(ticketStatus,movieId);
    }

    @Override
    public List<Ticket> findTicketOfTicketNumbers(List<Ticket> ticketList,int totalNumberOfTickets) {
        return TicketNumberGenerator.getRandomElement(ticketList, totalNumberOfTickets);
    }

    @Override
    @Transactional
    public void updateTickets(List<Ticket> tickets) {
        Movie movie = tickets.get(0).getMovie();
        tickets.forEach(ticket -> {
            ticket.setTicketStatus(TicketStatus.BOOKED);
            ticketRepository.save(ticket);
        });
        movie.setAvailableTickets(movie.getAvailableTickets() - tickets.size());
        movieRepository.save(movie);
    }
}
