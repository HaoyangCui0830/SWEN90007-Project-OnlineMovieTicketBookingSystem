package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import service.SessionService;

public class ManagerDeleteSessionCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Session Session = new Session();
		int SessionId = Integer.parseInt(request.getParameter("sessionId"));
		SessionService SessionService = new SessionService();
		Session = SessionService.getSessionBySessionId(SessionId);
		SessionService.deleteSession(Session);
		request.setAttribute("Session", Session);
		//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllSessions.jsp").forward(request, response);
		forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		
	}
	
}
