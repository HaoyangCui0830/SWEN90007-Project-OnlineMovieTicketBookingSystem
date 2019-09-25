package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Cinema;
import domain.DomainObject;
import domain.Movie;
import utils.DBConnection;
import utils.IdentityMap;

public class CinemaMapper extends DataMapper{

	
	/**
	 * @param DomainObject
	 * Insert new cinema into cinema DB
	 * Currently not used as we don't manager to add new CINEMA onto system
	 * */
	@Override
	public boolean insert(DomainObject object) {
		Cinema cinema = (Cinema)object;
		String insertCinemaString = "INSERT INTO Cinema (name, ADDRESS) "
				+ "VALUES "
				+ "(?,?)";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertCinemaString);
			stmt.setString(1, cinema.getName());
			stmt.setString(2, cinema.getAddress());
			result = stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert cinema Problem");
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
	 * delete cinema from cinema DB
	 * Currently not used as we don't manager to delete new CINEMA from system
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		Cinema cinema = (Cinema)object;
		String deleteCinemaString = "DELETE FROM Cinema WHERE cinema_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteCinemaString);
			stmt.setInt(1, cinema.getCinemaId());
			result = stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete cinema Problem");
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
	 * Update cinema info onto cinema DB
	 * Currently not used as we don't manager to edit CINEMA basic info onto system
	 * */
	@Override
	public boolean update(DomainObject object) throws Exception {
		Cinema cinema = (Cinema)object;
		String updateCinemaString = "UPDATE Cinema SET name = ?,"
				+ "ADDRESS = ? WHERE cinema_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateCinemaString);
			stmt.setString(1, cinema.getName());
			stmt.setString(2, cinema.getAddress());
			stmt.setInt(3, cinema.getCinemaId());
			result = stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update cinema Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Find all cinema info from cinema DB
	 * */
	public List<Cinema> findAllCinemas(){
		String findAllCinemaString = "SELECT * FROM Cinema";
		List<Cinema> result = new ArrayList<Cinema>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllCinemaString);
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
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view cinema Problem");
		}
		return result;
	}

	public Cinema findCinemaById(int cinemaId) {
		String findCinemaById = "SELECT * FROM Cinema WHERE cinema_id = ?";
		Cinema result = new Cinema();
		try {
			PreparedStatement stmt = DBConnection.prepare(findCinemaById);
			stmt.setInt(1, cinemaId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Cinema cinema = new Cinema();
				IdentityMap<Cinema> identityMap = IdentityMap.getInstance(cinema);
				cinema.setCinemaId(rs.getInt(1));
				cinema.setName(rs.getString(2));
				cinema.setAddress(rs.getString(3));
//				movie.setMovieId(rs.getInt(1));
//				movie.setName(rs.getString(2));
//				movie.setLength(rs.getTime(3));
//				movie.setPrice(rs.getFloat(4));
				identityMap.put(cinema.getCinemaId(), cinema);
				result = cinema;
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by cinema id Problem");
		}
		return result;
	}

	
	
	
	
	
	
	
	
}
