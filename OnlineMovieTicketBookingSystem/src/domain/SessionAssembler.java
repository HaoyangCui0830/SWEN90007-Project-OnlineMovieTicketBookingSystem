package domain;

import java.sql.Time;

import dataMapper.SessionMapper;

public class SessionAssembler {

	public static SessionDTO createSessionDTO(Session session) {
		SessionDTO sessionDTO = new SessionDTO();
		sessionDTO.setMovieId(session.getMovieId());
		sessionDTO.setAvailableSeats(session.getAvailableSeats());
		sessionDTO.setSeats(session.getSeats());
		sessionDTO.setSessionId(session.getSessionId());
		sessionDTO.setStartTime(session.getTimeRange().getStartTime().toString());
		sessionDTO.setEndTime(session.getTimeRange().getEndTime().toString());
		return sessionDTO;
	}
	
	public static boolean updateSession(SessionDTO sessionDTO) {
		Session session =  new Session();
		session.setAvailableSeats(sessionDTO.getAvailableSeats());
		session.setEndTime(Time.valueOf(sessionDTO.getEndTime()));
		session.setMovieId(sessionDTO.getMovieId());
		session.setSeats(sessionDTO.getSeats());
		session.setSessionId(sessionDTO.getSessionId());
		session.setStartTime(Time.valueOf(sessionDTO.getStartTime()));
		
		boolean result = false;
		try {
			result = new SessionMapper().update(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static boolean addSession(SessionDTO sessionDTO) {
		Session session =  new Session();
		session.setAvailableSeats(sessionDTO.getAvailableSeats());
		session.setEndTime(Time.valueOf(sessionDTO.getEndTime()));
		session.setMovieId(sessionDTO.getMovieId());
		session.setSeats(sessionDTO.getSeats());
		session.setSessionId(sessionDTO.getSessionId());
		session.setStartTime(Time.valueOf(sessionDTO.getStartTime()));
		
		boolean result = false;
		try {
			result = new SessionMapper().insert(session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
