package main.tydax;

import java.util.Map;

import main.tydax.models.Result;
import main.tydax.models.Rider;
import main.tydax.models.TourDeFrance;

public class Main {

	public static void main(String[] args) {
		// Initialise Tour de France
		TourDeFrance muchTour = TourDeFrance.createRandomTour(8, 25);
		muchTour.runAll();
		
		System.out.println("** Results: **");
		
		// Display results
		Map<Rider, Result> results = muchTour.getResults();
		for(Rider r : results.keySet()) {
			Result res = results.get(r);
			System.out.println(r + ": " +  res.getTime() + ""
					+ "\n\tGreenPts: " + res.getGreenPoints()
					+ " ClimbingPts: " + res.getClimbingPoints());
		}
		
		// Display withdrawals
		System.out.println("\n** Withdrawals **");
		for (Rider r : muchTour.getWithdrawals()) {
			System.out.println(r);
		}
		
		// Display jersey owners
		System.out.println("\n** Jersey owners **");
		System.out.println("Yellow jersey: " + muchTour.yellowJersey());
		System.out.println("Green jersey: " + muchTour.greenJersey());
		System.out.println("Polka dot jersey: " + muchTour.polkaDotJersey());
		System.out.println("Best young rider: " + muchTour.youngRider());
	}

}
