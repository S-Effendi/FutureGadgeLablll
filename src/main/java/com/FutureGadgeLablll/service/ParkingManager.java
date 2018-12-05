package com.FutureGadgeLablll.service;

public interface ParkingManager {

    int readOccupiedSpaces();

    void decreaseAvailableSpaces();

    void increaseAvailableSpaces();
}
