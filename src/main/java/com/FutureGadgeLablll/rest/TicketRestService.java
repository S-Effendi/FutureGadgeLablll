package com.FutureGadgeLablll.rest;


import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.service.TicketManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Path("/")
public class TicketRestService {

    private TicketManager ticketService;

    public TicketRestService() {
    }

    public TicketRestService(TicketManager ticketService) {
        this.ticketService = ticketService;
    }

    @Path("/ticket")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void createTicket() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        ticketService.createTicket(simpleDateFormat.parse("2010-07-16 19:19:08"));
    }

    @Path("/ticket/{id}")
    @GET
    @Produces("application/json")
    public Ticket readTicket(@PathParam("id") int ticketId) {
        return ticketService.readTicket(ticketId);
    }

    @Path("/ticket/allTicket")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> readAllTickets() {
        return ticketService.readAllTickets();
    }

    @Path("/ticket/saved")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket saveTicket(Ticket ticket) {
        return ticketService.saveTicket(ticket);
    }

    @Path("/ticket/update")
    @PUT
    @Consumes("application/json")
    public void updateParking(Ticket ticket) {
        ticketService.updateTicket(ticket);
    }


}
