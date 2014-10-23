package test.tydax.models;

import static org.junit.Assert.*;
import main.tydax.models.Result;
import main.tydax.models.MyTime;

import org.junit.Test;

public class ResultTest {

	@Test
	public void testAddingResults() {
		Result r1 = new Result(new MyTime(1, 20, 30), 3, 7);
		Result r2 = new Result(new MyTime(1, 57, 32), 2, 10);
		r1.add(r2);
		
		final MyTime time = new MyTime(3, 18, 2);
		assertEquals(time, r1.getTime());
		assertEquals(5, r1.getGreenPoints());
		assertEquals(17, r1.getClimbingPoints());
		
		assertEquals(new Result(time, 5, 17), r1);
	}
}
