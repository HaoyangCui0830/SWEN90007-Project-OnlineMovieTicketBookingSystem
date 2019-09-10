package controller;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class CustomerViewMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
		Movie movie = new Movie();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieId);
		request.setAttribute("movie", movie);
		//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllMovies.jsp").forward(request, response);
		forward("/jsp/CustomerPages/CustomerViewMovie.jsp");
	}

}
