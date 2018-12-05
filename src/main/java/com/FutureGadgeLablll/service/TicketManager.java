package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketManager {

    void createTicket(Date entryTime);

    Ticket readTicket(int ticketId);

    List<Ticket> readAllTickets();

    Ticket saveTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

}
