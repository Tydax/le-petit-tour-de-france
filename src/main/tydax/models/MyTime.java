package main.tydax.models;

import java.security.InvalidParameterException;

/**
 * This class models the Time of a Rider.
 * @author Armand BOUR
 *
 */
public class MyTime implements Comparable<MyTime> {

	/** The number of seconds. Always positive. Cannot exceed 59. */
	private int mSeconds;
	
	/** The number of minutes. Always positive. Cannot exceed 59. */
	private int mMinutes;

	/** The number of hours. */
	private int mHours;
	
	/** Default constructor initialising a Time with 0 in each field. */
	public MyTime() { 
		this(0,0,0);
	}
	
	/** 
	 * Constructor with three parameters.
	 * @param hours The number of hours. Must be positive.
	 * @param min The number of minutes. Can exceed 59, in which case this will be converted to hours.
	 * @param sec The number of seconds. Can exceed 59, in which case this will be converted to minutes.
	 */
	public MyTime(int hours, int min, int sec) {
		if(hours < 0 || min < 0 || sec < 0) {
			throw new InvalidParameterException("Cannot specify a negative Time");
		}
		
		mHours = hours + min / 60;
		mMinutes = min % 60 + sec / 60;
		mSeconds = sec % 60;
	}

	/**
	 * Adds the specified Time to this Time.
	 * @param t The Time to add.
	 */
	
	public void addTime(MyTime t) {
		// Summing
		mSeconds += t.mSeconds;
		mMinutes += t.mMinutes;
		mHours += t.mHours;
		
		// Normalising
		mHours += mMinutes / 60;
		mMinutes = mMinutes % 60 + mSeconds / 60;
		mSeconds = mSeconds % 60;
	}
	
	public int getHours() {
		return mHours;
	}
	
	public int getMinutes() {
		return mMinutes;
	}
	
	public int getSeconds() {
		return mSeconds;
	}
	
	@Override
	public int compareTo(MyTime t) {
		// If hours are different, compare them and return the result
		if(mHours != t.mHours) {
			return mHours < t.mHours
				 ? 1
				 : -1;
		}
		else { // if hours are equals, compare minutes
			if(mMinutes != t.mMinutes) {
				return mMinutes < t.mMinutes
					 ? 1
					 : -1;
			}
			else { // if minutes are not comparable, compare seconds
				if(mSeconds != t.mSeconds) {
					return mSeconds < t.mSeconds
						 ? 1
						 : -1;
				}
				else {
					// If all the values are equals, the times are both equals.
					return 0;
				}
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MyTime))
			return false;
		MyTime other = (MyTime) obj;
		if (mHours != other.mHours)
			return false;
		if (mMinutes != other.mMinutes)
			return false;
		if (mSeconds != other.mSeconds)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(mHours) + "h" +
			   String.valueOf(mMinutes) + "m" +
			   String.valueOf(mSeconds) + "s";
	}
}
