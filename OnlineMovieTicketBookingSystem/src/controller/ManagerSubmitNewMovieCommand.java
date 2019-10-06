package controller;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;

import domain.Movie;
import service.MovieService;

public class ManagerSubmitNewMovieCommand extends FrontCommand{

	/**
	 * Submit new created movie object to DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		String movieName = request.getParameter("movieName");
		String movieLength = request.getParameter("movieLength");
		String moviePrice = request.getParameter("moviePrice");
		
		Movie movie = new Movie();
		movie.setName(movieName);
		movie.setLength(Time.valueOf(movieLength));
		movie.setPrice(Float.parseFloat(moviePrice));
		
		MovieService movieService = new MovieService();
		Boolean result = movieService.insertMovie(movie,request.getSession().getId());
		if(result == true) {
			forward("/jsp/ManagerPages/ManagerHomePage.jsp");
		}
		else {
			forward("/jsp/errorPage.jsp");
		}
	}

}
