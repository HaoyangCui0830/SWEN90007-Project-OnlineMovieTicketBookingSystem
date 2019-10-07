package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import domain.Ticket;
import service.TicketService;

public class ManagerDeleteTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		int ticketNo = Integer.parseInt(request.getParameter("ticketId"));
		TicketService ticketService = new TicketService();
		Ticket ticket = ticketService.getTicketById(ticketNo);
		int seats = ticket.getSeatNumber();
		
		Session session = ticket.getSession();
		session.setAvailableSeats(session.getAvailableSeats() + seats);
		boolean result = ticketService.deleteTicket(ticket, request.getSession().getId());
		if(result == true) {
			forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		}
		else {
			forward("/jsp/errorPage.jsp");
		}
	}

}
