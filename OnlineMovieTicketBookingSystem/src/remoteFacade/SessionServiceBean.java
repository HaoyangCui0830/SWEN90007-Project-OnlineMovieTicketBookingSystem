package remoteFacade;

import dataMapper.SessionMapper;
import domain.Session;
import domain.SessionAssembler;
import domain.SessionDTO;

public class SessionServiceBean {

	public SessionDTO getSession(int id) {
		Session session = new SessionMapper().findSessionById(id);
		SessionDTO sessionDTO = SessionAssembler.createSessionDTO(session);
		return sessionDTO;
	}
	
	public String getSessionJson(int id) {
		Session session = new SessionMapper().findSessionById(id);
		SessionDTO sessionDTO = SessionAssembler.createSessionDTO(session);
		return SessionDTO.serialize(sessionDTO);
	}
	
	public boolean updateSession(SessionDTO sessionDTO) {
		return SessionAssembler.updateSession(sessionDTO);
	}
	
	public boolean updateSessionJson(String json) {
		SessionDTO sessionDTO = SessionDTO.deserialize(json);
		return SessionAssembler.updateSession(sessionDTO);
	}
	
	public boolean addSession(SessionDTO sessionDTO) {
		return SessionAssembler.addSession(sessionDTO);
	}
	
	public boolean addSessionJson(String json) {
		SessionDTO sessionDTO = SessionDTO.deserialize(json);
		return SessionAssembler.addSession(sessionDTO);
	}
	
}
