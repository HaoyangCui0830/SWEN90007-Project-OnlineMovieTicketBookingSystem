package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerEditMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Movie movie = new Movie();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieId);
		request.setAttribute("movie", movie);
		forward("/jsp/ManagerPages/ManagerEditMovie.jsp");
	}

}
