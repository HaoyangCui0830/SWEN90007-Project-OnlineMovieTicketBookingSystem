package dataMapper;

import domain.DomainObject;
import utils.ExclusiveWriteManager;
import utils.LockManager;

public class ImplicitMapper extends DataMapper{

	private DataMapper impl;
	private LockManager lm;
	private String sessionId;
	private String objectType;
	
	/**
	 * @param impl
	 * @param sessionId
	 * @param objectType
	 */
	public ImplicitMapper(DataMapper impl, String objectType, String sessionId) {
		super();
		this.impl = impl;
		this.lm = ExclusiveWriteManager.getInstance();
		this.sessionId = sessionId;
		this.objectType = objectType;
	}

	
	/**
	 * For insert, we don't really need concurrency control
	 * */
	@Override
	public boolean insert(DomainObject object) {
		return impl.insert(object);
	}

	
	/**
	 * acquire for lock before delete
	 * @param object - the domain object to be deleted
	 * */
	@Override
	public boolean delete(DomainObject object) throws Exception {
		try {
			if(lm.acquireLock(objectType, Integer.toString(object.getId()), sessionId) == true) {
				boolean result = impl.delete(object);
				System.out.println("delete");
				System.out.println(objectType);
				System.out.println(Integer.toString(object.getId()));
				System.out.println(sessionId);
				lm.releaseLock(objectType, Integer.toString(object.getId()), sessionId);
				return result;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * acquire for lock before update information
	 * @param object - the domain object to be updated
	 * */
	@Override
	public boolean update(DomainObject object) throws Exception {
		try {
			if(lm.acquireLock(objectType, Integer.toString(object.getId()), sessionId) == true) {
				boolean result = impl.update(object);
				System.out.println("update");
				System.out.println(objectType);
				System.out.println(Integer.toString(object.getId()));
				System.out.println(sessionId);
				lm.releaseLock(objectType, Integer.toString(object.getId()), sessionId);
				return result;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
