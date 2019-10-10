package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.User;

public class ManagerHomeCommand extends FrontCommand{

	/**
	 * Back to the manager home page
	 * */
	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		}
		
	}

}
