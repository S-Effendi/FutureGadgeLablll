package com.FutureGadgeLablll.service.Implementation;

import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.ParkingManager;

/**
 * Implements parking manager responsible for managing parking spaces.
 */
public class ParkingManagerService implements ParkingManager {
    /**
     * Max Spaces of Available parking.
     */
    private static final int MAX_SPACES = 50;
    /**
     * JdbcTicketDao.
     */
    private JdbcTicketDao jdbcTicketDao;
    /**
     * Available spaces.
     */
    private int availableSpaces = MAX_SPACES;

    /**
     * @return occupiedSpaces
     */
    @Override
    public int readOccupiedSpaces() {
        return jdbcTicketDao.readUnavailableTickets().size();
    }

    /**
     * will decrease the number of available spaces.
     */
    @Override
    public void decreaseAvailableSpaces() {
        availableSpaces--;
    }

    /**
     * will increase the number of available spaces.
     */
    @Override
    public void increaseAvailableSpaces() {
        availableSpaces++;
    }

}
