package domain;

import java.sql.Time;

public class Movie extends DomainObject{
	
	private int id;
	private String name;
	private Time length;
	private float price;
	
	public Movie(int id, String name, Time length, float price) {
		this.id = id;
		this.price = price;
		this.name = name;
		this.length = length;
	}
	
	public int getId() {return id;}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {return name;}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {return price;}
	public void setPrice(float price) {
		this.price = price;
	}
	public Time getLength() {return length;}
	public void setLength(Time length) {
		this.length = length;
	}
	
}
