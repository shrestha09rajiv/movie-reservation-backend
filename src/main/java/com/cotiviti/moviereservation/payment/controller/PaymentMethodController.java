package com.cotiviti.moviereservation.payment.controller;

import com.cotiviti.moviereservation.payment.dto.PaymentMethodDto;
import com.cotiviti.moviereservation.payment.service.PaymentMethodService;
import com.cotiviti.moviereservation.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentMethodController {

    private PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PaymentMethodDto paymentMethodDto) {
        try {
            return new Response().success(paymentMethodService.save(paymentMethodDto));
//            return ResponseEntity.status(HttpStatus.CREATED).body(paymentMethodService.save(paymentMethodDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Error in save");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentMethodDto>> findAll() {
        return new ResponseEntity<>(paymentMethodService.findAll(), HttpStatus.CREATED);
    }
}
