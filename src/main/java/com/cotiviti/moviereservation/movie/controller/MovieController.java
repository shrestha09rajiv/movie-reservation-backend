package com.cotiviti.moviereservation.movie.controller;

import com.cotiviti.moviereservation.movie.dto.MovieDto;
import com.cotiviti.moviereservation.movie.service.MovieService;
import com.cotiviti.moviereservation.user.dto.UrlPermissionDto;
import com.cotiviti.moviereservation.user.service.UrlPermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MovieDto movieDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movieDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error in save");
        }
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> findMovieById(@PathVariable("movieId") Long movieId) {
        return new ResponseEntity<>(movieService.findMovieById(movieId), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> findAll() {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.CREATED);
    }
}
