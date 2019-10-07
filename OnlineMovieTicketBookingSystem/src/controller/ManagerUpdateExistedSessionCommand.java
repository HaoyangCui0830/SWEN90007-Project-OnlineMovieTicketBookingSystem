package controller;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;

import domain.Session;
import service.SessionService;

public class ManagerUpdateExistedSessionCommand extends FrontCommand{
	
	/**
	 * Collect all relevant information of one specific session and submit all
	 * onto the Session DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		String MovieId = request.getParameter("movieId");
		String sessionId = request.getParameter("sessionId");
		String SessionStartTime = request.getParameter("sessionStartTime");
		String SessionEndTime = request.getParameter("sessionEndTime");
		String SessionTotalSeats = request.getParameter("sessionTotalSeats");
		String SessionAvailableSeats = request.getParameter("sessionAvailableSeats");
		
		Session Session = new Session();
		Session.setMovieId(Integer.valueOf(MovieId));
		Session.setSessionId(Integer.valueOf(sessionId));
		Session.setStartTime(Time.valueOf(SessionStartTime));
		Session.setEndTime(Time.valueOf(SessionEndTime));
		Session.setSeats(Integer.valueOf(SessionTotalSeats));
		Session.setAvailableSeats(Integer.valueOf(SessionAvailableSeats));
		
		SessionService sessionService = new SessionService();
		System.out.println(Session.getTimeRange().getEndTime());
		Boolean result = sessionService.updateSession(Session, request.getSession().getId());
		if(result == true) {
			forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		}
		else {
			forward("/jsp/errorPage.jsp");
		}
		
	}
}
