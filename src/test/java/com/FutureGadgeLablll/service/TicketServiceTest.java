package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.service.Implementation.TicketManagerService;
import org.junit.Assert;
import org.junit.Before;
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
    TicketManagerService ticketServiceImplementation;


    @Test
    public void testTicketConstruction() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        ticketServiceImplementation.createTicket(simpleDateFormat.parse("2010-07-16 19:19:08"));

        Assert.assertEquals(1, ticketServiceImplementation.readTicket(1).getTicketId());
    }
}
