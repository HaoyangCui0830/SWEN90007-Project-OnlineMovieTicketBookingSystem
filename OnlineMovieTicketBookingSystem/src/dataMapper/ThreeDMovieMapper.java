package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domain.DomainObject;
import domain.ThreeDMovie;
import utils.DBConnection;
import utils.IdentityMap;

public class ThreeDMovieMapper extends DataMapper{

	
	/**
	 * @param DomainObject
	 * Insert new ThreeDMovie into ThreeDMovie DB
	 * */
	  @Override
	public boolean insert(DomainObject object) {
		ThreeDMovie threeDmovie = (ThreeDMovie)object;
		String insertthreeDMovieString = "INSERT INTO ThreeDMovies (ThreeDMovie_id, has_free_glasses) VALUES"
				+ "(?,?)";
		int result = 0;
		//Boolean result = false;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertthreeDMovieString);
			stmt.setInt(1, threeDmovie.getMovieId());
			stmt.setBoolean(2, threeDmovie.getHasFreeGlasses());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			System.out.println(result);
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert 3D movie Problem");
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
	 * Delete new ThreeDMovie from ThreeDMovie DB
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		ThreeDMovie threeDmovie = (ThreeDMovie)object;
		String deleteThreeDMovieString = "DELETE FROM ThreeDMovies WHERE ThreeDMovie_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteThreeDMovieString);
			stmt.setInt(1, threeDmovie.getMovieId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete 3D movie Problem");
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
	 * Update new ThreeDMovie into ThreeDMovie DB
	 * */
	@Override
	public boolean update(DomainObject object) throws Exception {
		ThreeDMovie threeDmovie = (ThreeDMovie)object;
		String updateMovieString = "UPDATE ThreeDMovies SET has_free_glasses = ? "
				+ "WHERE ThreeDMovie_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateMovieString);
			stmt.setBoolean(1, threeDmovie.getHasFreeGlasses());
			stmt.setInt(2, threeDmovie.getMovieId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update 3D movie Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * @param movieId
	 * find one specific ThreeDMovie from ThreeDMovie DB
	 * */
	public ThreeDMovie findThreeDMovieById(int movieId) {
		String findThreeDMovieByIdString = "SELECT * FROM ThreeDMovies WHERE ThreeDMovie_id = ?";
		ThreeDMovie result = new ThreeDMovie();
		try {
			PreparedStatement stmt = DBConnection.prepare(findThreeDMovieByIdString);
			stmt.setInt(1, movieId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ThreeDMovie threeDmovie = new ThreeDMovie();
				IdentityMap<ThreeDMovie> identityMap = IdentityMap.getInstance(threeDmovie);
				threeDmovie.setMovieId(rs.getInt(1));
				threeDmovie.setHasFreeGlasses(rs.getBoolean(2));
				identityMap.put(threeDmovie.getMovieId(), threeDmovie);
				result = threeDmovie;
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by 3D movie id Problem");
		}
		System.out.println(result.getHasFreeGlasses());
		return result;
	}

}
