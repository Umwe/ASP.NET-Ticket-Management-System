package com.example.demo.service;

import com.example.demo.dao.TicketDao;
import com.example.demo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImplementation implements TicketServiceInterface{

    @Autowired
    private TicketDao ticketDao;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    public List<Ticket> findAllTickets() {
        return ticketDao.findAll();
    }

    @Override
    public Ticket findTicketById(Integer id) {
        return ticketDao.findById(id).orElse(null);

    }
    @Override
    public Ticket updateDestinationById(Integer id, String destination) {
        Ticket ticket = ticketDao.findById(id).orElse(null);
        if(ticket != null) {
            ticket.setDestination(destination);
            return ticketDao.save(ticket);
        }else{
            return null;
        }
    }

    @Override
    public boolean deleteTicketById(Integer id) {
        Ticket ticket = ticketDao.findById(id).orElse(null);
        if(ticket != null) {
            ticketDao.delete(ticket);
            return true;
        }
        return false;
        }

    @Override
    public List<Ticket> findByDestination(String destination) {
        return ticketDao.findByDestination(destination);
    }
}
