package com.cotiviti.moviereservation.movie.service;

import com.cotiviti.moviereservation.configuration.LoggedInUserDetail;
import com.cotiviti.moviereservation.movie.domain.Movie;
import com.cotiviti.moviereservation.movie.dto.MovieDto;
import com.cotiviti.moviereservation.movie.mapper.MovieMapper;
import com.cotiviti.moviereservation.movie.repo.MovieRepository;
import com.cotiviti.moviereservation.ticket.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class, readOnly = true)
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final TicketService ticketService;

    public MovieServiceImpl(MovieRepository movieRepository, TicketService ticketService) {
        this.movieRepository = movieRepository;
        this.ticketService = ticketService;
    }

    @Override
    @Transactional
    public MovieDto create(MovieDto movieDto) {
        MovieDto movieDt = new MovieDto();
        movieDto.setUserId((Long) LoggedInUserDetail.getLoggedInUserDetail().get("id"));
        movieDto.setAvailableTickets(movieDto.getTotalTickets());
        Movie movie = movieRepository.save(MovieMapper.INSTANCE.toEntity(movieDto));
        if(movie != null){
            movieDt = MovieMapper.INSTANCE.toDto(movie);
        }
        ticketService.createTicket(movieDto.getTicketDto(),movieDt.getId());
        return movieDt;
    }

    @Override
    public List<MovieDto> findAll() {
        List<MovieDto> movieDtoList = new ArrayList<>();
        List<Movie> movieList = new ArrayList<>();
        movieList = movieRepository.findAll();
        if(!movieList.isEmpty()){
            movieDtoList = MovieMapper.INSTANCE.toDto(movieList);
        }
        return movieDtoList;
    }

    @Override
    public MovieDto findMovieById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        MovieDto movieDto = MovieMapper.INSTANCE.toDto(movie.get());
        return movieDto;
    }

    @Override
    public void updateMovie(MovieDto movieDto) {
        movieRepository.save(MovieMapper.INSTANCE.toEntity(movieDto));
    }

    @Override
    public Map<String, Object> getTotalMovies() {
        return movieRepository.getMoviesCount();
    }
}
