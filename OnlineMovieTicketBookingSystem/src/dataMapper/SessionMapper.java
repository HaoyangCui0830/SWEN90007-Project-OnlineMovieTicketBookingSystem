package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import domain.DomainObject;
import domain.Session;
import utils.DBConnection;
import utils.IdentityMap;

public class SessionMapper extends DataMapper{

	@Override
	public boolean insert(DomainObject object) {
		Session session = (Session)object;
		String insertSessionString = "INSERT INTO sessions (session_id, startTime, endTime, "
				+ "MovieId, total_seats, available_seats) VALUES"
				+ "(?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertSessionString);
			stmt.setInt(1, session.getSessionId());
			stmt.setTime(2, session.getTimeRange().getStartTime());
			stmt.setTime(3, session.getTimeRange().getEndTime());
			stmt.setInt(4, session.getMovieId());
			stmt.setInt(5, session.getSeats());
			stmt.setInt(6, session.getAvailableSeats());
			result = stmt.executeUpdate();
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

	@Override
	public boolean delete(DomainObject object) throws Exception {
		Session session = (Session)object;
		String deleteSessionString = "DELETE FROM sessions WHERE session_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteSessionString);
			stmt.setInt(1, session.getSessionId());
			result = stmt.executeUpdate();
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

	@Override
	public boolean update(DomainObject object) throws Exception {
		Session session = (Session)object;
		String updateSessionString = "UPDATE sessions SET startTime = ?,"
				+ "endTime = ?, total_seats = ?, available_seats = ? WHERE session_id = ? AND MovieId = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateSessionString);
			stmt.setTime(1, session.getTimeRange().getStartTime());
			stmt.setTime(2, session.getTimeRange().getEndTime());
			stmt.setInt(3, session.getSeats());
			stmt.setInt(4, session.getAvailableSeats());
			stmt.setInt(5, session.getSessionId());
			stmt.setInt(6, session.getMovieId());
			result = stmt.executeUpdate();
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
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view session Problem");
		}
		return result;
	}
	
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
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by session id Problem");
		}
		return result;
	}

}
