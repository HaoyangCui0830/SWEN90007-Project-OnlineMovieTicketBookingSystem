package domain;

public class Session extends DomainObject{
	
	private int id = -1;
	private int theaterId = -1;
	private int movieId = -1;
	private int seats = -1;
	
	
	/**
	 * @param id
	 * @param theaterId
	 * @param movieId
	 * @param seats
	 */
	public Session(int id, int theaterId, int movieId, int seats) {
		super();
		this.id = id;
		this.theaterId = theaterId;
		this.movieId = movieId;
		this.seats = seats;
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
	 * @return the theaterId
	 */
	public int getTheaterId() {
		if(this.theaterId == -1) {
			load();
		}
		return theaterId;
	}


	/**
	 * @param theaterId the theaterId to set
	 */
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}


	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		if(this.movieId == -1) {
			load();
		}
		return movieId;
	}


	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	/**
	 * @return the seats
	 */
	public int getSeats() {
		if(this.seats == -1) {
			load();
		}
		return seats;
	}


	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}


	@Override
	void load() {
		// TODO Auto-generated method stub
		super.load();
	}
	
	
	
}
