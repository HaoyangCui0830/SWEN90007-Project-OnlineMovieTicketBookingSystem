package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Cinema;
import domain.DomainObject;
import domain.Movie;
import domain.Session;
import domain.Ticket;
import utils.DBConnection;
import utils.IdentityMap;

public class TicketMapper extends DataMapper{
	
	@Override
	public boolean insert(DomainObject object) {
		Ticket ticket = (Ticket)object;
		String insertTicketString = "INSERT INTO ticket (name, movie_id, session_id)"
				+ "VALUES(?,?,?)";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertTicketString);
			stmt.setString(1, ticket.getCustomerName());
			stmt.setInt(2, ticket.getMovie().getMovieId());
			stmt.setInt(3, ticket.getSession().getSessionId());
			stmt.setInt(4, ticket.getCinema().getCinemaId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			System.out.println(result);
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert ticket Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean delete(DomainObject object) throws Exception {
		Ticket ticket = (Ticket)object;
		String deleteTicketString = "DELETE FROM ticket WHERE ticket_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteTicketString);
			stmt.setInt(1, ticket.getTicket_id());
			result = stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete ticket Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean update(DomainObject object) throws Exception {
		Ticket ticket = (Ticket)object;
		String updateTicketString = "UPDATE ticket SET name = ?,"
				+ "movie_id = ?, session_id = ?, cinema_id=?, seatnumber=?,WHERE ticket_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateTicketString);
			stmt.setString(1, ticket.getCustomerName());
			stmt.setInt(2, ticket.getMovie().getMovieId());
			stmt.setInt(3, ticket.getSession().getSessionId());
			stmt.setInt(4, ticket.getCinema().getCinemaId());
			stmt.setInt(5, ticket.getSeatNumber());
			stmt.setInt(6, ticket.getTicket_id());
			result = stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update ticket Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public List<Ticket> findAllTickets(){
		String findAllTicketString = "Select * FROM ticket";
		List<Ticket> result = new ArrayList<Ticket>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllTicketString);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Ticket ticket = new Ticket();
				IdentityMap<Ticket> identityMap = IdentityMap.getInstance(ticket);
				ticket.setTicket_id(rs.getInt(1));
				ticket.setCustomerName(rs.getString(2));
				Movie movie = new MovieMapper().findMovieById(rs.getInt(3));
				ticket.setMovie(movie);
				Session session = new SessionMapper().findSessionById(rs.getInt(4));
				ticket.setSession(session);
				Cinema cinema = new CinemaMapper().findCinemaById(rs.getInt(5));
				ticket.setCinema(cinema);
				ticket.setSeatNumber(rs.getInt(6));
				identityMap.put(ticket.getTicket_id(), ticket);
				result.add(ticket);
//				movie.setMovieId(rs.getInt(1));
//				movie.setName(rs.getString(2));
//				movie.setLength(rs.getTime(3));
//				movie.setPrice(rs.getFloat(4));
//				identityMap.put(movie.getMovieId(), movie);
//				result.add(movie);
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view ticket Problem");
		}
		return result;
	}

	public List<Ticket> findTicketsByCustomerName(String name){
		String findTicketsByCustomerName = "SELECT * FROM ticket WHERE name = ?";
		List<Ticket> result = new ArrayList<Ticket>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findTicketsByCustomerName);
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Ticket ticket = new Ticket();
//				IdentityMap<Ticket> identityMap = IdentityMap.getInstance(ticket);
				ticket.setTicket_id(rs.getInt(1));
				ticket.setCustomerName(rs.getString(2));
				Movie movie = new MovieMapper().findMovieById(rs.getInt(3));
				ticket.setMovie(movie);
				Session session = new SessionMapper().findSessionById(rs.getInt(4));
				ticket.setSession(session);
				Cinema cinema = new CinemaMapper().findCinemaById(rs.getInt(5));
				ticket.setCinema(cinema);
				ticket.setSeatNumber(rs.getInt(6));
//				identityMap.put(ticket.getTicket_id(), ticket);
				result.add(ticket);
				
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view ticket by "
					+ "customer name Problem");
		}
		return result;
	
	}

	public Ticket findTicketById(int ticketId) {
		String findTicketById = "SELECT * FROM ticket WHERE ticket_id = ?";
		Ticket result = new Ticket();
		try {
			PreparedStatement stmt = DBConnection.prepare(findTicketById);
			stmt.setInt(1, ticketId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Ticket ticket = new Ticket();
//				IdentityMap<Ticket> identityMap = IdentityMap.getInstance(ticket);
				ticket.setTicket_id(rs.getInt(1));
				ticket.setCustomerName(rs.getString(2));
				Movie movie = new MovieMapper().findMovieById(rs.getInt(3));
				ticket.setMovie(movie);
				Session session = new SessionMapper().findSessionById(rs.getInt(4));
				ticket.setSession(session);
				Cinema cinema = new CinemaMapper().findCinemaById(rs.getInt(5));
				ticket.setCinema(cinema);
//				identityMap.put(ticket.getTicket_id(), ticket);
				result = ticket;
				
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view ticket by "
					+ "ID Problem");
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
