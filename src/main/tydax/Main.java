package main.tydax;

import java.util.ArrayList;
import java.util.Map;

import main.tydax.models.Result;
import main.tydax.models.Rider;
import main.tydax.models.Stage;
import main.tydax.models.TourDeFrance;

public class Main {

	public static void main(String[] args) {
		// Initialise randomly generated riders
		ArrayList<Rider> riders = new ArrayList<Rider>();
		for(int i = 0 ; i < 25 ; i++) {
			riders.add(Rider.createRider());
		}
		
		// Initialise randomly generated stages
		ArrayList<Stage> stages = new ArrayList<Stage>();
		for(int i = 0 ; i < 8 ; i++) {
			stages.add(Stage.createStage());
		}
		
		// Initialise Tour de France
		TourDeFrance muchTour = new TourDeFrance(stages, riders);
		muchTour.runAll();
		
		System.out.println("** Results: **");
		
		// Display results
		Map<Rider, Result> results = muchTour.getResults();
		for(Rider r : results.keySet()) {
			Result res = results.get(r);
			System.out.println(r.getName() + ": " +  res.getTime() + ""
					+ "\n\tGreenPts: " + res.getGreenPoints()
					+ " ClimbingPts: " + res.getClimbingPoints());
		}
		
		// Display withdrawals
		System.out.println("\n** Withdrawals **");
		for (Rider r : muchTour.getWithdrawals()) {
			System.out.println(r.getName());
		}
	}

}
