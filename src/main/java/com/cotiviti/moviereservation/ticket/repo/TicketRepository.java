package com.cotiviti.moviereservation.ticket.repo;

import com.cotiviti.moviereservation.enums.TicketStatus;
import com.cotiviti.moviereservation.ticket.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketsByTicketStatus(TicketStatus ticketStatus);
    @Query(value = "SELECT DISTINCT t.ticketPrice AS unitCost FROM Ticket t  WHERE t.movie.id=:id")
    BigDecimal findUnitPrice(@Param("id") Long id);

    @Query(value = "SELECT m.id,m.movie_name,m.total_tickets,m.available_tickets,t.ticket_price FROM ticket AS t inner join movie as m on t.movie_id=m.id group by m.id", nativeQuery = true)
    List<Map<String, Object>> findTicketOfMovie();

    List<Ticket> findTicketsByTicketStatusAndMovie_Id(TicketStatus status,Long id);



}
