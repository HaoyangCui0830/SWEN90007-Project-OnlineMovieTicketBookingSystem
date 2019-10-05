package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Exclusive Write Lock Manager Class
 * */
public class ExclusiveWriteManager extends LockManager{

	private static ExclusiveWriteManager lm;
	
	// result flag for an unavailable lock 
	private final int unavailableLock = -1;
	
	// result flag for a currently holding lock
	private final int holdingLock = 1;
	
	// result flag for an available lock
	private final int availableLock = 0;
	
	/**
	 * Get the singleton instance of exclusive write lock manager
	 * */
	public static ExclusiveWriteManager getInstance() {
		if(lm == null) {
			lm = new ExclusiveWriteManager();
		}
		return lm;
	}
	
	
	/**
	 * Query the lock DB, check one object's lockability status
	 * @param objectType - the name of the object acquiring for lock
	 * @param objectId - the main id of the object
	 * @param owner - the owner of the lock
	 * */
	private int hasLock(String objectType, String objectId, String owner) {
		String lockCheckingSQLString = "SELECT owner FROM Lock WHERE tableName = ? AND id = ?";
		int lockResult = availableLock;
		try {
			PreparedStatement stmt = DBConnection.prepare(lockCheckingSQLString);
			stmt.setString(1, objectType);
			stmt.setString(2, objectId);
			ResultSet rs = stmt.executeQuery();
			
			// If the lock record already in lock DB, then it's either unavailable or currently holding
			while(rs.next()) {
				String currentOwner = rs.getString(3);
				if(currentOwner.equals(owner)) {
					lockResult = holdingLock;
				}
				else {
					lockResult = unavailableLock;
				}
			}
			stmt.close();
			DBConnection.closeConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lockResult;
	}
	
	
	
	/**
	 * Acquire the Lock by insert values into the Lock DB, return True if acquire the lock 
	 * successfully, on the other hand, return False;
	 * @param objectType - the name of the object acquiring for lock
	 * @param objectId - the main id of the object
	 * @param owner - the owner of the lock
	 * */
	@Override
	public boolean acquireLock(String objectType, String objectId, String owner) throws Exception {
		boolean result = false;
		int resultFlag = hasLock(objectType, objectId, owner);
		
		if(resultFlag == availableLock) {
			try {
				String acquireLockString = "INSERT INTO Lock (tableName, id, owner) VALUES (?,?,?)";
				PreparedStatement stmt = DBConnection.prepare(acquireLockString);
				stmt.setString(1, objectType);
				stmt.setString(2, objectId);
				stmt.setString(3, owner);
				int insertResult = stmt.executeUpdate();
				stmt.close();
				DBConnection.closeConnection();
				if(insertResult == 1) {
					result = true;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else if(resultFlag == holdingLock) {
			result = true;
		}
		
		return result;
	}

	
	/**
	 * Delete the Lock by delete values from Lock DB, return True if operate successfully, else, return False
	 * @param objectType - the name of the object acquiring for lock
	 * @param objectId - the main id of the object
	 * @param owner - the owner of the lock
	 * */
	@Override
	public boolean releaseLock(String objectType, String objectId, String owner) throws Exception {
		try {
			String releaseLockString = "DELETE FROM Lock WHERE tableName = ? AND id = ? AND owner = ?";
			PreparedStatement stmt = DBConnection.prepare(releaseLockString);
			stmt.setString(1, objectType);
			stmt.setString(2, objectId);
			stmt.setString(3, owner);
			int deleteResult = stmt.executeUpdate();
			if (deleteResult == 0) {
				return false;
			}
			else {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
