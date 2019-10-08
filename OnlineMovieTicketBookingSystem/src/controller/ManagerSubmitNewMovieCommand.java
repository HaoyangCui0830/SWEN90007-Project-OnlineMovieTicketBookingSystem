package controller;

import java.io.IOException;
import java.sql.Time;

import javax.servlet.ServletException;

import domain.Movie;
import domain.User;
import service.MovieService;

public class ManagerSubmitNewMovieCommand extends FrontCommand{

	/**
	 * Submit new created movie object to DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		else {
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

}
