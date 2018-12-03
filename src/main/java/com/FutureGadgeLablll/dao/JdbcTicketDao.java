package com.FutureGadgeLablll.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.FutureGadgeLablll.Ticket;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;

/**
 * An implementation of crud methods which connect the database, with the use of a Spring JdbcTemplate.
 * Dependency Injection has been used to establish a connection between the database and the data access object.
 * Used to store and retrieve data from the database
 */

public class JdbcTicketDao implements TicketDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JdbcTicketDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Ticket createTicket() {
        this.jdbcTemplate.update("INSERT INTO Ticket(entryTime, ticketAvailable) VALUES (CURRENT_TIMESTAMP, TRUE )", new Object[]{});
        return new Ticket();
    }

    @Override
    public Ticket readTicket(Integer ticketId) {
        return this.jdbcTemplate.queryForObject("SELECT ticketId, entryTime, exitTime, ticketAvailable, fee FROM Ticket WHERE ticketId = ?",
                new Object[]{ticketId}, new ParkingMapper());
    }

    @Override
    public List<Ticket> readAllTickets() {
        return this.jdbcTemplate.query("SELECT ticketId, entryTime, exitTime, ticketAvailable, fee FROM Ticket",
                new ParkingMapper());
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        this.jdbcTemplate.update("INSERT INTO Ticket(ticketId, entryTime, exitTime, ticketAvailable, fee) VALUES (?, ?, ?, ?, ?)", new Object[]{});
        return new Ticket();
    }

    @Override
    public Ticket updateTicket(Integer ticketId, Timestamp exitTime, Boolean ticketAvailable, BigDecimal fee) {
        this.jdbcTemplate.update("UPDATE Ticket SET exitTime = ?, ticketAvailable = FALSE, fee = ? WHERE ticketId = ?", exitTime, ticketAvailable, fee, ticketId);
        return new Ticket();
    }

    @Override
    public int deleteTicket(Integer ticketId) {
        return this.jdbcTemplate.update("DELETE from Ticket WHERE ticketId = ?", new Object[]{});
    }

    @Override
    public void deleteAllTicket() {
        this.jdbcTemplate.update("DELETE from Ticket");

    }

    /**
     * An inner-class which has been used to map variables in accordance with ParkingDAO methods
     * ParkingMapper maps the resultSet to a domain object per row
     */

    public class ParkingMapper implements RowMapper<Ticket> {

        public Ticket mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
            Ticket result = new Ticket();
            result.setTicketId(resultSet.getInt("ticketId"));
            result.setEntryTime(resultSet.getTimestamp("entryTime"));
            result.setExitTime(resultSet.getTimestamp("exitTime"));
            result.setTicketAvailable(resultSet.getBoolean("ticketAvailable"));
            result.setFee(resultSet.getBigDecimal("fee"));

            return result;
        }
    }
}