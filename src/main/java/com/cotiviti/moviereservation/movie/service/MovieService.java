package com.cotiviti.moviereservation.movie.service;


import com.cotiviti.moviereservation.movie.dto.MovieDto;

import java.util.List;
import java.util.Map;

public interface MovieService {
    MovieDto create(MovieDto movieDto);

    List<MovieDto> findAll();

    MovieDto findMovieById(Long id);

    void updateMovie(MovieDto movieDto);

    Map<String, Object> getTotalMovies();

}
