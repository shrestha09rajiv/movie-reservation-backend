package com.cotiviti.moviereservation.booking.mapper;

import com.cotiviti.moviereservation.booking.domain.Booking;
import com.cotiviti.moviereservation.booking.dto.BookingDto;
import com.cotiviti.moviereservation.booking.dto.PaymentRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentRequestMapper {
    PaymentRequestMapper INSTANCE = Mappers.getMapper(PaymentRequestMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "movieId", target = "movie.id")
    @Mapping(source = "paymentMethodId", target = "paymentMethod.id")
    Booking toEntity(PaymentRequestDto paymentRequestDto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "movie.id", target = "movieId")
    @Mapping(source = "paymentMethod.id", target = "paymentMethodId")
    PaymentRequestDto toDto(Booking booking);
}
