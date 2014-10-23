package main.tydax.models.comparator;

import java.util.Comparator;

import main.tydax.models.Result;

/**
 * Abstract superclass to define a Comparator using a specific criterion which is defined
 * in subclasses.
 * @author Armand BOUR
 *
 */
public abstract class ResultComparator<T extends Comparable<? super T>> implements Comparator<Result> {

	@Override
	public int compare(Result r1, Result r2) {
		return criterion(r1).compareTo(criterion(r2));
	}
	
	/**
	 * Template method to use the criterion we want from the Result class in subclasses of
	 * the Comparator.
	 * @param r The result to get the criterion from
	 * @return The criterion to use to compare from the parameter r.
	 */
	protected abstract T criterion(Result r);
}
