package com.cotiviti.moviereservation.movie.mapper;

import com.cotiviti.moviereservation.movie.domain.Movie;
import com.cotiviti.moviereservation.movie.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "movieDto.releaseDate", target = "releaseDate", dateFormat = "yyyy-MM-dd hh:mm:ss")
    Movie toEntity(MovieDto movieDto);

    @Mapping(source = "releaseDate", target = "releaseDate", dateFormat = "yyyy-MM-dd hh:mm:ss")
    MovieDto toDto(Movie event);

    List<MovieDto> toDto(List<Movie> movieList);


}
