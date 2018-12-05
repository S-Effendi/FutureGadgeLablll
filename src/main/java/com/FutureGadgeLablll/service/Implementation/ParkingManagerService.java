package com.FutureGadgeLablll.service.Implementation;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.ParkingManager;

public class ParkingManagerService implements ParkingManager {

    private JdbcTicketDao jdbcTicketDao;

    @Override
    public int readOccupiedSpaces() {
        return jdbcTicketDao.readUnavailableTickets().size();
    }

    @Override
    public Ticket manageAvailableSpaces(Ticket ticket) {
        ticket.setAvailableSpaces(ticket.getAvailableSpaces() - readOccupiedSpaces());
        return ticket;
    }
}
