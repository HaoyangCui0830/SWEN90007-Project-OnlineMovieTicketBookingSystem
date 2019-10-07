package service;
import java.util.List;

import dataMapper.SessionMapper;
import dataMapper.TicketMapper;
import domain.Session;
import domain.Ticket;
import utils.IdentityMap;
import utils.UnitOfWork;

public class TicketService {
	TicketMapper ticketMapper;
	
	public TicketService() {
		this.ticketMapper = new TicketMapper();
	}
	
	public List<Ticket> getAllTickets(){
		return ticketMapper.findAllTickets();
	}
	
	public Ticket getTicketById(int ticketId) {
		Ticket ticket = new Ticket();
		ticket.setTicket_id(ticketId);
		IdentityMap<Ticket> identityMap = IdentityMap.getInstance(ticket);
		Ticket ticketIndentityMap = identityMap.get(ticket.getTicket_id());
		if(ticketIndentityMap !=null) {
			Ticket result = ticketIndentityMap;
			return result;
		}else {
			return ticketMapper.findTicketById(ticketId);
		}
	}
	
	public List<Ticket> getTicketByCustomerName(String name) {
	
		return ticketMapper.findTicketsByCustomerName(name);
	
	}
	
	public boolean insertTicket(Ticket ticket,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(ticket);
		UnitOfWork.getCurrent().registerDirty(ticket.getSession());
		boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	public boolean deleteTicket(Ticket ticket, String owner) {

		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(ticket);
		UnitOfWork.getCurrent().registerDirty(ticket.getSession());
		
		boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	public boolean updateTicket(Ticket ticket, Session oldSession, String owner) {
//		Ticket oldTicket = new TicketService().getTicketById(ticket.getTicket_id());
//		Session oldSession = oldTicket.getSession();
//		oldSession.setAvailableSeats(oldSession.getAvailableSeats() + oldTicket.getSeatNumber());
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(ticket);
		UnitOfWork.getCurrent().registerDirty(ticket.getSession());
		UnitOfWork.getCurrent().registerDirty(oldSession);
		boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	
	
	
}
