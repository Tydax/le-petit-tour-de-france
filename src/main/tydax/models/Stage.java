package main.tydax.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import main.tydax.models.exceptions.StageNotYetRunException;

/**
 * Stage describes a stage from the race which can be run only once by a certain number of runners.
 * @author Armand BOUR
 *
 */
public class Stage {

	/** Integer used to give a unique ID to all Stage. */
	private static int sId = 0;
	/** Random object used to generate random number (you don't say). */
	private static Random sRandom = new Random();
	
	/** Integer identifying the Stage. */
	private final int mId;
	/** Boolean representing if the Stage has been run yet or not. */
	private boolean mRun;
	/** Theorical time needed to run the Stage. Used to compute a random Time. */
	private MyTime mTheoricalTime;
	/** Map containing the results associated with the riders. */
	private Map<Rider, Result> mResults;
	/** Collection of withdrawn riders. */
	private Collection<Rider> mWithdrawnRiders;
	
	/**
	 * Default constructor. Creates a Stage with a unique id, a randomly generated time, and empty
	 * collections for the results and the withdrawn riders.
	 */
	public Stage(int id, MyTime theoricalTime) {
		mId = id;
		mRun = false;
		mTheoricalTime = theoricalTime;
		mResults = new HashMap<Rider, Result>();
		mWithdrawnRiders = new LinkedList<Rider>();
	}
	
	/**
	 * Creates a Stage with a unique id, a randomly generated time, and empty
	 * collections for the results and the withdrawn riders.
	 * @return a new random Stage.
	 */
	public static Stage createRandomStage() {
		sId++;
		return new Stage(sId, new MyTime(sRandom.nextInt(10), sRandom.nextInt(60), sRandom.nextInt(60)));
	}
	
	/**
	 * Simulates the stage with the riders from {@link #mRiders}.
	 * When this method returns, this stage is considered run.
	 * @param riders The collection of riders starting this stage.
	 */
	public void run(Rider ... riders) {
		for(Rider r : riders) {
			// Generate a random boolean to withdraw or not the rider
			if(sRandom.nextInt(30) != 0) {
				mResults.put(r, new Result(new MyTime(sRandom.nextInt(2) + mTheoricalTime.getHours(),
										 			sRandom.nextInt(60) + mTheoricalTime.getMinutes(),
										 			sRandom.nextInt(60) + mTheoricalTime.getSeconds()),
										 sRandom.nextInt(20),
										 sRandom.nextInt(20)));				
			}
			else {
				mResults.put(r, new Result());
				mWithdrawnRiders.add(r);
			}
		}
		mRun = true;
	}
	
	/**
	 * Returns the results after this stage has been run.
	 * @return A map associating each rider finishing this stage to its result for this stage.
	 * @throws StageNotYetRunException when this stage has not been run yet.
	 */
	public Map<Rider, Result> results() throws StageNotYetRunException {
		if(!mRun) {
			throw new StageNotYetRunException();
		}
		
		return mResults;
	}
	
	/**
	 * Returns the riders who have abandoned this stage.
	 * @return A collection of riders who abandoned during this stage.
	 * @throws StageNotYetRunException when this stage has not been run yet.
	 */
	public Collection<Rider> withdrawals() throws StageNotYetRunException {
		if(!mRun) {
			throw new StageNotYetRunException();
		}
		
		return mWithdrawnRiders;
	}
	
	/**
	 * Gets the id of the Stage in the TourDeFrance.
	 * @return The id of the Stage.
	 */
	public int getId() {
		return mId;
	}
}
