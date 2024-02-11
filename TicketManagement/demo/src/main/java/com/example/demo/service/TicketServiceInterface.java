package com.example.demo.service;

import com.example.demo.model.Ticket;

import java.util.List;

public interface TicketServiceInterface {

    Ticket saveTicket(Ticket ticket);
    List<Ticket> findAllTickets();
    Ticket findTicketById(Integer id);
    Ticket updateDestinationById
            (Integer id, String destination);
    boolean deleteTicketById(Integer id);

    List<Ticket> findByDestination(String destination);


}
