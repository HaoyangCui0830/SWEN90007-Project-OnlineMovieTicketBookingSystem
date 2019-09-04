package domain;

import java.util.ArrayList;

public class Cinema extends DomainObject{
	private String name;
	private String address;
	private ArrayList<Movie> movies;
	
	
	/**
	 * @param name
	 * @param address
	 * @param movies
	 */
	public Cinema(String name, String address, ArrayList<Movie> movies) {
		super();
		this.name = name;
		this.address = address;
		this.movies = movies;
	}


	/**
	 * @param name
	 * @param address
	 */
	public Cinema(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}


	public String getName() {
		if(this.name == null) {
			load();
		}
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		if(this.address == null) {
			load();
		}
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public ArrayList<Movie> getMovies() {
		if(this.movies == null) {
			load();
		}
		return movies;
	}


	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}
	
	public void addMovie(Movie movie) {
		this.movies.add(movie);
	}


	@Override
	void load() {
		// TODO Auto-generated method stub
		super.load();
	}
	
	
	
}
