package com.FutureGadgeLablll.dao;

import com.FutureGadgeLablll.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Dependency Injection has been used to establish a connection between the
 * database and the data access object.
 * Used to store and retrieve data from the database
 */
public class JdbcTicketDao implements TicketDao {

    /**
     * An implementation of crud methods which connect the database, with the
     * use of a Spring JdbcTemplate.
     */

    private JdbcTemplate jdbcTemplate;

    /**
     * Used as a single reference point which will be used in application
     * context as a bean reference.
     *
     * @param template jdbc template
     */
    public JdbcTicketDao(final JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    /**
     * Sets datasource.
     *
     * @param dataSource used as a single reference point.
     */
    @Autowired
    public void setDataSource(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     *
     */
    @Override
    public void createTicket() {
        this.jdbcTemplate.update("INSERT INTO Ticket(entryTime) "
                + "VALUES (CURRENT_TIMESTAMP )", new Object[] {});
    }

    /**
     * @param ticketId
     * @return
     */
    @Override
    public Ticket readTicket(final Integer ticketId) {
        return this.jdbcTemplate.queryForObject("SELECT ticketId, "
                + "entryTime, exitTime, ticketAvailable, fee FROM Ticket "
                + "WHERE ticketId = ?",
                new Object[] {ticketId}, new ParkingMapper());
    }

    /**
     * @return
     */
    @Override
    public List<Ticket> readAllTickets() {
        return this.jdbcTemplate.query("SELECT ticketId, entryTime,"
                        + " exitTime, ticketAvailable, fee FROM Ticket",
                new ParkingMapper());
    }

    /**
     * @return
     */
    @Override
    public List<Ticket> readUnavailableTickets() {
        return this.jdbcTemplate.query("SELECT ticketId, entryTime,"
                        + " exitTime, ticketAvailable, fee FROM Ticket "
                        + "WHERE ticketAvailable = FALSE",
                new ParkingMapper());
    }

    /**
     * @param ticket
     * @return
     */
    @Override
    public Ticket saveTicket(final Ticket ticket) {
        this.jdbcTemplate.update("INSERT INTO Ticket(ticketId, entryTime,"
                + " exitTime, ticketAvailable, fee) VALUES (?, ?, ?, ?, ?)",
                new Object[] {});
        return new Ticket();
    }

    /**
     * @param ticketId
     * @param exitTime
     * @param ticketAvailable
     * @param fee
     * @return
     */
    @Override
    public Ticket updateTicket(final Integer ticketId, final Timestamp exitTime,
                               final Boolean ticketAvailable,
                               final BigDecimal fee) {

        this.jdbcTemplate.update("UPDATE Ticket SET exitTime = ?, "
                        + "ticketAvailable = TRUE, fee = ? WHERE ticketId = ?",
                exitTime, fee, ticketId);
        return new Ticket(ticketId, ticketAvailable, null, exitTime, fee);
    }

    /**
     * @param ticketId
     * @return
     */
    @Override
    public int deleteTicket(final Integer ticketId) {
        return this.jdbcTemplate.update("DELETE from Ticket "
                + "WHERE ticketId = ?", new Object[] {});
    }

    /**
     *
     */
    @Override
    public void deleteAllTicket() {
        this.jdbcTemplate.update("DELETE from Ticket");
    }

    /**
     * An inner-class which has been used to map variables in accordance
     * with ParkingDAO methods.
     * ParkingMapper maps the resultSet to a domain object per row
     */

    public class ParkingMapper implements RowMapper<Ticket> {

        /**
         * @param resultSet resultSet
         * @param rowNumber rowNumber
         * @return ticket
         * @throws SQLException E
         */
        public Ticket mapRow(final ResultSet resultSet, final int rowNumber)
                throws SQLException {
            Ticket result = new Ticket();
            result.setTicketId(resultSet.getInt("ticketId"));
            result.setEntryTime(resultSet.getTimestamp("entryTime"));
            result.setExitTime(resultSet.getTimestamp("exitTime"));
            result.setTicketIssued(resultSet.getBoolean("ticketAvailable"));
            result.setFee(resultSet.getBigDecimal("fee"));

            return result;
        }
    }
}
