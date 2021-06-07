package com.cotiviti.moviereservation.configuration;

public class SecurityConstants {
    public static final String LOGIN_URL = "/api/user/login";
    public static final String SECRET ="ticketbooking";
    public static final String TOKEN_PREFIX= "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 300_000; //30 seconds
}
