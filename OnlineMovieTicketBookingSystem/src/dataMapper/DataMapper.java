package dataMapper;
import domain.DomainObject;

public abstract class DataMapper {
	
	/**
	 * @param DomainObject
	 * abstract method, mapper insert data into DB
	 * */
	public abstract boolean insert(DomainObject object);
	
	/**
	 * @param DomainObject
	 * abstract method, mapper delete data from DB
	 * */
	public abstract boolean delete(DomainObject object) throws Exception;
	
	/**
	 * @param DomainObject
	 * abstract method, mapper update data into DB
	 * */
	public abstract boolean update(DomainObject object) throws Exception;
	
	
	/**
	 * @param DomainObject
	 * static method, used by unit of work, convert DomainObject class name into 
	 * relevant DataMapper class name
	 * */
	public static DataMapper getDataMapper(DomainObject domainObject) 
			throws Exception {
		System.out.println(domainObject.getClass().getSimpleName());
		DataMapper dataMapper = (DataMapper) Class.forName("dataMapper." + domainObject.getClass().getSimpleName()+"Mapper").getDeclaredConstructor().newInstance();
		return dataMapper;
	}
}
