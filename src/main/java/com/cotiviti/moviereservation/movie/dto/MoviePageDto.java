package com.cotiviti.moviereservation.movie.dto;

import lombok.Data;

import java.util.List;

@Data
public class MoviePageDto {

    private Long total;
    private List<MovieDto> movieDtoList;
}
