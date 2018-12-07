package com.FutureGadgeLablll.dao;

import com.FutureGadgeLablll.Ticket;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * This defines the methods which be used to interact with the dao.
 */

public interface TicketDao {

    /**
     * Creates ticket.
     */
    void createTicket();

    /**
     * @param ticketId get ticket by id
     * @return ticket
     */
    Ticket readTicket(Integer ticketId);
    /**
     *
     * @return tickets
     */
    List<Ticket> readAllTickets();
    /**
     *
     * @return unavailable tickets
     */
    List<Ticket> readUnavailableTickets();
    /**
     *
     * @param ticket save ticket by id
     * @return ticket
     */
    Ticket saveTicket(Ticket ticket);
    /**
     *
     * @param ticketId the ticket by id
     * @param exitTime the ticket by exitTime
     * @param ticketAvailable the ticket by availability
     * @param fee the ticket by fee
     * @return the ticket
     */
    Ticket updateTicket(Integer ticketId, Timestamp exitTime,
                        Boolean ticketAvailable, BigDecimal fee);
    /**
     *
     * @param ticketId delete ticket by id
     * @return the ticket
     */
    int deleteTicket(Integer ticketId);
    /**
     *
     */
    void deleteAllTicket();
}
