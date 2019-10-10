package domain;

import com.google.gson.Gson;

import dataMapper.TicketMapper;

public class TicketDTO{
	private int ticket_id;
	private String customerName;
	private String movieDTOJSON;
	private String sessionDTOJSON;
	private String cinemaDTOJSON;
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

	public String getMovie() {
		return movieDTOJSON;
	}

	public void setMovie(String movieDTOJSON) {
		this.movieDTOJSON = movieDTOJSON;
	}

	public String getSession() {
		return sessionDTOJSON;
	}

	public void setSession(String sessionDTOJSON) {
		this.sessionDTOJSON = sessionDTOJSON;
	}

	public String getCinema() {
		return cinemaDTOJSON;
	}

	public void setCinema(String cinemaDTOJSON) {
		this.cinemaDTOJSON = cinemaDTOJSON;
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
