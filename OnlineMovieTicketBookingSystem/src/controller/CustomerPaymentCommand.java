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

public class CustomerPaymentCommand extends FrontCommand{
	@Override
	public void process() throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int session = Integer.parseInt(request.getParameter("sessionId"));
		int ticketNo = Integer.parseInt(request.getParameter("ticketAmount"));
		SessionService sessionService = new SessionService();
		Session session2 = sessionService.getSessionBySessionId(session);
		if(ticketNo>session2.getAvailableSeats()) {
			System.out.println("Sorry, there are not that many seats");
			out.print("<script>alert('Sorry, there are not that many seats');</script>");
//			forward("/jsp/CustomerPages/CustomerHomePage.jsp");
			return;
		}
		String cinema = request.getParameter("cinemaId");
		String customerName = request.getParameter("customerName");
		Cinema cinema2 = new CinemaService().getCinemaById(Integer.parseInt(cinema));
//		System.out.println(cinema2.getName());
		
		MovieService movieService = new MovieService();
		Movie movie = movieService.getMovieById(movieId);

		Ticket ticket = new Ticket(customerName, cinema2, movie, session2, ticketNo);
		System.out.println(ticket);
		new TicketService().insertTicket(ticket);
		session2.setAvailableSeats(session2.getAvailableSeats() - ticketNo);
		sessionService.updateSession(session2);
	}
}
