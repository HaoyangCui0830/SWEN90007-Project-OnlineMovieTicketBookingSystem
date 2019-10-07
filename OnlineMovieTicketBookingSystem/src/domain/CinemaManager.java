package domain;

import dataMapper.CinemaManagerMapper;

public class CinemaManager extends DomainObject{

	private int cinemaManagerId = -1;
	private String firstNameString;
	private String lastNameString;
	private String username;
	private String password;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
	/**
	 * Lazy load (Ghost)
	 * */
	void load() {
		// TODO Auto-generated method stub
		super.load();
		CinemaManager cinemaManager = new CinemaManagerMapper().findcinemaManagerById(this.cinemaManagerId);
		if(this.firstNameString == null) {
			this.firstNameString = cinemaManager.firstNameString;
		}
		if(this.lastNameString == null ) {
			this.lastNameString = cinemaManager.lastNameString;
		}
	}

	@Override
	public int getId() {
		return this.cinemaManagerId;
	}
	
	
	
}
