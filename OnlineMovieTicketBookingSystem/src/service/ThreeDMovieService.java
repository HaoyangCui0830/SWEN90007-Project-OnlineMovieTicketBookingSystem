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
	
	public void insertThreeDMovie(ThreeDMovie threeDmovie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(threeDmovie);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteThreeDMovie(ThreeDMovie threeDmovie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(threeDmovie);
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateThreeDMovie(ThreeDMovie threeDmovie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(threeDmovie);
		UnitOfWork.getCurrent().commit();
	}
	
}
