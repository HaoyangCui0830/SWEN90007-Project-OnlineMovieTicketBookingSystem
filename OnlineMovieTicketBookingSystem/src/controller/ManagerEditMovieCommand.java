package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import domain.User;
import service.MovieService;

public class ManagerEditMovieCommand extends FrontCommand{

	/**
	 * Collect the movie id, return the movie object and jump into 
	 * the edit movie information page for manager to update new information
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			Movie movie = new Movie();
			int movieId = Integer.parseInt(request.getParameter("movieId"));
			MovieService movieService = new MovieService();
			movie = movieService.getMovieById(movieId);
			request.setAttribute("movie", movie);
			forward("/jsp/ManagerPages/ManagerEditMovie.jsp");
		}
		
		
	}

}
