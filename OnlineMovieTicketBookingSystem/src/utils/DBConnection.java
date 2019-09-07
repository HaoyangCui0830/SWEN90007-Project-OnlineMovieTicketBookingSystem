package utils;

import java.sql.*;

public class DBConnection {

	private static String DB_CONNECTION = "jdbc:postgresql://localhost:5432/OnlineMovieTicketBookingSystem";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "1q2w3e4r";
	
	
	
	static Connection dbConnection = null;
	
	public static PreparedStatement prepare(String stm) throws SQLException{
		PreparedStatement preparedStatement = null;
		
		try {
			Connection dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(stm);
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return preparedStatement;
	}
	
	
	private static Connection getDBConnection() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			//dbConnection.setAutoCommit(false);
			return dbConnection;
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Connection Problem");
		return null;
	}
	
	public static void closeConnection() throws SQLException{
		dbConnection.close();
	}
	
	
}
