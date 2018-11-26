package com.FutureGadgeLablll;

public class TicketIssued {

    private int availableSpaces;
    Ticket ticket;

    public TicketIssued(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public int getAvailableSpaces() {
        int result = availableSpaces;

        if (availableSpaces == 0) {
            ticket.ticketIssued = false;
        }
        else if (ticket.ticketIssued && availableSpaces >= 50) {
            result = availableSpaces--;
            setAvailableSpaces(result);
        }
        else if (ticket.ticketReturned && availableSpaces != 50) {
                result = availableSpaces++;
        }
        else{throw new RuntimeException("There are no available parking spaces");
        }
        return availableSpaces;
    }
}