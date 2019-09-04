package domain;

public class Session extends DomainObject{
	
	private int id;
	private int theaterId;
	private int movieId;
	private int seats;
	
	public Session(int id, int theaterId, int movieId, int seats) {
		this.id = id;
		this.movieId = movieId;
		this.seats = seats;
		this.theaterId = theaterId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public int getTheaterId() {
		return theaterId;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getSeats() {
		return seats;
	}
	
}
