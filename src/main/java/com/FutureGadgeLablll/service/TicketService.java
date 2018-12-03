package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;

import java.util.List;

public interface TicketService {

    Ticket createTicket();

    Ticket readTicket(int ticketId);

    List<Ticket> readAllTickets();

    int readOccupiedSpaces();

    Ticket saveTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    Ticket parkingManager(Ticket ticket);
}
