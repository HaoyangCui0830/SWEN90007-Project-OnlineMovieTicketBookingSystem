package utils;

import java.sql.*;

public class DBConnection {

	private static String DB_CONNECTION = "jdbc:postgresql://localhost:5432/OnlineMovieTicketBookingSystem";
	private static String DB_USER = "postgres";
	private static String DB_PASSWORD = "123456";
//	private static String DB_CONNECTION = "jdbc:postgresql://ec2-174-129-194-188.compute-1.amazonaws.com:5432/dc8cqhi3rh4t73";
//	private static String DB_USER = "knmilpdisnntgf";
//	private static String DB_PASSWORD = "1496f26ae955e994c5a92f746d9970c56f68a71e702c013c979148efc4210c7d";
	
	
	
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
