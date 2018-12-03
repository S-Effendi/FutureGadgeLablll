package com.FutureGadgeLablll;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;

public class TicketFeeTest {

    private Ticket ticket;
    private TicketFee ticketFee;

    @Before
    public void setUp() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        ticket = new Ticket(1, true, simpleDateFormat.parse("2010-07-16 19:19:08"), simpleDateFormat.parse("2010-07-16 19:19:08"), BigDecimal.valueOf(10.50));
        ticketFee = new TicketFee(ticket);
    }

    @Test
    public void testDuration() {
        int result = ticketFee.getDuration();
        Assert.assertEquals(0, result);
    }

    @Test
    public void testCategoryOneCharge() {

        BigDecimal result = ticketFee.getTariff();

        assertEquals(result, ticket.getFee());
    }
}