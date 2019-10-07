package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import domain.Ticket;
import service.MovieService;
import service.TicketService;

public class ManagerViewAllTicketsCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		TicketService ticketService = new TicketService();
		tickets = ticketService.getAllTickets();
		request.setAttribute("tickets", tickets);
		forward("/jsp/ManagerPages/ManagerViewAllTickets.jsp");
		
	}

}
