package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerDeleteMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Movie movie = new Movie();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieId);
		movieService.deleteMovie(movie);
		request.setAttribute("movie", movie);
		//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllMovies.jsp").forward(request, response);
		forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		
	}

}