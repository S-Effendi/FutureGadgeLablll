package com.FutureGadgeLablll;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TicketIssuedTest {

    private Ticket ticket;
    private TicketIssued ticketIssued;

    /**
     *
     * @throws Exception
     * Tickets Issued must be true in order for spaceAvailability test to pass
     */

    @Before
    public void setUp() throws Exception {
        ticket = new Ticket();
        ticketIssued = new TicketIssued(ticket);
    }

    @Test
    public void testAvailableSpaces(){
        int result = ticketIssued.getAvailableSpaces();

        assertEquals(50, result);
    }

    @Test
    public void testNumberOfParkingSpaces(){
        int parkingSpaces;

        parkingSpaces = ticketIssued.getAvailableSpaces();

        assertEquals(parkingSpaces, ticketIssued.getAvailableSpaces());
    }
}
