package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.service.Implementation.TicketServiceImplementation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/spring/application_context.xml"})
public class TicketServiceTest {

    @Autowired
    TicketServiceImplementation ticketServiceImplementation;

    @Test
    public void testTicketConstruction() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        final Ticket result = ticketServiceImplementation.createTicket(1, true, simpleDateFormat.parse("2010-07-16 19:19:08"));

        Assert.assertEquals(0, result.getTicketId());
    }
}
