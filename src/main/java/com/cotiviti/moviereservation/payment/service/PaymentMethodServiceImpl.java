package com.cotiviti.moviereservation.payment.service;

import com.cotiviti.moviereservation.payment.domain.PaymentMethod;
import com.cotiviti.moviereservation.payment.dto.PaymentMethodDto;
import com.cotiviti.moviereservation.payment.mapper.PaymentMethodMapper;
import com.cotiviti.moviereservation.payment.repo.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public PaymentMethodDto save(PaymentMethodDto paymentMethodDto) {
        PaymentMethodDto paymentMethodDt = new PaymentMethodDto();
        PaymentMethod paymentMethod = paymentMethodRepository.save(PaymentMethodMapper.INSTANCE.toEntity(paymentMethodDto));
        if (paymentMethod != null) {
            paymentMethodDt = PaymentMethodMapper.INSTANCE.toDto(paymentMethod);
        }
        return paymentMethodDt;
    }

    @Override
    public List<PaymentMethodDto> findAll() {
        List<PaymentMethodDto> paymentMethodDtoList = new ArrayList<>();
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        paymentMethodList = paymentMethodRepository.findAll();
        if (!paymentMethodList.isEmpty()) {
            paymentMethodDtoList = PaymentMethodMapper.INSTANCE.toDto(paymentMethodList);
        }
        return paymentMethodDtoList;
    }

    @Override
    public PaymentMethodDto findById(Long id) {
        return PaymentMethodMapper.INSTANCE.toDto(paymentMethodRepository.findById(id).get());
    }
}
