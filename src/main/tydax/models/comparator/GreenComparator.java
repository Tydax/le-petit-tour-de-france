package main.tydax.models.comparator;

import main.tydax.models.Result;

public class GreenComparator extends ResultComparator<Integer> {

	public GreenComparator() {
		super();
	}
	
	@Override
	protected Integer criterion(Result r) {
		return r.getGreenPoints();
	}

}
