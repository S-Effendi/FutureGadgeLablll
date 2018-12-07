package com.FutureGadgeLablll;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class TicketFee {
    /**
     * Lost Ticket.
     */
    private static final int LOST_TICKET = 5;
    /**
     * Twenty-rand.
     */
    public static final int TWENTY = 20;
    /**
     * Thirty minutes.
     */
    public static final int THIRTY_MINUTES = 30;
    /**
     * Thirty-rand.
     */
    public static final int THIRTY = 30;
    /**
     * Fifty-rand.
     */
    public static final int FIFTY = 50;
    /**
     * One_Hundred-rand.
     */
    public static final int ONE_HUNDRED = 100;
    /**
     * Sixty minutes.
     */
    public static final int SIXTY_MINUTES = 60;
    /**
     * Two Hours.
     */
    public static final int TWO_HOURS = 120;
    /**
     * Four Hours.
     */
    public static final int FOUR_HOURS = 240;
    /**
     * Level 3.
     */
    public static final int LEVEL3 = 3;
    /**
     * Level 4.
     */
    public static final int LEVEL4 = 4;
    /**
     * Duration.
     */
    private int duration;

    /**
     * Ticket.
     */
    private Ticket ticket;
    /**
     * Tariff Category.
     */
    private Map<Integer, BigDecimal> tariffCategory = new HashMap<>();

    /**
     * Ticket.
     *
     * @param tickets utilized ticket.
     */
    public TicketFee(final Ticket tickets) {
        this();
        this.ticket = tickets;
    }

    /**
     * TicketFee.
     */
    public TicketFee() {
        tariffCategory.put(1, BigDecimal.TEN);
        tariffCategory.put(2, BigDecimal.valueOf(TWENTY));
        tariffCategory.put(LEVEL3, BigDecimal.valueOf(THIRTY));
        tariffCategory.put(LEVEL4, BigDecimal.valueOf(FIFTY));
        tariffCategory.put(LOST_TICKET, BigDecimal.valueOf(ONE_HUNDRED));
    }

    /**
     * Duration.
     *
     * @return duration.
     */
    public int getDuration() {
        if (ticket.getTicketIssued()) {

            int entryTimeHour = ticket.getEntryTime().getHours();
            int entryTimeMinutes = ticket.getEntryTime().getMinutes();
            int exitTimeHour = ticket.getExitTime().getHours();
            int exitTimeMinutes = ticket.getExitTime().getMinutes();

            entryTimeHour = entryTimeHour * SIXTY_MINUTES;
            exitTimeHour = exitTimeHour * SIXTY_MINUTES;

            int entryTime = entryTimeHour + entryTimeMinutes;
            int exitTime = exitTimeHour + exitTimeMinutes;

            duration = (exitTime - entryTime);
        }
        return duration;
    }

    /**
     * Tariff.
     *
     * @return tariff.
     */
    public BigDecimal getTariff() {
        BigDecimal result;

        if (getDuration() <= THIRTY_MINUTES && getDuration() >= 0) {
            result = tariffCategory.get(1);
        } else if (getDuration() <= SIXTY_MINUTES
                && getDuration() > THIRTY_MINUTES) {
            result = tariffCategory.get(2);
        } else if (getDuration() <= TWO_HOURS
                && getDuration() > SIXTY_MINUTES) {
            result = tariffCategory.get(LEVEL3);
        } else if (getDuration() <= FOUR_HOURS
                && getDuration() > TWO_HOURS) {
            result = tariffCategory.get(LEVEL4);
        } else {
            result = tariffCategory.get(LOST_TICKET);
        }
        ticket.setFee(result);
        return result;
    }
}
