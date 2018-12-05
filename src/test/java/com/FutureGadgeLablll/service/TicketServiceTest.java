package com.FutureGadgeLablll.service;

import com.FutureGadgeLablll.service.Implementation.TicketManagerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"/spring/application_context.xml"})
public class TicketServiceTest {

    @Autowired
    TicketManagerService ticketManagerService;

    @Before
    public void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        ticketManagerService.createTicket(simpleDateFormat.parse("2010-07-16 19:19:08"));
    }

    @Test
    public void testTicketConstructionOfId() {

        Assert.assertEquals(1, ticketManagerService.readTicket(1).getTicketId());
    }

    @Test
    public void testTicketConstructionOfFee() {

        Assert.assertEquals(BigDecimal.valueOf(10.50), ticketManagerService.readTicket(1).getFee().setScale(1));
    }

    @Test
    public void testTicketConstructionOfEntryTime() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Assert.assertEquals(simpleDateFormat.parse("2010-07-16 19:19:08"), ticketManagerService.readTicket(1).getEntryTime());
    }
}