package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import domain.DomainObject;
import domain.Session;
import utils.DBConnection;
import utils.IdentityMap;

public class SessionMapper extends DataMapper{

	
	/**
	 * @param DomainObject
	 * Insert new Session into Session DB
	 * */
	@Override
	public boolean insert(DomainObject object) {
		Session session = (Session)object;
		String insertSessionString = "INSERT INTO sessions (startTime, endTime, "
				+ "MovieId, total_seats, available_seats) VALUES"
				+ "(?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertSessionString);
			stmt.setTime(1, session.getTimeRange().getStartTime());
			stmt.setTime(2, session.getTimeRange().getEndTime());
			stmt.setInt(3, session.getMovieId());
			stmt.setInt(4, session.getSeats());
			stmt.setInt(5, session.getAvailableSeats());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert session Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
	/**
	 * @param DomainObject
	 * Delete new Session from Session DB
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		Session session = (Session)object;
		String deleteSessionString = "DELETE FROM sessions WHERE session_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteSessionString);
			stmt.setInt(1, session.getSessionId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete session Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	
	
	/**
	 * @param DomainObject
	 * Update new Session into Session DB
	 * */
	@Override
	public boolean update(DomainObject object) throws Exception {
		Session session = (Session)object;
		String updateSessionString = "UPDATE sessions SET startTime = ?,"
				+ "endTime = ?, total_seats = ?, available_seats = ? WHERE session_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateSessionString);
			stmt.setTime(1, session.getTimeRange().getStartTime());
			stmt.setTime(2, session.getTimeRange().getEndTime());
			stmt.setInt(3, session.getSeats());
			stmt.setInt(4, session.getAvailableSeats());
			stmt.setInt(5, session.getSessionId());
			System.out.println(session.getSessionId());
			//stmt.setInt(6, session.getMovieId());
			result = stmt.executeUpdate();
			// TODO Test for concurrency Control
			// TimeUnit.SECONDS.sleep(5);
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update session Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Find all Session info from Session DB
	 * */
	public List<Session> findAllSessionsByMovieId(int MovieId){
		String findAllSessionString = "SELECT * FROM sessions WHERE MovieId = ?";
		List<Session> result = new ArrayList<Session>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllSessionString);
			stmt.setInt(1, MovieId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Session session = new Session();
				IdentityMap<Session> identityMap = IdentityMap.getInstance(session);
				session.setSessionId(rs.getInt(1));
				session.setStartTime(Time.valueOf(rs.getString(2)));
				session.setEndTime(Time.valueOf(rs.getString(3)));
				session.setMovieId(rs.getInt(4));
				session.setSeats(rs.getInt(5));
				session.setAvailableSeats(rs.getInt(6));
				identityMap.put(session.getSessionId(), session);
				result.add(session);
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view session Problem");
		}
		return result;
	}
	
	
	/**
	 * @param SessionId
	 * find one specific Session from Session DB
	 * */
	public Session findSessionById(int sessionId) {
		String findSessionByIdString = "SELECT * FROM sessions WHERE session_id = ?";
		Session result = new Session();
		try {
			PreparedStatement stmt = DBConnection.prepare(findSessionByIdString);
			stmt.setInt(1, sessionId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Session session = new Session();
				IdentityMap<Session> identityMap = IdentityMap.getInstance(session);
				session.setSessionId(rs.getInt(1));
				session.setStartTime(Time.valueOf(rs.getString(2)));
				session.setEndTime(Time.valueOf(rs.getString(3)));
				session.setMovieId(rs.getInt(4));
				session.setSeats(rs.getInt(5));
				session.setAvailableSeats(rs.getInt(6));
				identityMap.put(session.getSessionId(), session);
				result = session;
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by session id Problem");
		}
		return result;
	}

}
