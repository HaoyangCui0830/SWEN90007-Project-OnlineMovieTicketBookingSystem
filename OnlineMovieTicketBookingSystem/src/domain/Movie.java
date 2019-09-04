package domain;

import java.sql.Time;

public class Movie extends DomainObject{
	
	private int id = -1;
	private String name;
	private Time length;
	private float price = -1;

	/**
	 * @param id
	 * @param name
	 * @param length
	 * @param price
	 */
	public Movie(int id, String name, Time length, float price) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.price = price;
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
	 * @return the name
	 */
	public String getName() {
		if(this.name == null) {
			load();
		}
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the length
	 */
	public Time getLength() {
		if(this.length == null) {
			load();
		}
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Time length) {
		this.length = length;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		if(this.price == -1) {
			load();
		}
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	void load() {
		// TODO Auto-generated method stub
		super.load();
	}
	
	
}
