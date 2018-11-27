package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;

import java.util.List;

public interface TicketService {

    Ticket createTicket();
    Ticket readTicket(int ticketId);
    List<Ticket> readAllTickets();

    Ticket saveTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
}
