package com.cotiviti.moviereservation.movie.domain;

import com.cotiviti.moviereservation.enums.GenreEnum;
import com.cotiviti.moviereservation.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "movie_name")
    private String movieName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "genre")
    private GenreEnum genre;

    @Column(name = "release_date")
    private Date releaseDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_tickets")
    private Integer totalTickets;
    @Column(name = "available_tickets")
    private Integer availableTickets;



}
