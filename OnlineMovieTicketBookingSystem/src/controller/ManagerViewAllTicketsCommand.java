package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import domain.Ticket;
import domain.User;
import service.MovieService;
import service.TicketService;

public class ManagerViewAllTicketsCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check all tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			List<Ticket> tickets = new ArrayList<Ticket>();
			TicketService ticketService = new TicketService();
			tickets = ticketService.getAllTickets();
			request.setAttribute("tickets", tickets);
			forward("/jsp/ManagerPages/ManagerViewAllTickets.jsp");
		}
		
	}

}
