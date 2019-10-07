package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import domain.Cinema;
import domain.Movie;
import domain.Session;
import domain.Ticket;
import service.CinemaService;
import service.MovieService;
import service.SessionService;
import service.TicketService;

public class ManagerUpdateTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int session = Integer.parseInt(request.getParameter("sessionId"));
		int ticketNo = Integer.parseInt(request.getParameter("ticketId"));
		int seat = Integer.parseInt(request.getParameter("ticketAmount"));
		String cinema = request.getParameter("cinemaId");
		String customerName = request.getParameter("customerName");
		Cinema cinema2 = new CinemaService().getCinemaById(Integer.parseInt(cinema));
		
		MovieService movieService = new MovieService();
		Movie movie = movieService.getMovieById(movieId);
		SessionService sessionService = new SessionService();
		Session session2 = sessionService.getSessionBySessionId(session);
		
		Ticket ticket = new Ticket(customerName, cinema2, movie, session2, seat);
		ticket.setTicket_id(ticketNo);
		
		TicketService ticketService = new TicketService();
		Ticket ticketBefore = ticketService.getTicketById(ticketNo);
		Session sessionBefore = ticketBefore.getSession();
		sessionBefore.setAvailableSeats(sessionBefore.getAvailableSeats() + ticketBefore.getSeatNumber());
		if((session2.getAvailableSeats() - seat)>=0) {
			session2.setAvailableSeats(session2.getAvailableSeats() - seat);
		}else {
			System.out.println("Sorry, there are not that many seats");
			out.print("<script>alert('Sorry, there are not that many seats');</script>");
			return;
		}
		sessionService.updateSession(sessionBefore, request.getSession().getId());
		sessionService.updateSession(session2, request.getSession().getId());
		ticketService.updateTicket(ticket, request.getSession().getId());
	}

}
