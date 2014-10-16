package main.tydax.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
	
	public TourDeFrance(Collection<Stage> stages, Collection<Rider> riders) {
		mStages = new ArrayList<Stage>(stages);
		mResults = new HashMap<Rider, Result>();
		mRunningRiders = new LinkedList<Rider>(riders);
		mWithdrawnRiders = new ArrayList<Rider>();
	}
	
	public void runAll() {
		// TODO implement
	}
	
	public List<Rider> getWithdrawals() {
		// TODO implement
		return null;
	}
	
	public List<Rider> getRunningRiders() {
		// TODO implement
		return null;
	}
	
	public Map<Rider, Result> getResults() {
		// TODO implement
		return null;
	}
	
	public List<Stage> getStages() {
		// TODO implement
		return null;
	}
	
	private void runStage(Stage stage) {
		// TODO implement
	}
}
