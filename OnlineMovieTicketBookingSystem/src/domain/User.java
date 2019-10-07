package domain;

public class User extends DomainObject{

	private int userId;
	private String firstNameString;
	private String lastNameString;
	private String username;
	private String password;
	private String role;
	
	public User() {
		
	}
	
	public User(String username, String password, String role, String firstNameString, String lastNameString) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstNameString = firstNameString;
		this.lastNameString = lastNameString;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstNameString() {
		return firstNameString;
	}

	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}

	public String getLastNameString() {
		return lastNameString;
	}

	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

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

	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	@Override
	public String toString() {
		return "User [firstNameString=" + firstNameString + ", lastNameString=" + lastNameString + ", username="
				+ username + ", password=" + password + ", role=" + role + "]";
	}

	@Override
	public int getId() {
		return this.userId;
	}

	
	
	
//	@Override
//	/**
//	 * Lazy load (Ghost)
//	 * */
//	void load() {
//		// TODO Auto-generated method stub
//		super.load();
//		User user = new CinemaManagerMapper().findcinemaManagerById(this.userId);
//		if(this.firstNameString == null) {
//			this.firstNameString = cinemaManager.firstNameString;
//		}
//		if(this.lastNameString == null ) {
//			this.lastNameString = cinemaManager.lastNameString;
//		}
//	}
//	
	
	
}