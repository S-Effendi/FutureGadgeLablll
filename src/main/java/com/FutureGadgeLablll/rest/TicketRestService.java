package com.FutureGadgeLablll.rest;


import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.service.TicketManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Path("/")
public class TicketRestService {
    /**
     * Ticket Service.
     */
    private TicketManager ticketService;

    /**
     * Empty Ticket Rest Service Constructor.
     */
    public TicketRestService() {
    }

    /**
     * @param ticketServices processes a ticket service
     */
    public TicketRestService(final TicketManager ticketServices) {
        this.ticketService = ticketServices;
    }

    /**
     * @throws ParseException E
     */
    @Path("/ticket")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void createTicket() throws ParseException {
        ticketService.createTicket(new Date());
    }

    /**
     * @param ticketId return ticket by id
     * @return ticket
     */
    @Path("/ticket/{id}")
    @GET
    @Produces("application/json")
    public Ticket readTicket(@PathParam("id") final int ticketId) {
        return ticketService.readTicket(ticketId);
    }

    /**
     * @return tickets
     */
    @Path("/ticket")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> readAllTickets() {
        return ticketService.readAllTickets();
    }

    /**
     * @param ticket store ticket data
     * @return ticket
     */
    @Path("/ticket/override")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket saveTicket(final Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    /**
     * @param ticket updated ticket
     */
    @Path("/ticket")
    @PUT
    @Consumes("application/json")
    public void updateParking(final Ticket ticket) {
        ticketService.updateTicket(ticket);
    }

    /**
     * WORK FLOW
     * POST /ticket -> createTicket()
     * GET /ticket/allTicket
     * PUT /ticket -> Add endTime
     * GET /ticket/{id} -> contains the fee
     */
}
