package com.cotiviti.moviereservation.ticket.domain;

import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

    @Column(name = "ticket_price")
    private BigDecimal ticketPrice;

    @OneToOne
    private Movie movie;
}
