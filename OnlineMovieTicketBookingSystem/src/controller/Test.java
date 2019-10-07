package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Session;
import domain.Ticket;
import domain.TicketAssembler;
import domain.TicketDTO;
import service.SessionService;
import service.TicketService;

public class Test {
	public static void main(String[] args) {
		Ticket ticket = new TicketService().getTicketById(1);
		int oldSeats =ticket.getSeatNumber();
		Session oleSession = ticket.getSession();
		
		System.out.println("之前的场次：" + ticket.getSession().getSessionId() +  "前座位" + ticket.getSession().getAvailableSeats());
		Session newsession = new SessionService().getSessionBySessionId(2);
		System.out.println("新场次之前的座位" + newsession.getAvailableSeats());
		
		ticket.setSeatNumber(3);
		ticket.setSession(newsession);
		
		oleSession.setAvailableSeats(oleSession.getAvailableSeats() + oldSeats);
		newsession.setAvailableSeats(newsession.getAvailableSeats()- ticket.getSeatNumber());
		new TicketService().updateTicket(ticket, "11");

		
//		new TicketService().insertTicket(ticket2, "11");
//		System.out.println("前座位" + ticket.getSession().getAvailableSeats());
		
		
	}
}
