package controller;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerSubmitNewMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String movieId = request.getParameter("movieId");
		String movieName = request.getParameter("movieName");
		String movieLength = request.getParameter("movieLength");
		String moviePrice = request.getParameter("moviePrice");
		
		Movie movie = new Movie();
//		movie.setMovieId(Integer.parseInt(movieId));
		movie.setName(movieName);
		movie.setLength(Time.valueOf(movieLength));
		movie.setPrice(Float.parseFloat(moviePrice));
		
		MovieService movieService = new MovieService();
		movieService.insertMovie(movie);
		forward("/jsp/ManagerPages/ManagerHomePage.jsp");
	}

}
