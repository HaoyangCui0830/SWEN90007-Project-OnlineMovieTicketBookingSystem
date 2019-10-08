package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import domain.User;
import service.SessionService;

public class ManagerEditSessionCommand extends FrontCommand{
	
	/**
	 * Collect session id and get the object in DB, jump to the edit session
	 * page for manager to update new session information
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			Session session = new Session();
			int sessionId = Integer.parseInt(request.getParameter("sessionId"));
			SessionService SessionService = new SessionService();
			session = SessionService.getSessionBySessionId(sessionId);
			System.out.println("session test"+session.getTimeRange().getStartTime());
			request.setAttribute("sessioninfo", session);
			forward("/jsp/ManagerPages/ManagerEditSession.jsp");
		}
		
	}
}
