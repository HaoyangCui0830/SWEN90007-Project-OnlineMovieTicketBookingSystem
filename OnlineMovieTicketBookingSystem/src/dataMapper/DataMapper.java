package dataMapper;
import domain.DomainObject;

public abstract class DataMapper {
	public abstract boolean insert(DomainObject object);
	public abstract boolean delete(DomainObject object) throws Exception;
	public abstract boolean update(DomainObject object) throws Exception;
}
