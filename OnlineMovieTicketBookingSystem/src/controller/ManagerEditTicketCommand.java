package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import domain.Ticket;
import domain.User;
import service.MovieService;
import service.TicketService;

public class ManagerEditTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			Ticket ticket = new Ticket();
			int ticketId = Integer.parseInt(request.getParameter("ticketId"));
			TicketService ticketService = new TicketService();
			ticket = ticketService.getTicketById(ticketId);
			System.out.println(ticket);
			request.setAttribute("ticket", ticket);

			forward("/jsp/ManagerPages/ManagerEditTicket.jsp");
		}
		
	}

}
