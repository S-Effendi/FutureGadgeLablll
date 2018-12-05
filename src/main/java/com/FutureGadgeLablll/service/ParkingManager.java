package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;

public interface ParkingManager {

    int readOccupiedSpaces();

    Ticket manageAvailableSpaces(Ticket ticket);
}
