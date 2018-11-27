package com.FutureGadgeLablll.rest;


import com.FutureGadgeLablll.Ticket;
import com.FutureGadgeLablll.dao.JdbcTicketDao;
import com.FutureGadgeLablll.service.TicketService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class FglRestService {

    private TicketService ticketService;
    private JdbcTicketDao jdbcParkingDAO;

    public FglRestService() {

    }

    public FglRestService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void setParkingService(String parkingService) {
    }

    @Path("/ticket")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket createTicket() {
        return ticketService.createTicket();
    }

    @Path("/ticket/{id}")
    @GET
    @Produces("application/json")
    public Ticket readTicket(@PathParam("id") int ticketId){
        return ticketService.readTicket(ticketId);
    }

    @Path("/ticket/allTicket")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ticket> readAllTicket(){
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
