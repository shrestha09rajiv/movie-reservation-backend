package com.cotiviti.moviereservation.booking.mapper;

import com.cotiviti.moviereservation.booking.domain.Booking;
import com.cotiviti.moviereservation.booking.dto.BookingDto;
import com.cotiviti.moviereservation.movie.domain.Movie;
import com.cotiviti.moviereservation.movie.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "movieId", target = "movie.id")
    @Mapping(source = "movieName", target = "movie.movieName")
    Booking toEntity(BookingDto bookingDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "movie.movieName", target = "movieName")
    BookingDto toDto(Booking booking);

    List<BookingDto> toDto(List<Booking> bookingList);

}
