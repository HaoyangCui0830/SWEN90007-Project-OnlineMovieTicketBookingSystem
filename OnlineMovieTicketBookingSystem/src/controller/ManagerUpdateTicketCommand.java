package controller;

import java.io.IOException;

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
		Ticket ticketSeatBefore = ticketService.geTicketById(ticketNo);
		
		int seatBefore = ticketSeatBefore.getSeatNumber();
		if(seatBefore!= seat)
		{
			int seatAfter= session2.getAvailableSeats() + seatBefore - seat;
			session2.setAvailableSeats(seatAfter);
			sessionService.updateSession(session2);
		}
		ticketService.updateTicket(ticket);
	}

}
