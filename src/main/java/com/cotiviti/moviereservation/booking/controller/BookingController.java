package com.cotiviti.moviereservation.booking.controller;

import com.cotiviti.moviereservation.booking.dto.BookingDto;
import com.cotiviti.moviereservation.booking.dto.BookingPaymentDto;
import com.cotiviti.moviereservation.booking.dto.PaymentDetailsDto;
import com.cotiviti.moviereservation.booking.service.BookingService;
import com.cotiviti.moviereservation.enums.BookingStatus;
import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.movie.service.MovieService;
import com.cotiviti.moviereservation.payment.dto.PaymentMethodDto;
import com.cotiviti.moviereservation.payment.service.PaymentMethodService;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import com.cotiviti.moviereservation.ticket.service.TicketService;
import com.cotiviti.moviereservation.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService bookingService;
    private final TicketService ticketService;
    private final MovieService movieService;
    private final PaymentMethodService paymentMethodService;

    public BookingController(BookingService bookingService, TicketService ticketService, MovieService movieService, PaymentMethodService paymentMethodService) {
        this.bookingService = bookingService;
        this.ticketService = ticketService;
        this.movieService = movieService;
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BookingDto bookingDto) {
        BookingDto bookingDt = bookingService.save(bookingDto);
//        Booking booking = BookingMapper.INSTANCE.toEntity(bookingDt);
        List<Ticket> ticketNumberList = ticketService.findTicketNumberByStatusForMovie(TicketStatus.AVAILABLE, bookingDt.getMovieId());
        List<Ticket> tickets = ticketService.findTicketOfTicketNumbers(ticketNumberList, bookingDto.getTotalTickets());
        ticketService.updateTickets(tickets);
        return new Response().success(bookingDt);
    }

    @GetMapping("/dashboard/data")
    public ResponseEntity<Map<String, Object>> getDashboardData() {
        return new ResponseEntity<>(bookingService.dashboardData(), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<BookingDto>> findPendingBooking() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.findPendingBooking(BookingStatus.PENDING));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ArrayList<>());
        }
    }

    @GetMapping("/ticket/info/{movieId}")
    public ResponseEntity<BigDecimal> findUnitPrice(@PathVariable("movieId") Long movieId) {
        try {
            System.out.println("adfasdf");
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.findUnitPrice(movieId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new BigDecimal(String.valueOf(BigDecimal.ZERO)));
        }
    }

    @GetMapping("/pay/{bookingId}")
    public ResponseEntity<?> getBookingInfo(@PathVariable("bookingId") Long bookingId) {
        try {
            System.out.println("adfasdf");
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.getBookingInfo(bookingId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("no record");
        }
    }

    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody PaymentDetailsDto paymentDetailsDto) {
  /*      PaymentMethodDto paymentMethodDto = paymentDetailsDto != null ? paymentMethodService.findById(paymentDetailsDto.getPaymentMethod()) : null;
        BookingPaymentDto bookingPaymentDto = new BookingPaymentDto();
        bookingPaymentDto.setBookingId(paymentDetailsDto.getBookingId());
        bookingPaymentDto.setPaymentMethodDto(paymentMethodDto);*/
        return new Response().success(bookingService.pay(paymentDetailsDto));
    }

    @GetMapping("/userHistory")
    public ResponseEntity<List<BookingDto>> getUserBookingHistory() {
        try {
            System.out.println("adfasdf");
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.getUserBookingHistory());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ArrayList<>());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<List<BookingDto>> findBookingHistory() {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ArrayList<>());
        }
    }
}
