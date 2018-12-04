package com.FutureGadgeLablll.dao;

import com.FutureGadgeLablll.Ticket;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * This defines the methods which be used to interact with the database access objectsS
 */

public interface TicketDao {

    public Ticket createTicket();

    public Ticket readTicket(Integer ticketId);

    public List<Ticket> readAllTickets();

    public Ticket saveTicket(Ticket ticket);

    public Ticket updateTicket(Integer ticketId, Timestamp exitTime, Boolean ticketAvailable, BigDecimal fee);

    public int deleteTicket(Integer ticketId);

    public void deleteAllTicket();
}
