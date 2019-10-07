package remoteFacade;

import dataMapper.TicketMapper;
import domain.Ticket;
import domain.TicketAssembler;
import domain.TicketDTO;

public class TicketServiceBean {
	
	public TicketDTO getTicket(int id) {
		Ticket ticket = new TicketMapper().findTicketById(id);
		TicketDTO ticketDTO = TicketAssembler.createTicketDTO(ticket);
		return ticketDTO;
	} 
	
	public String getTicketString(int id){
		Ticket ticket = new TicketMapper().findTicketById(id);
		TicketDTO ticketDTO = TicketAssembler.createTicketDTO(ticket);
		return TicketDTO.serialize(ticketDTO);
	}
	
	public boolean addTicket(TicketDTO ticketDTO){
		return TicketAssembler.addTicket(ticketDTO);
	}
	
	public boolean addTicketJson(String json) {
		TicketDTO ticketDTO = TicketDTO.deserialize(json);
		return TicketAssembler.addTicket(ticketDTO);
	}
	
	public boolean updateTicket(TicketDTO ticketDTO) {
		return TicketAssembler.updateTicket(ticketDTO);
	}
	
	public boolean updateTicketJson(String json) {
		TicketDTO ticketDTO = TicketDTO.deserialize(json);
		return TicketAssembler.updateTicket(ticketDTO);
	}
	
	
}
