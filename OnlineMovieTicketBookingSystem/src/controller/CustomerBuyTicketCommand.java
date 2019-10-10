package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import domain.User;
import service.SessionService;

public class CustomerBuyTicketCommand extends FrontCommand{
	@Override
	public void process() throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user == null || user.getRole().equals("customer")==false) {
			request.setAttribute("BuyTicketMsg","please login first");
			forward("/jsp/Common/Login.jsp");
		}
		else {
			Session session = new Session();
			String sessionIdString= request.getParameter("sessionId");
			int sessionId = Integer.parseInt(sessionIdString);
			SessionService SessionService = new SessionService();
			session = SessionService.getSessionBySessionId(sessionId);
			request.setAttribute("sessioninfo", session);
			forward("/jsp/CustomerPages/CustomerBuyTicket.jsp");
		}
		
	}
}
