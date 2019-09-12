package domain;

public class CinemaManager extends DomainObject{

	private int cinemaManagerId = -1;
	private String firstNameString;
	private String lastNameString;
	
	

	/**
	 * @param cinemaManagerId
	 */
	public CinemaManager(int cinemaManagerId) {
		super();
		this.cinemaManagerId = cinemaManagerId;
	}

	/**
	 * @param cinemaManagerId
	 * @param firstNameString
	 * @param lastNameString
	 */
	public CinemaManager(int cinemaManagerId, String firstNameString, String lastNameString) {
		super();
		this.cinemaManagerId = cinemaManagerId;
		this.firstNameString = firstNameString;
		this.lastNameString = lastNameString;
	}
	
	

	/**
	 * 
	 */
	public CinemaManager() {
		super();
	}

	/**
	 * @return the cinemaManagerId
	 */
	public int getCinemaManagerId() {
		if(this.cinemaManagerId == -1) {
			load();
		}
		return cinemaManagerId;
	}

	/**
	 * @param cinemaManagerId the cinemaManagerId to set
	 */
	public void setCinemaManagerId(int cinemaManagerId) {
		this.cinemaManagerId = cinemaManagerId;
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
