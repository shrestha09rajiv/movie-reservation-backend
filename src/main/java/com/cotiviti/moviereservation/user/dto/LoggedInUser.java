package com.cotiviti.moviereservation.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoggedInUser {
    private Long id;
    private String username;
    private String email;
}
