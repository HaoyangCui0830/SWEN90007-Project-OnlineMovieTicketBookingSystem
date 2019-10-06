package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Ticket;
import domain.User;
import service.TicketService;

public class CustomerViewTicketsCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().write("please login to check your tickets");
		}
		List<Ticket> list = new ArrayList<Ticket>();
		list = new TicketService().geTicketByCustomerName(user.getUsername());
		request.setAttribute("tickets", list);
		forward("/jsp/CustomerPages/CustomerViewTickets.jsp");
	}

}
