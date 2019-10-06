package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerDeleteMovieCommand extends FrontCommand{

	/**
	 * Collect movie id from presentation layer, and delete all information
	 * related in the DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		Movie movie = new Movie();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieId);
		Boolean result = movieService.deleteMovie(movie,request.getSession().getId());
		if(result == true) {
			request.setAttribute("movie", movie);
			forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		}
		else {
			forward("/jsp/errorPage.jsp");
		}
		
		
	}

}
