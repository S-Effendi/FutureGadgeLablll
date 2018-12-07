package com.FutureGadgeLablll.service;

/**
 * This defines the methods which be used to interact with the
 * parkingManagerService.
 */

public interface ParkingManager {
    /**
     * @return occupied parking spaces
     */
    int readOccupiedSpaces();

    /**
     * will decrease the number of available spaces.
     */
    void decreaseAvailableSpaces();

    /**
     * will increase the number of available spaces.
     */
    void increaseAvailableSpaces();
}
