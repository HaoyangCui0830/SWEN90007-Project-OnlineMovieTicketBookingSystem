package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CinemaMovie;
import domain.DomainObject;
import utils.DBConnection;
import utils.IdentityMap;

public class CinemaMovieMapper extends DataMapper{

	
	/**
	 * @param DomainObject
	 * insert new cinema-movie relationship into cinema_movie DB
	 * Used by MovieService when the manager wants to add one specific onto one cinema
	 * */
	@Override
	public boolean insert(DomainObject object) {
		CinemaMovie cinemaMovie = (CinemaMovie)object;
		String insertCinemaMovieString = "INSERT INTO Cinema_Movie (movieId, cinemaId) VALUES"
				+ "(?,?)";
		int result = 0;
		//Boolean result = false;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertCinemaMovieString);
			stmt.setInt(1, cinemaMovie.getMovieId());
			stmt.setInt(2, cinemaMovie.getCinemaId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			System.out.println(result);
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert cinema_movie Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * @param DomainObject
	 * delete cinema-movie relationship from cinema_movie DB
	 * used by MovieService when one specific won't on showing any more
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		CinemaMovie cinemaMovie = (CinemaMovie)object;
		String deleteMovieString = "DELETE FROM Cinema_Movie WHERE movieId = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteMovieString);
			stmt.setInt(1, cinemaMovie.getMovieId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete cinema_movie Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	// As there is no attribute in the association table, the update could be 
	// replaced by inserting and deleting
	public boolean update(DomainObject object) throws Exception {
		return false;
	}
	
	
	/**
	 * @param DomainObject
	 * find all cinemas which show one specific movie
	 * */
	public List<CinemaMovie> findCinemaMoviesByMovieId(int movieId){
		String findCinemaMoviesByMovieIdString = "SELECT * FROM Cinema_Movie WHERE movieId = ?";
		List<CinemaMovie> result = new ArrayList<CinemaMovie>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findCinemaMoviesByMovieIdString);
			stmt.setInt(1, movieId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CinemaMovie cinemaMovie = new CinemaMovie();
				cinemaMovie.setCinemaId(rs.getInt(2));
				cinemaMovie.setMovieId(rs.getInt(1));
				result.add(cinemaMovie);
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view cinemas_movie by movie id Problem");
		}
		return result;
	}
	
	
}
