package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import domain.User;
import service.SessionService;

public class ManagerDeleteSessionCommand extends FrontCommand{

	/**
	 * Collect session id and delete all related data in the DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			Session Session = new Session();
			int SessionId = Integer.parseInt(request.getParameter("sessionId"));
			SessionService SessionService = new SessionService();
			Session = SessionService.getSessionBySessionId(SessionId);
			Boolean result = SessionService.deleteSession(Session,request.getSession().getId());
			if(result == true) {
				request.setAttribute("Session", Session);
				//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllSessions.jsp").forward(request, response);
				forward("/jsp/ManagerPages/ManagerHomePage.jsp");
			}
			else {
				forward("/jsp/errorPage.jsp");
			}
		}
		
		
		
		
	}
	
}
