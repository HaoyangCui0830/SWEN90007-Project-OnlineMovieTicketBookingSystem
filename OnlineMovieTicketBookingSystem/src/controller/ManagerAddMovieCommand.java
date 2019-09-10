package controller;

import java.io.IOException;

import javax.servlet.ServletException;

public class ManagerAddMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String movieId = request.getParameter("movieId");
//		System.out.println(movieId);
		forward("/jsp/ManagerPages/ManagerAddMovie.jsp");
	}

}
