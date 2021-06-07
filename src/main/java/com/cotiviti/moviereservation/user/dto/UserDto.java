package com.cotiviti.moviereservation.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;
}
