package models;

public class Time implements Comparable<Time> {

	private int mSeconds = 0;
	private int mMinutes = 0;
	private int mHours = 0;
	
	public Time() { }
	
	public Time(int hours, int min, int sec) {
		mHours = hours + min / 60;
		mMinutes = min % 60 + sec / 60;
		mSeconds = sec % 60;
	}

	public void addTime(Time t) {
		// Summing
		mSeconds += t.mSeconds;
		mMinutes += t.mMinutes;
		mHours += t.mHours;
		
		// Normalising
		mHours += mMinutes / 60;
		mMinutes = mMinutes % 60 + mSeconds / 60;
		mSeconds = mSeconds % 60;
	}
	
	@Override
	public String toString() {
		return "(" + mHours + ", " + mMinutes + ", " + mSeconds +")";
	}
	
	@Override
	public int compareTo(Time t) {
		// If hours are different, compare them and return the result
		if(mHours != t.mHours) {
			return mHours > t.mHours
				 ? 1
				 : -1;
		}
		else { // if hours are equals, compare minutes
			if(mMinutes != t.mMinutes) {
				return mMinutes > t.mMinutes
					 ? 1
					 : -1;
			}
			else { // if minutes are not comparable, compare seconds
				if(mSeconds != t.mSeconds) {
					return mSeconds > t.mSeconds
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

}
