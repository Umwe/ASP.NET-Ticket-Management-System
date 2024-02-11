package com.example.demo;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketServiceInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TicketTest {

    @Autowired
    private TicketServiceInterface ticketServiceInterface;

    private Ticket testTicket;

    @BeforeEach
    public void setUp() {
        // Adding a ticket before each test
        testTicket = new Ticket();
        testTicket.setTicketId(1);
        testTicket.setPassengerName("Africa");
        testTicket.setSource("Kigali");
        testTicket.setDestination("Musanze");
        ticketServiceInterface.saveTicket(testTicket);
    }

    @AfterEach
    public void tearDown() {
        // Deleting the ticket after each test
        ticketServiceInterface.deleteTicketById(testTicket.getTicketId());
    }

    @Test
    public void testSave() {
        Ticket t = new Ticket();
        t.setTicketId(2);
        t.setPassengerName("John");
        t.setSource("London");
        t.setDestination("New York");

        Ticket ticket = ticketServiceInterface.saveTicket(t);

        assertEquals("New York", ticket.getDestination());
    }

    @Test
    public void testFindAll() {
        List<Ticket> tickets = ticketServiceInterface.findAllTickets();
        assertEquals(1, tickets.size());
    }

    @Test
    public void testFindById() {
        Ticket ticket = ticketServiceInterface.findTicketById(testTicket.getTicketId());
        assertEquals("Musanze", ticket.getDestination());
    }

    @Test
    public void testUpdateDestination() {
        Ticket updateTicket = ticketServiceInterface.updateDestinationById(testTicket.getTicketId(), "Rubavu");
        assertEquals("Rubavu", updateTicket.getDestination());
    }

    @Test
    public void testDelete() {
        boolean isDeleted = ticketServiceInterface.deleteTicketById(testTicket.getTicketId());
        assertTrue(isDeleted);

        Ticket ticket = ticketServiceInterface.findTicketById(testTicket.getTicketId());
        assertNull(ticket);
    }


    @Test
    public void testNegativeFindById() {
        Ticket ticket = ticketServiceInterface.findTicketById(8);
        assertNull(ticket);
    }

    @Test
    public void findByDestinationTest(){
        List<Ticket> tickets = ticketServiceInterface.findByDestination("Huye");
        assertNotNull(tickets);
    }
}
