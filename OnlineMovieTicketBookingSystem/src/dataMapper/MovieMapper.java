package dataMapper;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.Cinema;
import domain.DomainObject;
import domain.Movie;
import utils.DBConnection;
import utils.IdentityMap;

public class MovieMapper extends DataMapper{

	
	/**
	 * @param DomainObject
	 * Insert new Movie into Movie DB
	 * */
	@Override
	public boolean insert(DomainObject object) {
		Movie movie = (Movie)object;
		String insertMovieString = "INSERT INTO Movies (name, length, price) VALUES"
				+ "(?,?,?)";
		int result = 0;
		//Boolean result = false;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertMovieString);
			stmt.setString(1, movie.getName());
			stmt.setTime(2, movie.getLength());
			stmt.setFloat(3, movie.getPrice());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			System.out.println(result);
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert movie Problem");
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
	 * Delete new Movie from Movie DB
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		Movie movie = (Movie)object;
		String deleteMovieString = "DELETE FROM Movies WHERE movie_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteMovieString);
			stmt.setInt(1, movie.getMovieId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete movie Problem");
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
	 * Update new Movie into Movie DB
	 * */
	@Override
	public boolean update(DomainObject object) throws Exception {
		Movie movie = (Movie)object;
		String updateMovieString = "UPDATE Movies SET name = ?,"
				+ "length = ?, price = ? WHERE movie_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateMovieString);
			stmt.setString(1, movie.getName());
			stmt.setTime(2, movie.getLength());
			stmt.setFloat(3, movie.getPrice());
			stmt.setInt(4, movie.getMovieId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update movie Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Find all Movie info from Movie DB
	 * */
	public List<Movie> findAllMovies(){
		String findAllMovieString = "SELECT * FROM Movies";
		List<Movie> result = new ArrayList<Movie>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllMovieString);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				IdentityMap<Movie> identityMap = IdentityMap.getInstance(movie);
				movie.setMovieId(rs.getInt(1));
				movie.setName(rs.getString(2));
				movie.setLength(rs.getTime(3));
				movie.setPrice(rs.getFloat(4));
				identityMap.put(movie.getMovieId(), movie);
				result.add(movie);
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view movie Problem");
		}
		
		return result;
	}
	
	
	/**
	 * @param MovieId
	 * find one specific Movie from Movie DB using movieId
	 * */
	public Movie findMovieById(int movieId) {
		String findMovieByIdString = "SELECT * FROM Movies WHERE movie_id = ?";
		Movie result = new Movie();
		try {
			PreparedStatement stmt = DBConnection.prepare(findMovieByIdString);
			stmt.setInt(1, movieId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie();
				IdentityMap<Movie> identityMap = IdentityMap.getInstance(movie);
				movie.setMovieId(rs.getInt(1));
				movie.setName(rs.getString(2));
				movie.setLength(rs.getTime(3));
				movie.setPrice(rs.getFloat(4));
				identityMap.put(movie.getMovieId(), movie);
				result = movie;
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by movie id Problem");
		}
		return result;
	}
	
	
	/**
	 * @param MovieId
	 * find all onshowing cinema of one specific movie based on movieId
	 * */
	public List<Cinema> findCinemaByMovieId(int movieId) {
		String findCinemaByMovieIdString = "SELECT cinema_id, name, ADDRESS FROM Cinema INNER JOIN Cinema_Movie ON "
				+ "Cinema.cinema_id = Cinema_Movie.cinemaID WHERE movieId = ?";
		List<Cinema> result = new ArrayList<Cinema>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findCinemaByMovieIdString);
			stmt.setInt(1, movieId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cinema cinema = new Cinema();
				IdentityMap<Cinema> identityMap = IdentityMap.getInstance(cinema);
				cinema.setCinemaId(rs.getInt(1));
				cinema.setName(rs.getString(2));
				cinema.setAddress(rs.getString(3));
				identityMap.put(cinema.getCinemaId(), cinema);
				result.add(cinema);
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view cinemas by movie id Problem");
		}
		return result;
	}
	
}
