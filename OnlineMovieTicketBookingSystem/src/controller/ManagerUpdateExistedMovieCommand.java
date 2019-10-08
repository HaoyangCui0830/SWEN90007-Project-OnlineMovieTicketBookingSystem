package controller;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import dataMapper.CinemaMovieMapper;
import domain.Cinema;
import domain.CinemaMovie;
import domain.Movie;
import domain.ThreeDMovie;
import domain.User;
import service.CinemaService;
import service.MovieService;
import service.ThreeDMovieService;

public class ManagerUpdateExistedMovieCommand extends FrontCommand{

	/**
	 * Collect all relevant information of one specific movie and 
	 * submit all onto all related DB
	 * */
	@Override
	public void process() throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user==null || user.getRole().equals("manager")==false) {
			response.getWriter().write("please login to check your tickets");
			forward("/jsp/errorPage.jsp");
		}
		// TODO Auto-generated method stub
		else {
			String movieId = request.getParameter("movieId");
			String movieName = request.getParameter("movieName");
			String movieLength = request.getParameter("movieLength");
			String moviePrice = request.getParameter("moviePrice");
			String isThreeD = request.getParameter("isThreeD");
			String withFreeGlasse = request.getParameter("withFreeGlasses");
			String showInMelbourne = request.getParameter("showInMelbourne");
			String showInSydney = request.getParameter("showInSydney");
			
			Movie movie = new Movie();
			movie.setMovieId(Integer.parseInt(movieId));
			movie.setName(movieName);
			movie.setLength(Time.valueOf(movieLength));
			movie.setPrice(Float.parseFloat(moviePrice));
			
			MovieService movieService = new MovieService();
			Boolean result = movieService.updateMovie(movie,request.getSession().getId());
			
			ThreeDMovie threeDMovie = new ThreeDMovie();
			ThreeDMovieService threeDMovieService = new ThreeDMovieService();
			threeDMovie.setHasFreeGlasses(Boolean.parseBoolean(withFreeGlasse));
			threeDMovie.setMovieId(Integer.parseInt(movieId));
			//System.out.println("3D"+isThreeD);
			if(Boolean.parseBoolean(isThreeD)) {
				threeDMovieService.insertThreeDMovie(threeDMovie,request.getSession().getId());
			}
			
			CinemaMovie cinemaMovie = new CinemaMovie();
			cinemaMovie.setMovieId(Integer.parseInt(movieId));
			CinemaMovieMapper cinemaMovieMapper = new CinemaMovieMapper();
//			List<CinemaMovie> cinemaMovies = new ArrayList<CinemaMovie>();
//			cinemaMovies = cinemaMovieMapper.findCinemaMoviesByMovieId(Integer.parseInt(movieId));
			if(Boolean.parseBoolean(showInMelbourne)) {
//				Boolean existed = false;
//				for(CinemaMovie cm: cinemaMovies) {
//					if (cm.getCinemaId() == 1) {
//						existed = true;
//						try {
//							cinemaMovieMapper.update(cm);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
				cinemaMovie.setCinemaId(1);
				cinemaMovieMapper.insert(cinemaMovie);
			}
			if(Boolean.parseBoolean(showInSydney)) {
				cinemaMovie.setCinemaId(2);
				
				cinemaMovieMapper.insert(cinemaMovie);
			}
			
			
			if(result == true) {
				forward("/jsp/ManagerPages/ManagerHomePage.jsp");
			}
			else {
				forward("/jsp/errorPage.jsp");
			}
		}
		
		
	}
	
}
