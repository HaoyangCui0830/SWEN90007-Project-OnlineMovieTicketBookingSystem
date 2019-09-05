package domain;

import java.sql.Time;

public class Session extends DomainObject{
	
	private int sessionId = -1;
	private TimeRange timeRange;
	private int movieId = -1;
	private int seats = -1;
	private int availableSeats = -1;
	
	

	/**
	 * @param sessionId
	 * @param timeRange
	 * @param movieId
	 * @param seats
	 * @param availableSeats
	 */
	public Session(int sessionId, TimeRange timeRange, int movieId, int seats, int availableSeats) {
		super();
		this.sessionId = sessionId;
		this.timeRange = timeRange;
		this.movieId = movieId;
		this.seats = seats;
		this.availableSeats = availableSeats;
	}


	/**
	 * @return the sessionId
	 */
	public int getSessionId() {
		if(this.sessionId == -1) {
			load();
		}
		return sessionId;
	}




	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	

	/**
	 * @return the timeRange
	 */
	public TimeRange getTimeRange() {
		if(this.timeRange == null) {
			load();
		}
		return timeRange;
	}


	/**
	 * @param timeRange the timeRange to set
	 */
	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}


	/**
	 * @return the availableSeats
	 */
	public int getAvailableSeats() {
		if(this.availableSeats == -1) {
			load();
		}
		return availableSeats;
	}




	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
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