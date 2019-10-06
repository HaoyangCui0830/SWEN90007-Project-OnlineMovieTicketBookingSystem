package utils;

public abstract class LockManager {

	/**
	 * Acquire the lock for concurrency control, based on the object's type and id
	 * @param objectType - the name of the object acquiring for lock
	 * @param objectId - the main id of the object
	 * @param owner - the owner of the lock
	 * */
	public abstract boolean acquireLock(String objectType, String objectId, String owner) throws Exception;
	
	/**
	 * Release the lock for concurrency control, based on the object's type and id
	 * @param objectType - the name of the object acquiring for lock
	 * @param objectId - the main id of the object
	 * @param owner - the owner of the lock
	 * */
	public abstract boolean releaseLock(String objectType, String objectId, String owner) throws Exception;
	
	
	
}
