package com.cotiviti.moviereservation.booking.domain;

import com.cotiviti.moviereservation.enums.BookingStatus;
import com.cotiviti.moviereservation.movie.domain.Movie;
import com.cotiviti.moviereservation.payment.domain.PaymentMethod;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import com.cotiviti.moviereservation.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "totalCost")
    private BigDecimal totalCost;

    @Column(name = "booking_status")
    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToOne(optional = true)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToMany
    private List<Ticket> ticketList;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date bookedDate;

    @Column(name = "total_tickets")
    private Integer totalTickets;

}
