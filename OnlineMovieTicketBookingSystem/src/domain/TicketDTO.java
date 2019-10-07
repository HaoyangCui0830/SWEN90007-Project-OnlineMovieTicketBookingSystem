package domain;

import com.google.gson.Gson;

import dataMapper.TicketMapper;

public class TicketDTO{
	private int ticket_id;
	private String customerName;
	private Movie movie;
	private Session session;
	private Cinema cinema;
	private int seatNumber;
	

	
	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	/**
	 * convert TicketDTO object to Json, for remote access
	 * */
	public static String serialize(TicketDTO ticketDTO) {
		Gson gson = new Gson();
		return gson.toJson(ticketDTO);
	}
	
	/**
	 * Convert Json to MovieDTO
	 * */
	public static TicketDTO deserialize(String ticketString) {
		Gson gson = new Gson();
		return gson.fromJson(ticketString, TicketDTO.class);
	}
	
}
