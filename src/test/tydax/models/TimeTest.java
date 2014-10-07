package test.tydax.models;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import main.tydax.models.Time;

import org.junit.Test;

/**
 * This class tests the {@link Time} class.
 * @author Armand BOUR
 *
 */

public class TimeTest {

	/** Tests if a {@link InvalidParameterException} if trying to initialise a negative Time.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testWithNegativeTime() {
		Time time = new Time(-10, 2, 4);
	}
	
	/** Tests the constructor when initialising with values over 60. */
	@Test
	public void testUsingValuesOverMaximum() throws Exception {
		Time t1 = new Time(0, 61, 0);
		Time t2 = new Time(0, 65, 74);
		
		assertEquals(new Time(1, 1, 0), t1);
		assertEquals(new Time(1, 6, 14), t2);
	}
	
	/** Tests the {@link Time#addTime(Time)} method. */
	@Test
	public void testAddingTime() throws Exception {
		Time t1 = new Time(1, 34, 49);
		Time t2 = new Time(0, 27, 21);
		Time t3 = new Time();
		
		t1.addTime(t2);
		assertEquals(new Time(2, 2, 10), t1);
		
		t1.addTime(t3);
		assertEquals(new Time(2, 2, 10), t1);
	}
	
	@Test
	public void testCompareToTime() throws Exception {
		Time t0 = new Time();
		Time t1 = new Time(1, 20, 30);
		Time t2 = new Time(1, 0, 0);
		Time t3 = new Time(1, 20, 0);
		
		assertEquals(1, t1.compareTo(t0));
		assertEquals(-1, t0.compareTo(t1));
		
		assertEquals(1, t1.compareTo(t2));
		assertEquals(-1, t2.compareTo(t1));
		
		assertEquals(1, t1.compareTo(t3));
		assertEquals(-1, t3.compareTo(t1));

		assertEquals(0, t1.compareTo(t1));
	}
}
