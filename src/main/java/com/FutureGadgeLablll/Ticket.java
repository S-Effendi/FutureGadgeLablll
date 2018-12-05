package com.FutureGadgeLablll;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {

    private int ticketId;
    private Date entryTime;
    private Date exitTime;
    private BigDecimal fee;
    protected Boolean ticketAvailable = true;
    protected int availableSpaces = 50;

    /**
     * Used to establish attributes within a row in the Parking table
     *
     * @param
     */

    public Ticket() {
    }

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(int ticketId, boolean ticketAvailable, Date entryTime) {
        this.ticketId = ticketId;
        this.ticketAvailable = ticketAvailable;
        this.entryTime = entryTime;
    }

    public Ticket(int ticketId, boolean ticketAvailable, Date entryTime, Date exitTime, BigDecimal fee) {
        this.ticketId = ticketId;
        this.ticketAvailable = ticketAvailable;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fee = fee;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setTicketAvailable(Boolean ticketAvailable) {
        this.ticketAvailable = ticketAvailable;
    }

    public Boolean getTicketAvailable() {
        return ticketAvailable;
    }

    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }

    @Override
    public String toString() {
        return String.format("Parking Details:" + "\nTicket Id: " + ticketId + "\nEntry Time:" + entryTime + "\nExit Time: " + exitTime + "\nFee:" + fee);
    }
}
