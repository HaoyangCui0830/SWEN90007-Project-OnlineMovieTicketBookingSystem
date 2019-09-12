package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import dataMapper.CinemaMapper;
import domain.Cinema;
import domain.Movie;
import domain.Session;
import domain.ThreeDMovie;
import service.CinemaService;
import service.MovieService;
import service.SessionService;
import service.ThreeDMovieService;

public class ManagerViewMovieCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		Movie movie = new Movie();
		int movieId = Integer.parseInt(request.getParameter("movieId"));
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieId);
		request.setAttribute("movie", movie);
		
		List<Session> sessions = new ArrayList<Session>();
		SessionService sessionService = new SessionService();
		sessions = sessionService.getAllSessionsByMovieId(movieId);
		request.setAttribute("session", sessions);
		
		ThreeDMovie threeDMovie = new ThreeDMovie();
		ThreeDMovieService threeDMovieService = new ThreeDMovieService();
		threeDMovie = threeDMovieService.getThreeDMovieById(movieId);
		
		request.setAttribute("threeDMovie", threeDMovie);
		
		List<Cinema> cinemas = new ArrayList<Cinema>();
		CinemaService cinemaService = new CinemaService();
		cinemas = cinemaService.getCinemasByMovieId(movieId);
		request.setAttribute("cinema", cinemas);
		
		//request.getRequestDispatcher("/jsp/ManagerPages/ManagerViewAllMovies.jsp").forward(request, response);
		forward("/jsp/ManagerPages/ManagerViewMovie.jsp");
		
	}
}
