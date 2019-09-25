package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Ticket;
import service.TicketService;

public class Test {
	public static void main(String[] args) {
//		List<Ticket> list = new ArrayList<Ticket>();
//		list= new TicketService().getAllTickets();
//		System.out.println(list);
		String nameString = "jax";
		List<Ticket> list = new ArrayList<Ticket>();
		list= new TicketService().geTicketByCustomerName(nameString);
		Ticket ticket = list.get(0);
		new TicketService().deleteTicket(ticket);
		
//		Ticket ticket = new Ticket();
//		ticket.setCustomerName("bbbbbb");
//		new TicketService().updateTicket(ticket);
	}
}
