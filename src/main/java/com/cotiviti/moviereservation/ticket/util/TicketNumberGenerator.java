package com.cotiviti.moviereservation.ticket.util;

import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import com.cotiviti.moviereservation.ticket.dto.TicketDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicketNumberGenerator {
    public static List<TicketDto> createTicketNumberAndPopulateDto(TicketDto ticketDto) {
        List<TicketDto> ticketDtoList = new ArrayList<>();
        for (int i = 0; i < ticketDto.getTotalTickets(); i++) {
            String ticketNumber = createTicketNumber();
            TicketDto ticket = createTicketDto(ticketDto, ticketNumber.toUpperCase());
            ticketDtoList.add(ticket);
        }
        return ticketDtoList;
    }

    public static TicketDto createTicketDto(TicketDto ticketDto, String ticketNumber) {
        TicketDto ticketDt = new TicketDto();
        ticketDt.setTicketNumber(ticketNumber);
        ticketDt.setTicketPrice(ticketDto.getTicketPrice());
        ticketDt.setTicketStatus(TicketStatus.AVAILABLE);
        return ticketDt;
    }

    public static String createTicketNumber() {
        int sizeOfTicket = 5;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(sizeOfTicket);
        for (int i = 0; i < sizeOfTicket; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public static List<Ticket>getRandomElement(List<Ticket> ticketList, int totalItems)
    {
        Random rand = new Random();
        List<Ticket> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {
            int randomIndex = rand.nextInt(ticketList.size());
            newList.add(ticketList.get(randomIndex));
        }
        return newList;
    }


}
