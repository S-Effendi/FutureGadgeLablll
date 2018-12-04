package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {

    Ticket createTicket(int ticketId, boolean availableTicket, Date entryTime);

    Ticket readTicket(int ticketId);

    List<Ticket> readAllTickets();

    int readOccupiedSpaces();

    Ticket saveTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    Ticket parkingManager(Ticket ticket);
}
