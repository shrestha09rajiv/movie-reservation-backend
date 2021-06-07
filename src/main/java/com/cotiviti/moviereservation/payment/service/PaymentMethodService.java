package com.cotiviti.moviereservation.payment.service;

import com.cotiviti.moviereservation.payment.domain.PaymentMethod;
import com.cotiviti.moviereservation.payment.dto.PaymentMethodDto;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodService {

    PaymentMethodDto save(PaymentMethodDto paymentDto);
    List<PaymentMethodDto> findAll();
    PaymentMethodDto findById(Long id);
}
