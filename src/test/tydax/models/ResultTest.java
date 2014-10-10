package test.tydax.models;

import static org.junit.Assert.*;
import main.tydax.models.Result;
import main.tydax.models.Time;

import org.junit.Test;

public class ResultTest {

	@Test
	public void testAddingResults() {
		Result r1 = new Result(new Time(1, 20, 30), 3, 7);
		Result r2 = new Result(new Time(1, 57, 32), 2, 10);
		r1.add(r2);
		
		final Time time = new Time(3, 18, 2);
		assertEquals(time, r1.getTime());
		assertEquals(5, r1.getGreenPoints());
		assertEquals(17, r1.getClimbingPoints());
		
		assertEquals(new Result(time, 5, 17), r1);
	}
}
