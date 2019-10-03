package service;
import java.util.List;

import dataMapper.TicketMapper;

import domain.Ticket;
import utils.IdentityMap;
import utils.UnitOfWork;

public class TicketService {
	TicketMapper ticketMapper;
	
	public TicketService() {
		this.ticketMapper = new TicketMapper();// TODO Auto-generated constructor stub
	}
	
	public List<Ticket> getAllTickets(){
		
//		List<Ticket> tickets = new ArrayList<Ticket>();
//		tickets = ticketMapper.findAllTickets();
		return ticketMapper.findAllTickets();
	}
	
	public Ticket geTicketById(int ticketId) {
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
	
	public List<Ticket> geTicketByCustomerName(String name) {
	
		return ticketMapper.findTicketsByCustomerName(name);
	
	}
	
	public void insertTicket(Ticket ticket) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(ticket);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteTicket(Ticket ticket) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(ticket);
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateTicket(Ticket ticket) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(ticket);
		UnitOfWork.getCurrent().commit();
	}
	
	
	
	
}
