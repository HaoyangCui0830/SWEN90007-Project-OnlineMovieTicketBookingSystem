package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import service.SessionService;

public class ManagerEditSessionCommand extends FrontCommand{
	@Override
	public void process() throws ServletException, IOException {
		Session session = new Session();
		int sessionId = Integer.parseInt(request.getParameter("sessionId"));
		SessionService SessionService = new SessionService();
		session = SessionService.getSessionBySessionId(sessionId);
		System.out.println("session test"+session.getTimeRange().getStartTime());
		request.setAttribute("session", session);
		forward("/jsp/ManagerPages/ManagerEditSession.jsp");
	}
}
