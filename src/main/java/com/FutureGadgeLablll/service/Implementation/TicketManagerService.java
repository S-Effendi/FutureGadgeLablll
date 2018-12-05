package com.FutureGadgeLablll.service.Implementation;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.TicketFee;
import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.TicketManager;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TicketManagerService implements TicketManager {

    public ParkingManagerService parkingManagerService;

    private JdbcTicketDao jdbcTicketDao;
    private Ticket ticket;

    public TicketManagerService(JdbcTicketDao jdbcTicketDao, ParkingManagerService parkingManagerService) {
        this.jdbcTicketDao = jdbcTicketDao;
        this.parkingManagerService = parkingManagerService;
    }

    @Override
    public void createTicket(Date entryTime) {
        parkingManagerService.decreaseAvailableSpaces();
        this.jdbcTicketDao.createTicket();
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
    public Ticket saveTicket(Ticket ticket) {
        return jdbcTicketDao.saveTicket(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        TicketFee ticketFee = new TicketFee(ticket);

        BigDecimal fee = ticketFee.getTariff();
        Timestamp exitTime = new Timestamp(ticket.getExitTime().getTime());
        jdbcTicketDao.updateTicket(ticket.getTicketId(), exitTime, ticket.getTicketIssued(), fee);

        parkingManagerService.increaseAvailableSpaces();
        ticket.setTicketIssued(true);
    }

//    public static class ParkingManager {
//        public class ParkingManagerService implements com.FutureGadgeLablll.service.ParkingManager {
//
//            private JdbcTicketDao jdbcTicketDao;
//
//            protected int availableSpaces = 50;
//
//            @Override
//            public int readOccupiedSpaces() {
//                return jdbcTicketDao.readUnavailableTickets().size();
//            }
//
//            @Override
//            public void decreaseAvailableSpaces() {
//                availableSpaces--;
//            }
//
//            @Override
//            public void increaseAvailableSpaces() {
//                availableSpaces++;
//            }
//
//        }
//    }
}