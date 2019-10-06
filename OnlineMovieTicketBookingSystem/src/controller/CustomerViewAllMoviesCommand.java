package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class CustomerViewAllMoviesCommand extends FrontCommand{

	
	/**
	 * Return all movie list to the customer
	 * */
	@Override
	public void process() throws ServletException, IOException {
		List<Movie> movies = new ArrayList<Movie>();
		MovieService movieService = new MovieService();
		movies = movieService.getAllMovies();
		request.setAttribute("movies", movies);
		//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllMovies.jsp").forward(request, response);
		forward("/jsp/CustomerPages/CustomerViewAllMoviesPage.jsp");
		
	}

}
