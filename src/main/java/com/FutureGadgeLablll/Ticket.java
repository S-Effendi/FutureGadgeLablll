package com.FutureGadgeLablll;

import java.math.BigDecimal;
import java.util.Date;

public class Ticket {

    private int ticketId;
    private Date entryTime, exitTime;
    private BigDecimal fee;
    protected Boolean ticketIssued = false, ticketReturned = false;

    /**
     * Used to establish attributes within a row in the Parking table
     * @param
     */

    public Ticket() {
    }

    public Ticket(int ticketId) {
        this.ticketId = ticketId;
    }

    public Ticket(int ticketId, Date entryTime, Date exitTime){
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public Ticket(int ticketId, Date entryTime, Date exitTime, BigDecimal fee){
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fee = fee;
    }

    public void setTicketId(int ticketId){
        this.ticketId = ticketId;
    }
    public int getTicketId(){
        return ticketId;
    }

    public void setEntryTime(Date entryTime){
        this.entryTime = entryTime;
    }
    public Date getEntryTime(){
        return entryTime;
    }

    public void setExitTime(Date exitTime){
        this.exitTime = exitTime;
    }
    public Date getExitTime(){
        return exitTime;
    }

    public void setFee(BigDecimal fee){
        this.fee = fee;
    }
    public BigDecimal getFee(){
        return fee;
    }

    @Override
    public String toString() {
        return String.format("Parking Details:" + "\nTicket Id: " + ticketId + "\nEntry Time:" + entryTime + "\nExit Time: " + exitTime + "\nFee" + fee);
    }
}