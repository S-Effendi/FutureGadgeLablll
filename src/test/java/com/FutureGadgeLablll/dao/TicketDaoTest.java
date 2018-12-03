package com.FutureGadgeLablll.dao;

import com.FutureGadgeLablll.Ticket;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "/spring/application_context.xml",
        "/spring/flyway-init.xml"
})

@FlywayTest
public class TicketDaoTest {

    @Autowired
    JdbcTicketDao ticketDao;

    @Test
    public void returnDatabaseData(){
        List<Ticket> result = ticketDao.readAllTickets();
        Assert.assertEquals( 1, result.size());
    }

    @Test
    public void returnDataItem(){
        Ticket result = ticketDao.readTicket(1);
        Assert.assertEquals(BigDecimal.valueOf(10.50), result.getFee().setScale(1) );
    }
}
