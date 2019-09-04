package domain;

public class Customer extends DomainObject{

	private int id = -1;
	private String firstNameString;
	private String lastNameString;
	
	/**
	 * @param id
	 */
	public Customer(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * @param id
	 * @param firstNameString
	 * @param lastNameString
	 */
	public Customer(int id, String firstNameString, String lastNameString) {
		super();
		this.id = id;
		this.firstNameString = firstNameString;
		this.lastNameString = lastNameString;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		if(this.id == -1) {
			load();
		}
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstNameString
	 */
	public String getFirstNameString() {
		if(this.firstNameString == null) {
			load();
		}
		return firstNameString;
	}

	/**
	 * @param firstNameString the firstNameString to set
	 */
	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}

	/**
	 * @return the lastNameString
	 */
	public String getLastNameString() {
		if(this.lastNameString == null) {
			load();
		}
		return lastNameString;
	}

	/**
	 * @param lastNameString the lastNameString to set
	 */
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

	@Override
	void load() {
		// TODO Auto-generated method stub
		super.load();
	}
	
	
}
