package main.tydax.models.comparator;

import main.tydax.models.MyTime;
import main.tydax.models.Result;

public class TimeComparator extends ResultComparator<MyTime> {

	@Override
	protected MyTime criterion(Result r) {
		return r.getTime();
	}

}
