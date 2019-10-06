package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CinemaManager;
import domain.DomainObject;
import utils.DBConnection;
import utils.IdentityMap;

public class CinemaManagerMapper extends DataMapper{

	
	
	/**
	 * @param DomainObject
	 * Insert new cinema manager into cinema manager DB
	 * */
	@Override
	public boolean insert(DomainObject object) {
		CinemaManager cinemaManager = (CinemaManager)object;
		String insertCinemaManagerString = "INSERT INTO Cinema_Manager (firstname, lastname) VALUES"
				+ "(?,?)";
		int result = 0;
		//Boolean result = false;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertCinemaManagerString);
			stmt.setString(1, cinemaManager.getFirstNameString());
			stmt.setString(2, cinemaManager.getLastNameString());
			result = stmt.executeUpdate();
			stmt.close();
			stmt.close();
			DBConnection.closeConnection();
			//System.out.println(result);
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert cinemaManager Problem");
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
	 * Delete new cinema manager from cinema manager DB
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		CinemaManager cinemaManager = (CinemaManager)object;
		String deletecinemaManagerString = "DELETE FROM Cinema_Manager WHERE cinema_manager_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deletecinemaManagerString);
			stmt.setInt(1, cinemaManager.getCinemaManagerId());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete cinemaManager Problem");
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
	 * Update new cinema manager onto cinema manager DB
	 * */
	@Override
	public boolean update(DomainObject object) throws Exception {
		CinemaManager cinemaManager = (CinemaManager)object;
		String updatecinemaManagerString = "UPDATE Cinema_Manager SET firstname = ?,"
				+ "lastname = ? WHERE cinema_manager_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updatecinemaManagerString);
			stmt.setString(1, cinemaManager.getFirstNameString());
			stmt.setString(2, cinemaManager.getLastNameString());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update cinemaManager Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	/**
	 * Find all cinema manager info from cinema manager DB
	 * */
	public List<CinemaManager> findAllcinemaManagers(){
		String findAllcinemaManagerString = "SELECT * FROM Cinema_Manager";
		List<CinemaManager> result = new ArrayList<CinemaManager>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllcinemaManagerString);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CinemaManager cinemaManager = new CinemaManager();
				IdentityMap<CinemaManager> identityMap = IdentityMap.getInstance(cinemaManager);
				cinemaManager.setCinemaManagerId(rs.getInt(1));
				cinemaManager.setFirstNameString(rs.getString(2));
				cinemaManager.setLastNameString(rs.getString(3));
				identityMap.put(cinemaManager.getCinemaManagerId(), cinemaManager);
				result.add(cinemaManager);
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view cinemaManager Problem");
		}
		return result;
	}
	
	
	/**
	 * @param cinema managerId
	 * find one specific cinema manager from cinema manager DB
	 * */
	public CinemaManager findcinemaManagerById(int cinemaManagerId) {
		String findcinemaManagerByIdString = "SELECT * FROM cinemaManager WHERE cinemaManager_id = ?";
		CinemaManager result = new CinemaManager();
		try {
			PreparedStatement stmt = DBConnection.prepare(findcinemaManagerByIdString);
			stmt.setInt(1, cinemaManagerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				CinemaManager cinemaManager = new CinemaManager();
				IdentityMap<CinemaManager> identityMap = IdentityMap.getInstance(cinemaManager);
				cinemaManager.setCinemaManagerId(rs.getInt(1));
				cinemaManager.setFirstNameString(rs.getString(2));
				cinemaManager.setLastNameString(rs.getString(3));
				identityMap.put(cinemaManager.getCinemaManagerId(), cinemaManager);
				result = cinemaManager;
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by cinemaManager id Problem");
		}
		return result;
	}
	

}
