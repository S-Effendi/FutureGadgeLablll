package com.FutureGadgeLablll;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */

@JsonIgnoreProperties({"ticketIssued", "availableSpaces",
        "entryTime", "exitTime"})

public class Ticket {
    /**
     * max Spaces.
     */
    private static final int MAXSPACES = 50;
    /**
     * ticketId.
     */
    private int ticketId;
    /**
     * entryTime.
     */
    private Date entryTime;
    /**
     * entryExit.
     */
    private Date exitTime;
    /**
     * fee.
     */
    private BigDecimal fee;
    /**
     * ticketAvailable.
     */
    private Boolean ticketAvailable = false;
    /**
     * availableSpaces.
     */
    private int availableSpaces = MAXSPACES;

    /**
     * Used to establish attributes within a row in the Parking table.
     */

    public Ticket() {
    }

    /**
     * @param ticketsId the ticket Id.
     */
    public Ticket(final int ticketsId) {
        this.ticketId = ticketsId;
    }

    /**
     * @param ticketsId        the ticket id
     * @param ticketsAvailable ticket availability
     * @param entryTimes       the ticket entryTime
     */
    public Ticket(final int ticketsId, final boolean ticketsAvailable,
                  final Date entryTimes) {
        this.ticketId = ticketsId;
        this.ticketAvailable = ticketsAvailable;
        this.entryTime = entryTimes;
    }

    /**
     * @param ticketsId        the ticketId
     * @param ticketsAvailable ticket availability
     * @param entryTimes       the entryTime
     * @param exitTimes        the exitTime
     * @param fees             the fees
     */
    public Ticket(final int ticketsId, final boolean ticketsAvailable,
                  final Date entryTimes, final Date exitTimes,
                  final BigDecimal fees) {
        this.ticketId = ticketsId;
        this.ticketAvailable = ticketsAvailable;
        this.entryTime = entryTimes;
        this.exitTime = exitTimes;
        this.fee = fees;
    }

    /**
     * @param ticketsId the ticketId's
     */
    public void setTicketId(final int ticketsId) {
        this.ticketId = ticketsId;
    }

    /**
     * TicketId.
     *
     * @return ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * @param entryTimes set the entry time
     */
    public void setEntryTime(final Date entryTimes) {
        this.entryTime = entryTimes;
    }

    /**
     * @return get the entry time.
     */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
     *
     * @param entryDateTime set entry date and time
     */

    public void setEntryDateTime(final String entryDateTime) {

        SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            entryTime = simpleDateFormat.parse(entryDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            entryTime = null;
        }
    }

    /**
     * @return get entry date and time
     */

    public String getEntryDateTime() {
        if (entryTime == null) {
            return "";
        }

        return entryTime.toString();
    }

    /**
     * @param exitTimes sets exitTime
     */
    public void setExitTime(final Date exitTimes) {
        this.exitTime = exitTimes;
    }

    /**
     * @return exitTime
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * @return get exit date and time
     */
    public String getExitDateTime() {
        if (exitTime == null) {
            return "";
        }
        return exitTime.toString();
    }

    /**
     *
     * @param exitDateTime set exit date and time
     */
    public void setExitDateTime(final String exitDateTime) {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        try {
            exitTime = simpleDateFormat.parse(exitDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
            exitTime = null;
        }
    }

    /**
     * @param fees set fee
     */
    public void setFee(final BigDecimal fees) {
        this.fee = fees;
    }

    /**
     * @return fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * @param ticketsAvailable set tickets issued
     */
    public void setTicketIssued(final Boolean ticketsAvailable) {
        this.ticketAvailable = ticketsAvailable;
    }

    /**
     * @return tickets issued.
     */
    public Boolean getTicketIssued() {
        return ticketAvailable;
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        return String.format("Parking Details:" + "\nTicket Id: " + ticketId
                + "\nEntry Time:" + entryTime + "\nExit Time: " + exitTime
                + "\nFee:" + fee);
    }
}
