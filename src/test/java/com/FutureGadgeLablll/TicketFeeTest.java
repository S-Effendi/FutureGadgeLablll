package com.FutureGadgeLablll;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

public class TicketFeeTest {

    private Ticket ticket;
    private TicketFee ticketFee;

    @Before
    public void setUp() throws Exception {
        ticket = new Ticket();
        ticketFee = new TicketFee(ticket);
    }

    @Ignore
    @Test
    public void testDuration(){
        int result = ticketFee.getDuration();
        Assert.assertEquals(" ", result);
    }

    @Test
    public void testCategoryOneCharge(){

        BigDecimal result = ticketFee.getTariff();

        assertEquals(result, ticket.getFee()); //50(duration)
    }
}