package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import dataMapper.CinemaMovieMapper;
import domain.Cinema;
import domain.CinemaMovie;
import domain.Movie;
import domain.Session;
import domain.ThreeDMovie;
import domain.Ticket;
import service.CinemaService;
import service.MovieService;
import service.SessionService;
import service.ThreeDMovieService;
import service.TicketService;

public class CustomerConfirmTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		int session = Integer.parseInt(request.getParameter("sessionId"));
		int ticketNo = Integer.parseInt(request.getParameter("ticketAmount"));
		String cinema = request.getParameter("cinema");
		String customerName = request.getParameter("CustomerName");
		Cinema cinema2 = new CinemaService().getCinemaById(Integer.parseInt(cinema));
//		System.out.println(cinema2.getName());
		
		MovieService movieService = new MovieService();
		Movie movie = movieService.getMovieById(movieId);
		SessionService sessionService = new SessionService();
		Session session2 = sessionService.getSessionBySessionId(session);
		
		if(ticketNo>session2.getAvailableSeats()) {
			System.out.println("Sorry, there are not that many seats");
			out.print("<script>alert('Sorry, there are not that many seats');</script>");
//			forward("/jsp/CustomerPages/CustomerHomePage.jsp");
			return;
		}	
		
		Ticket ticket = new Ticket(customerName, cinema2, movie, session2, ticketNo);
		TicketService tService = new TicketService();
		tService.insertTicket(ticket);
		forward("/jsp/CustomerPages/CustomerHomePage.jsp");
	}
	
}
