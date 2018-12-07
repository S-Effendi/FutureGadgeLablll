package com.FutureGadgeLablll.service.Implementation;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.TicketFee;
import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.TicketManager;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Implements ticket manager responsible for managing tickets.
 */
public class TicketManagerService implements TicketManager {
    /**
     * ParkingManagerService.
     */
    private ParkingManagerService parkingManagerService;
    /**
     * JdbcTicketDao.
     */
    private JdbcTicketDao jdbcTicketDao;
    /**
     * Ticket.
     */
    private Ticket ticket;

    /**
     * @param jdbcTicketDaoInstance         the jdbcTicket Dao
     * @param parkingManagerServiceInstance the parkingManagerService
     */
    public TicketManagerService(final JdbcTicketDao jdbcTicketDaoInstance,
        final ParkingManagerService parkingManagerServiceInstance) {
        this.jdbcTicketDao = jdbcTicketDaoInstance;
        this.parkingManagerService = parkingManagerServiceInstance;
    }

    /**
     * @param entryTime create ticket as soon as an entry date is issued.
     */
    @Override
    public void createTicket(final Date entryTime) {
        parkingManagerService.decreaseAvailableSpaces();
        this.jdbcTicketDao.createTicket();
    }

    /**
     * * @param ticketId read by ticket id
     *
     * @return ticket
     */
    @Override
    public Ticket readTicket(final int ticketId) {
        return this.jdbcTicketDao.readTicket(ticketId);
    }

    /**
     * @return read all by ticket id
     */
    @Override
    public List<Ticket> readAllTickets() {
        return jdbcTicketDao.readAllTickets();
    }

    /**
     * @param tickets save ticket by id
     * @return ticket
     */
    @Override
    public Ticket saveTicket(final Ticket tickets) {
        return jdbcTicketDao.saveTicket(tickets);
    }

    /**
     * @param tickets update ticket
     */
    @Override
    public void updateTicket(final Ticket tickets) {
        TicketFee ticketFee = new TicketFee(tickets);

        BigDecimal fee = ticketFee.getTariff();
        Timestamp exitTime = new Timestamp(tickets.getExitTime().getTime());
        tickets.setTicketIssued(true);
        jdbcTicketDao.updateTicket(tickets.getTicketId(), exitTime,
                tickets.getTicketIssued(), fee);
        parkingManagerService.increaseAvailableSpaces();
    }
}
