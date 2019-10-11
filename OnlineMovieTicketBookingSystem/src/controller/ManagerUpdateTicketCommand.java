package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import domain.Cinema;
import domain.Movie;
import domain.Session;
import domain.Ticket;
import domain.User;
import service.CinemaService;
import service.MovieService;
import service.SessionService;
import service.TicketService;

public class ManagerUpdateTicketCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to view tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
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
			
			/* if a manager change a ticket, the available seats of session before should be restore. 
			 * check if session after has enough seats
			 * */
			
			sessionBefore.setAvailableSeats(sessionBefore.getAvailableSeats() + ticketBefore.getSeatNumber());
			if((session2.getAvailableSeats() - seat)>=0) {
				session2.setAvailableSeats(session2.getAvailableSeats() - seat);
			}else {
				System.out.println("Sorry, there are not that many seats");
				out.print("<script>alert('Sorry, there are not that many seats');</script>");
				return;
			}
			
			//update ticket, session before, session through unit of work
			boolean result = ticketService.updateTicket(ticket,sessionBefore, request.getSession().getId());
			System.out.print("ticket id"+ ticket.getId());
			System.out.print("http session id"+ request.getSession().getId());
			if(result == true) {
				response.getWriter().write("successfully");
				forward("/jsp/ManagerPages/ManagerHomePage.jsp");
			}
			else {
				forward("/jsp/errorPage.jsp");
			}
		}
		
	}

}
