package remoteFacade;

import dataMapper.SessionMapper;
import domain.Session;
import domain.SessionAssembler;
import domain.SessionDTO;

public class SessionServiceBean {

	/**
	 * get SessionDTO object
	 * */
	public SessionDTO getSession(int id) {
		Session session = new SessionMapper().findSessionById(id);
		SessionDTO sessionDTO = SessionAssembler.createSessionDTO(session);
		return sessionDTO;
	}
	
	/**
	 * get Session Json
	 * */
	public String getSessionJson(int id) {
		Session session = new SessionMapper().findSessionById(id);
		SessionDTO sessionDTO = SessionAssembler.createSessionDTO(session);
		return SessionDTO.serialize(sessionDTO);
	}
	
	/**
	 * update Session based on input DTO
	 * */
	public boolean updateSession(SessionDTO sessionDTO) {
		return SessionAssembler.updateSession(sessionDTO);
	}
	
	/**
	 * update Session based on input JSON
	 * */
	public boolean updateSessionJson(String json) {
		SessionDTO sessionDTO = SessionDTO.deserialize(json);
		return SessionAssembler.updateSession(sessionDTO);
	}
	
	/**
	 * add Session based on input DTO
	 * */
	public boolean addSession(SessionDTO sessionDTO) {
		return SessionAssembler.addSession(sessionDTO);
	}
	
	/**
	 * add Session based on input JSON
	 * */
	public boolean addSessionJson(String json) {
		SessionDTO sessionDTO = SessionDTO.deserialize(json);
		return SessionAssembler.addSession(sessionDTO);
	}
	
}
