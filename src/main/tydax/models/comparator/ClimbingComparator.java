package main.tydax.models.comparator;

import main.tydax.models.Result;

public class ClimbingComparator extends ResultComparator<Integer> {

	public ClimbingComparator() {
		super();
	}
	
	@Override
	protected Integer criterion(Result r) {
		return r.getClimbingPoints();
	}

}
