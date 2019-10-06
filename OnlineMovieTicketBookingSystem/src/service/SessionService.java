package service;

import java.util.List;

import dataMapper.SessionMapper;
import domain.Session;
import utils.IdentityMap;
import utils.UnitOfWork;

public class SessionService {
	SessionMapper sessionMapper;
	
	public SessionService() {
		sessionMapper = new SessionMapper();
	}
	
	/**
	 * Will collect all sessions of one movie
	 * @param movieId
	 * */
	public List<Session> getAllSessionsByMovieId(int movieId){
		List<Session> sessions = sessionMapper.findAllSessionsByMovieId(movieId);
		return sessions;
	}
	
	/**
	 * find one session based on sessionId
	 * @param sessionId
	 * */
	public Session getSessionBySessionId(int sessionId) {
		Session session = new Session();
		session.setSessionId(sessionId);
		IdentityMap<Session> identityMap = IdentityMap.getInstance(session);
		Session sessionIdentityMap = identityMap.get(session.getSessionId());
		if(sessionIdentityMap!=null) {
			Session result = sessionIdentityMap;
			return result;
		}
		else {
			return sessionMapper.findSessionById(sessionId);
		}
	}
	
	/**
	 * insert session info into DB
	 * @param session
	 * */
	public boolean insertSession(Session session,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(session);
		Boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	
	/*
	 * delete one session from DB
	 * @param session
	 * **/
	public boolean deleteSession(Session session,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(session);
		Boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	/**
	 * update session info into DB
	 * @param session
	 * */
	public boolean updateSession(Session session,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(session);
		Boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
}
