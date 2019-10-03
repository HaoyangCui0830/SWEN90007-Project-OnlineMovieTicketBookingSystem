package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Ticket;
import service.TicketService;


public class ManagerViewTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Ticket ticket = new Ticket();
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		TicketService ticketService = new TicketService();
		ticket = ticketService.geTicketById(ticketId);
		System.out.println(ticket);
		request.setAttribute("ticket", ticket);

		forward("/jsp/ManagerPages/ManagerViewTicket.jsp");
		
	}
}
