package main.tydax.models;

/**
 * This class represents a result for a rider.
 * @author Armand BOUR
 *
 */

public class Result {

	/** The time registered. */
	private Time mTime;
	
	/** The number of green points that the rider scored during the race. */
	private int mGreenPts;
	
	/** The number of climbing points that the rider scored during the race. */
	private int mClimbingPts;
	
	/**
	 * Default constructor. Initialise a Result with a Time using default constructor {@link Time#Time()}
	 * and 0 to both scores.
	 */
	public Result() {
		this(new Time(), 0, 0);
	}
	
	/**
	 * Constructor with three parameters.
	 * @param time The time registered.
	 * @param greenPoints The number of green points the rider scored during the race.
	 * @param climbingPoints The number of climbing points the rider scored during the race.
	 */
	public Result(Time time, int greenPoints, int climbingPoints) {
		mTime = time;
		mGreenPts = greenPoints;
		mClimbingPts = climbingPoints;
	}
	
	/**
	 * Gets the registered time.
	 * @return The time registered.
	 */
	
	public Time getTime() {
		return mTime;
	}

	/**
	 * Gets the number of green points scored.
	 * @return The number of green points registered.
	 */
	
	public int getGreenPoints() {
		return mGreenPts;
	}

	/**
	 * Gets the number of climbing points scored.
	 * @return The number of climbing points registered.
	 */
	
	public int getClimbingPoints() {
		return mClimbingPts;
	}
	
	/**
	 * Adds the specified Result to the current Result.
	 * @param res The Result to add.
	 */
	
	public void add(Result res) {
		mTime.addTime(res.mTime);
		mGreenPts += res.mGreenPts;
		mClimbingPts += res.mClimbingPts;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Result))
			return false;
		Result other = (Result) obj;
		if (mClimbingPts != other.mClimbingPts)
			return false;
		if (mGreenPts != other.mGreenPts)
			return false;
		if (mTime == null) {
			if (other.mTime != null)
				return false;
		} else if (!mTime.equals(other.mTime))
			return false;
		return true;
	}
}
