package com.example.demo.dao;

import com.example.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketDao extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByDestination(String destination);
}
