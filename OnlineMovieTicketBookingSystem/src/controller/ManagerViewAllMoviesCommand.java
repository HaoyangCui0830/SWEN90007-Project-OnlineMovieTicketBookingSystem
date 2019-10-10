package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import domain.User;
import service.MovieService;

public class ManagerViewAllMoviesCommand extends FrontCommand{

	/**
	 * Return all movies' list 
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
			List<Movie> movies = new ArrayList<Movie>();
			MovieService movieService = new MovieService();
			movies = movieService.getAllMovies();
			request.setAttribute("movies", movies);
			forward("/jsp/ManagerPages/ManagerViewAllMovies.jsp");
		}
		
		
	}

}
