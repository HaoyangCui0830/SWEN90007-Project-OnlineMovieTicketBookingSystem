package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.User;

public class ManagerAddMovieCommand extends FrontCommand{

	/**
	 * Jump to add new Movie Page for manager to create new movie
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			forward("/jsp/ManagerPages/ManagerAddMovie.jsp");
		}
		
	}

}
