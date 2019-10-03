package domain;

import dataMapper.TicketMapper;

public class Ticket extends DomainObject{
	private int ticket_id = -1;
	private String customerName = null;
	private Movie movie = null;
	private Session session = null;
	private Cinema cinema =null;
	private int seatNumber = -1;

	
	public Ticket(String name, Cinema cinema,Movie movie, Session session,  int seatNumber) {
		super();
		this.customerName = name;
		this.cinema = cinema;
		this.movie = movie;
		this.session = session;
		this.seatNumber = seatNumber;
	}
	
	public Ticket() {
	
	}
	
	public int getTicket_id() {
		if (this.ticket_id==-1) {
			load();
		}
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public Movie getMovie() {
		if (this.movie==null) {
			load();
		}
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Session getSession() {
		if (this.session==null) {
			load();
		}
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}

	public String getCustomerName() {
		if (this.customerName==null) {
			load();
		}
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getSeatNumber() {
		if (this.seatNumber== -1) {
			load();
		}
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Cinema getCinema() {
		if (this.cinema==null) {
			load();
		}
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	void load() {
		Ticket ticket = new TicketMapper().findTicketById(this.ticket_id);
		if(this.cinema ==null) {
			this.cinema = ticket.cinema;
		}
		if(this.customerName == null) {
			this.customerName = ticket.customerName;
		}
		if (this.movie == null) {
			this.movie = ticket.movie;
		}
		if (this.seatNumber==-1) {
			this.seatNumber = ticket.seatNumber;
		}
		if(this.session ==null) {
			this.session = ticket.session;
		}	
	}

	@Override
	public String toString() {
		return "Ticket [customerName=" + customerName
				+ ", movie=" + movie.getName() + ", session="
				+ session.getTimeRange().getStartTime()+"------"+session.getTimeRange().getEndTime() + ", cinema=" + cinema.getName() + ", seatNumber=" + seatNumber + "]";
	}
	
}
