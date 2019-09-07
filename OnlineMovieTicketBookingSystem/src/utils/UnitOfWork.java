package utils;
import java.util.ArrayList;
import java.util.List;

import dataMapper.DataMapper;
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
	
	public void commit() {
		for(DomainObject domainObject : newObjects) {
			try {
				DataMapper.getDataMapper(domainObject).insert(domainObject);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		for(DomainObject domainObject : dirtyObjects) {
			try {
				DataMapper.getDataMapper(domainObject).update(domainObject);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		for(DomainObject domainObject : deletedObjects) {
			try {
				DataMapper.getDataMapper(domainObject).delete(domainObject);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}
