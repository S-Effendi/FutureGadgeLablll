package com.FutureGadgeLablll.service.Implementation;

import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.ParkingManager;

public class ParkingManagerService implements ParkingManager {

    private JdbcTicketDao jdbcTicketDao;

    protected int availableSpaces = 50;

    @Override
    public int readOccupiedSpaces() {
        return jdbcTicketDao.readUnavailableTickets().size();
    }

    @Override
    public void decreaseAvailableSpaces() {
        availableSpaces--;
    }

    @Override
    public void increaseAvailableSpaces() {
        availableSpaces++;
    }

}
