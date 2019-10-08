package utils;
import java.util.ArrayList;
import java.util.List;

import dataMapper.DataMapper;
import dataMapper.ImplicitMapper;
import domain.DomainObject;

public class UnitOfWork {

	private static ThreadLocal current = new ThreadLocal();
	
	private List<DomainObject> newObjects = new ArrayList<DomainObject>();
	private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
	private List<DomainObject> deletedObjects = new ArrayList<DomainObject>();
	
	public static void newCurrent() {
		setCurrent(new UnitOfWork());
	}
	
	public static void setCurrent(UnitOfWork uow) {
		current.set(uow);
	}
	
	public static UnitOfWork getCurrent() {
		return (UnitOfWork) current.get();
	}
	
	public void registerNew(DomainObject domainObject) {
		newObjects.add(domainObject);
	}
	
	public void registerDirty(DomainObject domainObject) {
		if(!dirtyObjects.contains(domainObject) && !newObjects.contains(domainObject)) {
			dirtyObjects.add(domainObject);
		}
	}
	
	public void registerDeleted(DomainObject domainObject) {
		if(newObjects.contains(domainObject)) return;
		dirtyObjects.remove(domainObject);
		if(!dirtyObjects.contains(domainObject)) {
			deletedObjects.add(domainObject);
		}
	}
	
	public boolean commit(String owner) {
		boolean insertResult = true;
		boolean updateResult = true;
		boolean deleteResult = true;
		for(DomainObject domainObject : newObjects) {
			try {
				insertResult = DataMapper.getDataMapper(domainObject).insert(domainObject);
				if(insertResult == false) {
					return insertResult;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		for(DomainObject domainObject : dirtyObjects) {
			try {
				DataMapper dataMapper = DataMapper.getDataMapper(domainObject);
				ImplicitMapper implicitMapper = new ImplicitMapper(dataMapper, domainObject.getClass().getSimpleName(), owner);
				updateResult = implicitMapper.update(domainObject);
				if(updateResult == false) {
					return false;
				}
				//System.out.print("commit outcome" + updateResult);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		for(DomainObject domainObject : deletedObjects) {
			try {
				DataMapper dataMapper = DataMapper.getDataMapper(domainObject);
				ImplicitMapper implicitMapper = new ImplicitMapper(dataMapper, domainObject.getClass().getSimpleName(), owner);
				deleteResult = implicitMapper.delete(domainObject);
				if(deleteResult == false) {
					return false;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return insertResult && updateResult && deleteResult;
		
	}
}
