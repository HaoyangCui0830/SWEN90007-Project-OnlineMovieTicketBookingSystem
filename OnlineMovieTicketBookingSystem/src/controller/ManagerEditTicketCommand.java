package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import domain.Ticket;
import service.MovieService;
import service.TicketService;

public class ManagerEditTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Ticket ticket = new Ticket();
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		TicketService ticketService = new TicketService();
		ticket = ticketService.geTicketById(ticketId);
		System.out.println(ticket);
		request.setAttribute("ticket", ticket);

		forward("/jsp/ManagerPages/ManagerEditTicket.jsp");
	}

}
