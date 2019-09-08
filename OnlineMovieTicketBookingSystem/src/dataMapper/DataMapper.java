package dataMapper;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;

import domain.DomainObject;

public abstract class DataMapper {
	public abstract boolean insert(DomainObject object);
	public abstract boolean delete(DomainObject object) throws Exception;
	public abstract boolean update(DomainObject object) throws Exception;
	public static DataMapper getDataMapper(DomainObject domainObject) 
			throws Exception {
		System.out.println(domainObject.getClass().getSimpleName());
		DataMapper dataMapper = (DataMapper) Class.forName("dataMapper." + domainObject.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
		return dataMapper;
	}
}
