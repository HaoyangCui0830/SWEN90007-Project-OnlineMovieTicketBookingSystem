package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import domain.Ticket;
import service.SessionService;
import service.TicketService;

public class ManagerDeleteTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		int ticketNo = Integer.parseInt(request.getParameter("ticketId"));
		TicketService ticketService = new TicketService();
		Ticket ticket = ticketService.geTicketById(ticketNo);
		int seats = ticket.getSeatNumber();
		
		ticketService.deleteTicket(ticket);
		SessionService sessionService = new SessionService();
		Session session = ticket.getSession();
		session.setAvailableSeats(session.getAvailableSeats() + seats);
		sessionService.updateSession(session);
	}

}
