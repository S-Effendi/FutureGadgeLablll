package com.FutureGadgeLablll.dao;

import com.FutureGadgeLablll.Ticket;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * This defines the methods which be used to interact with the database access objectsS
 */

public interface TicketDao {

    Ticket createTicket();

    Ticket readTicket(Integer ticketId);

    List<Ticket> readAllTickets();

    List<Ticket> readUnavailableTickets();

    Ticket saveTicket(Ticket ticket);

    Ticket updateTicket(Integer ticketId, Timestamp exitTime, Boolean ticketAvailable, BigDecimal fee);

    int deleteTicket(Integer ticketId);

    void deleteAllTicket();
}
