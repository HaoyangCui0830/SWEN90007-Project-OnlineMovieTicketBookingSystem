package domain;

import dataMapper.MovieMapper;
import dataMapper.SessionMapper;
import dataMapper.TicketMapper;
import service.SessionService;
import service.TicketService;

public class TicketAssembler {
	
	public static TicketDTO createTicketDTO(Ticket ticket) {
		TicketDTO ticketDTO = new TicketDTO();
		ticketDTO.setTicket_id(ticket.getTicket_id());
		ticketDTO.setMovie(ticket.getMovie());
		ticketDTO.setSession(ticket.getSession());
		ticketDTO.setCinema(ticket.getCinema());
		ticketDTO.setCustomerName(ticket.getCustomerName());
		ticketDTO.setSeatNumber(ticket.getSeatNumber());
		return ticketDTO;
	}
	
	public static boolean updateTicket(TicketDTO ticketDTO) {
		Ticket ticket = new Ticket();
		ticket.setTicket_id(ticketDTO.getTicket_id());
		ticket.setMovie(ticketDTO.getMovie());
		ticket.setSession(ticketDTO.getSession());
		ticket.setCinema(ticketDTO.getCinema());
		ticket.setCustomerName(ticketDTO.getCustomerName());
		ticket.setSeatNumber(ticketDTO.getSeatNumber());
		boolean result = false;
		Ticket oldTicket = new TicketService().getTicketById(ticketDTO.getTicket_id());
		Session oldSession = oldTicket.getSession();
		oldSession.setAvailableSeats(oldSession.getAvailableSeats() + oldTicket.getSeatNumber());
		Session newSession = ticketDTO.getSession();
		newSession.setAvailableSeats(newSession.getAvailableSeats() - ticketDTO.getSeatNumber());
		if (newSession.getAvailableSeats() - ticketDTO.getSeatNumber() <0) {
			System.out.println("new Session does not have enough seats");
			return result;
		}
				
		try {
			boolean resultTickUpdate = new TicketMapper().update(ticket);
			boolean resultOldSession = new SessionMapper().update(oldSession);
			boolean resultNewSession = new SessionMapper().update(newSession);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean addTicket(TicketDTO ticketDTO) {
		Ticket ticket = new Ticket();
		ticket.setTicket_id(ticketDTO.getTicket_id());
		ticket.setMovie(ticketDTO.getMovie());
		ticket.setSession(ticketDTO.getSession());
		ticket.setCinema(ticketDTO.getCinema());
		ticket.setCustomerName(ticketDTO.getCustomerName());
		ticket.setSeatNumber(ticketDTO.getSeatNumber());
		Session session = ticketDTO.getSession();
		session.setAvailableSeats(session.getAvailableSeats() - ticketDTO.getSeatNumber());
		boolean result = false;
		try {
			result = new TicketMapper().update(ticket);
			//new SessionMapper().update(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
}
