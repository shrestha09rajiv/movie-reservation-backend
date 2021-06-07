package com.cotiviti.moviereservation.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTLoginSucessReponse {
    private boolean success;
    private String token;
}
