package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerViewAllMoviesCommand extends FrontCommand{

	/**
	 * Return all movies' list 
	 * */
	@Override
	public void process() throws ServletException, IOException {
		List<Movie> movies = new ArrayList<Movie>();
		MovieService movieService = new MovieService();
		movies = movieService.getAllMovies();
		request.setAttribute("movies", movies);
		forward("/jsp/ManagerPages/ManagerViewAllMovies.jsp");
		
	}

}
