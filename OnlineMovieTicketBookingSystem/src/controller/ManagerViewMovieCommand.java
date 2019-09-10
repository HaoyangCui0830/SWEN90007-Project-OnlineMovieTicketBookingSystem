package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerViewMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Movie movie = new Movie();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieId);
		request.setAttribute("movie", movie);
		//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllMovies.jsp").forward(request, response);
		forward("/jsp/ManagerPages/ManagerViewMovie.jsp");
		
	}
}
