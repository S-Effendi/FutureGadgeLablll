package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;

import java.util.Date;
import java.util.List;

/**
 * This defines the methods which be used to interact with the
 * * ticketManagerService.
 */

public interface TicketManager {

    /**
     * @param entryTime create ticket as soon as an entry date is issued.
     */
    void createTicket(Date entryTime);

    /**
     * @param ticketId read by ticket id
     * @return ticket
     */
    Ticket readTicket(int ticketId);

    /**
     * @return read all by ticket id
     */
    List<Ticket> readAllTickets();

    /**
     * @param ticket save ticket by id
     * @return ticket
     */
    Ticket saveTicket(Ticket ticket);

    /**
     * @param ticket update ticket
     */
    void updateTicket(Ticket ticket);
}
