package com.FutureGadgeLablll.rest;

import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.service.Implementation.TicketServiceImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static org.mockito.Mockito.when;

public class TicketRestServiceTest {



    private static final int id1 = 1;

    @Mock
    private TicketServiceImplementation ticketServiceImplementation;

    private TicketRestService ticketRestService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

            when(ticketServiceImplementation.readAllTickets())
                    .thenReturn(Arrays.asList(new Ticket (1)));
            ticketRestService = new TicketRestService(ticketServiceImplementation);
    }

    @Test
    public void returnTicket(){
        List<Ticket> result = ticketRestService.readAllTickets();
        Ticket ticketResult = result.get(0);

        Assert.assertEquals(id1, ticketResult.getTicketId());
    }
}
