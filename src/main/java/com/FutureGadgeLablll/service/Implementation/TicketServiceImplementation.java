package com.FutureGadgeLablll.service.Implementation;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.TicketFee;
import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.TicketService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TicketServiceImplementation implements TicketService {

    private JdbcTicketDao jdbcTicketDao;
    private Ticket ticket;
    private TicketFee ticketFee;

    public TicketServiceImplementation(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketServiceImplementation(JdbcTicketDao jdbcTicketDao) {
        this.jdbcTicketDao = jdbcTicketDao;
    }

    public void setJdbcTicketDao(JdbcTicketDao jdbcTicketDao) {
    }

    public void setTicketFee(TicketFee parkingFee) {
        this.ticketFee = parkingFee;
    }

    @Override
    public Ticket createTicket(int ticketId, boolean availableTicket, Date entryTime) {
        return jdbcTicketDao.createTicket();
    }

    @Override
    public Ticket readTicket(int ticketId) {
        return this.jdbcTicketDao.readTicket(ticketId);
    }

    @Override
    public List<Ticket> readAllTickets() {
        return jdbcTicketDao.readAllTickets();
    }

    @Override
    public int readOccupiedSpaces() {
        return jdbcTicketDao.readAllTickets().size();
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return jdbcTicketDao.saveTicket(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketFee = new TicketFee(ticket);

        BigDecimal fee = ticketFee.getTariff();
        Timestamp exitTime = new Timestamp(ticket.getExitTime().getTime());
        jdbcTicketDao.updateTicket(ticket.getTicketId(), exitTime, ticket.getTicketAvailable(), fee);
    }

    public Ticket parkingManager(Ticket ticket) {
        ticket.setAvailableSpaces(ticket.getAvailableSpaces() - readOccupiedSpaces());
        return ticket;
    }
}