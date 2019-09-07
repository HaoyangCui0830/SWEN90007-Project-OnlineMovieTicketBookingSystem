package domain;

import java.sql.Time;

public class TimeRange {

	private Time startTime;
	private Time endTime;
	
	/**
	 * @param startTime
	 * @param endTime
	 */
	public TimeRange(Time startTime, Time endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	

	/**
	 * 
	 */
	public TimeRange() {
		super();
	}


	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Time getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	
	
	
}
