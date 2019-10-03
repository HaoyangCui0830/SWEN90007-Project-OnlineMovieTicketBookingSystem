package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Session;
import service.SessionService;

public class CustomerBuyTicketCommand extends FrontCommand{
	@Override
	public void process() throws ServletException, IOException {
		Session session = new Session();
		int sessionId = Integer.parseInt(request.getParameter("sessionId"));
		SessionService SessionService = new SessionService();
		session = SessionService.getSessionBySessionId(sessionId);
		request.setAttribute("sessioninfo", session);
		forward("/jsp/CustomerPages/CustomerBuyTicket.jsp");
	}
}
