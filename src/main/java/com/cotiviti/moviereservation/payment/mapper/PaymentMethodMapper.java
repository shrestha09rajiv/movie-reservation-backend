package com.cotiviti.moviereservation.payment.mapper;

import com.cotiviti.moviereservation.payment.domain.PaymentMethod;
import com.cotiviti.moviereservation.payment.dto.PaymentMethodDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMethodMapper {
    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    PaymentMethod toEntity(PaymentMethodDto paymentMethodDto);

    PaymentMethodDto toDto(PaymentMethod paymentMethod);

    List<PaymentMethodDto> toDto(List<PaymentMethod> paymentMethodList);

}
