package main.tydax.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import main.tydax.models.exceptions.StageNotYetRunException;

/**
 * TourDeFrance modelises a tour de France!!!
 * @author Armand BOUR
 *
 */
public class TourDeFrance {

	/** The list of stages. */
	private final ArrayList<Stage> mStages;
	
	/** The results of the Tour de France. */
	private final Map<Rider, Result> mResults;
	
	/** The riders who are still on the race. */
	private final List<Rider> mRunningRiders;
	
	/** The withdrawn riders. */
	private final List<Rider> mWithdrawnRiders;
	
	/**
	 * Constructor with two parameters. Initialise a TourDeFrance with the specified stages and riders.
	 * @param stages The stages included in the Tour.
	 * @param riders The riders running the Tour.
	 */
	public TourDeFrance(Collection<Stage> stages, Collection<Rider> riders) {
		mStages = new ArrayList<Stage>(stages);
		mResults = new HashMap<Rider, Result>();
		mRunningRiders = new LinkedList<Rider>(riders);
		mWithdrawnRiders = new ArrayList<Rider>();
		
		// Add riders to the result
		for(Rider r : mRunningRiders) {
			mResults.put(r, new Result());
		}
	}
	
	/**
	 * Run the specified stage.
	 * @param stage The stage to run.
	 */
	private void runStage(Stage stage) {
		// Run the stage
		Rider[] riders = new Rider[mRunningRiders.size()];
		for (int i = 0; i < riders.length; i++) {
			riders[i] = mRunningRiders.get(i);
		}
		stage.run(riders);
		
		try {
			// Add the results from the stage to the whole Tour de France
			for(Rider r : mRunningRiders) {
				Result result = mResults.get(r);
				result.add(stage.results().get(r));
			}
			
			// Remove the withdrawn riders and add them to the withdrawal list
			mRunningRiders.remove(stage.withdrawals());
			mWithdrawnRiders.addAll(stage.withdrawals());
		}
		catch(StageNotYetRunException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * Run all stages.
	 */
	public void runAll() {
		for(Stage s : mStages) {
			runStage(s);
		}
	}

	/**
	 * Gets the withdrawn riders.
	 * @return A list of the withdrawn riders.
	 */
	public List<Rider> getWithdrawals() {
		return mWithdrawnRiders;
	}
	
	/**
	 * Gets the riders who are still running, and thus not withdrawn.
	 * @return A list of the running riders.
	 */
	public List<Rider> getRunningRiders() {
		return mRunningRiders;
	}
	
	/**
	 * Gets a map associating a Rider with its Result.
	 * @return A map containing all the Riders and their Result.
	 */
	public Map<Rider, Result> getResults() {
		return mResults;
	}
	
	/**
	 * Gets the stages in the TourDeFrance.
	 * @return A list containing all the stages.
	 */
	public List<Stage> getStages() {
		return mStages;
	}
}
