package controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class LogoutCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("logout");
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}

}
