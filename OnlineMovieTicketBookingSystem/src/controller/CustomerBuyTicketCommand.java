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
		if(user == null) {
			request.setAttribute("BuyTicketMsg","please login first");
			forward("/jsp/Common/Login.jsp");
		}
		Session session = new Session();
		int sessionId = Integer.parseInt(request.getParameter("sessionId"));
		SessionService SessionService = new SessionService();
		session = SessionService.getSessionBySessionId(sessionId);
		request.setAttribute("sessioninfo", session);
		forward("/jsp/CustomerPages/CustomerBuyTicket.jsp");
	}
}
