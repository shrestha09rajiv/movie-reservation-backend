package com.cotiviti.moviereservation.booking.service;

import com.cotiviti.moviereservation.booking.domain.Booking;
import com.cotiviti.moviereservation.booking.dto.BookingDto;
import com.cotiviti.moviereservation.booking.dto.BookingPaymentDto;
import com.cotiviti.moviereservation.booking.dto.PaymentDetailsDto;
import com.cotiviti.moviereservation.booking.dto.PaymentRequestDto;
import com.cotiviti.moviereservation.booking.mapper.BookingMapper;
import com.cotiviti.moviereservation.booking.mapper.PaymentRequestMapper;
import com.cotiviti.moviereservation.booking.repo.BookingRepository;
import com.cotiviti.moviereservation.configuration.LoggedInUserDetail;
import com.cotiviti.moviereservation.enums.BookingStatus;
import com.cotiviti.moviereservation.movie.service.MovieService;
import com.cotiviti.moviereservation.payment.repo.PaymentMethodRepository;
import com.cotiviti.moviereservation.ticket.repo.TicketRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final MovieService movieService;
    private final TicketRepository ticketRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, MovieService movieService, TicketRepository ticketRepository, PaymentMethodRepository paymentMethodRepository) {
        this.bookingRepository = bookingRepository;
        this.movieService = movieService;
        this.ticketRepository = ticketRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    @Transactional
    public BookingDto save(BookingDto bookingDto) {
        bookingDto.setBookingStatus(BookingStatus.PENDING);
        bookingDto.setUserId((Long) LoggedInUserDetail.getLoggedInUserDetail().get("id"));
        Booking booking = bookingRepository.save(BookingMapper.INSTANCE.toEntity(bookingDto));
        return BookingMapper.INSTANCE.toDto(booking);
    }

    @Override
    public List<BookingDto> findAll() {
        return BookingMapper.INSTANCE.toDto(bookingRepository.findAll());
    }

    @Override
    public List<BookingDto> findPendingBooking(BookingStatus bookingStatus) {
        List<BookingDto> bookingDtoList = new ArrayList<>();
        bookingDtoList = bookingRepository.findBookingsByBookingStatus(bookingStatus);
        return bookingDtoList;
    }

    @Override
    public BigDecimal findUnitPrice(Long id) {
        return ticketRepository.findUnitPrice(id);
    }

    @Override
    public BookingDto getBookingInfo(Long bookingId) {
        Booking booking = bookingRepository.findBookingById(bookingId);
        return BookingMapper.INSTANCE.toDto(booking);
    }

    @Override
    public PaymentRequestDto getById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return PaymentRequestMapper.INSTANCE.toDto(booking.get());
    }

    @Override
    public List<BookingDto> getUserBookingHistory() {
        Long userId = (Long) LoggedInUserDetail.getLoggedInUserDetail().get("id");
        return BookingMapper.INSTANCE.toDto(bookingRepository.findBookingByUser(userId));
    }

    @Override
    @Transactional
    public BookingPaymentDto pay(PaymentDetailsDto bookingPaymentDto) {
        Booking booking = bookingRepository.findBookingById(bookingPaymentDto.getBookingId());
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setPaymentMethod(paymentMethodRepository.getById(bookingPaymentDto.getPaymentMethod()));
        bookingRepository.save(booking);
        return null;
    }


    @Override
    public Map<String, Object> dashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();
        dashboardData.putAll(bookingRepository.getTotalBookings());
        dashboardData.putAll(bookingRepository.getTotalIncome());
        dashboardData.putAll(movieService.getTotalMovies());
        return dashboardData;
    }
}
