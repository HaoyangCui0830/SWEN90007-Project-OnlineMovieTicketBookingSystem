package service;

import java.util.List;

import dataMapper.SessionMapper;
import dataMapper.ThreeDMovieMapper;
import domain.Movie;
import domain.Session;
import domain.ThreeDMovie;
import utils.IdentityMap;
import utils.UnitOfWork;

public class ThreeDMovieService {

	ThreeDMovieMapper threeDMovieMapper;
	
	public ThreeDMovieService() {
		this.threeDMovieMapper = new ThreeDMovieMapper();
	}
	
	
	/**
	 * Find ThreeDMovie Info based on movieid
	 * This function will search for identity map firstly
	 * */
	public ThreeDMovie getThreeDMovieById(int threeDMovieId) {
		ThreeDMovie threeDMovie = new ThreeDMovie();
		threeDMovie.setMovieId(threeDMovieId);
		IdentityMap<ThreeDMovie> identityMap = IdentityMap.getInstance(threeDMovie);
		ThreeDMovie threeDMovieIdentityMap = identityMap.get(threeDMovie.getMovieId());
		if(threeDMovieIdentityMap != null) {
			ThreeDMovie result = threeDMovieIdentityMap;
			return result;
		}
		else {
			return threeDMovieMapper.findThreeDMovieById(threeDMovieId);
		}
	}
	
	/**
	 * Insert ThreeDMovie object info into DB
	 * */
	public boolean insertThreeDMovie(ThreeDMovie threeDmovie,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(threeDmovie);
		Boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	/**
	 * delete ThreeDMovie info from DB
	 * */
	public boolean deleteThreeDMovie(ThreeDMovie threeDmovie,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(threeDmovie);
		Boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	/**
	 * Update ThreeDMovie object info into DB
	 * */
	public boolean updateThreeDMovie(ThreeDMovie threeDmovie,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(threeDmovie);
		Boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
}
