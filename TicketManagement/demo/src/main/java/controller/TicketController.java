package controller;


import com.example.demo.model.Ticket;
import com.example.demo.service.TicketServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/id")
public class TicketController {

    @Autowired
    private TicketServiceInterface ticketServiceInterface;

    @PostMapping("tickets")
    public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
                Ticket savedTicket = ticketServiceInterface.saveTicket(ticket);
        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }
    




}
