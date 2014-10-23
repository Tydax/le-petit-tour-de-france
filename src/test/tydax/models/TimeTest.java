package test.tydax.models;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import main.tydax.models.MyTime;

import org.junit.Test;

/**
 * This class tests the {@link MyTime} class.
 * @author Armand BOUR
 *
 */

public class TimeTest {

	/** Tests if a {@link InvalidParameterException} if trying to initialise a negative Time.
	 */
	@Test(expected=InvalidParameterException.class)
	public void testWithNegativeTime() {
		MyTime time = new MyTime(-10, 2, 4);
		time.compareTo(time);
	}
	
	/** Tests the constructor when initialising with values over 60. */
	@Test
	public void testUsingValuesOverMaximum() throws Exception {
		MyTime t1 = new MyTime(0, 61, 0);
		MyTime t2 = new MyTime(0, 65, 74);
		
		assertEquals(new MyTime(1, 1, 0), t1);
		assertEquals(new MyTime(1, 6, 14), t2);
	}
	
	/** Tests the {@link MyTime#addTime(MyTime)} method. */
	@Test
	public void testAddingTime() throws Exception {
		MyTime t1 = new MyTime(1, 34, 49);
		MyTime t2 = new MyTime(0, 27, 21);
		MyTime t3 = new MyTime();
		
		t1.addTime(t2);
		assertEquals(new MyTime(2, 2, 10), t1);
		
		t1.addTime(t3);
		assertEquals(new MyTime(2, 2, 10), t1);
	}
	
	@Test
	public void testCompareToTime() throws Exception {
		MyTime t0 = new MyTime();
		MyTime t1 = new MyTime(1, 20, 30);
		MyTime t2 = new MyTime(1, 0, 0);
		MyTime t3 = new MyTime(1, 20, 0);
		
		assertEquals(1, t1.compareTo(t0));
		assertEquals(-1, t0.compareTo(t1));
		
		assertEquals(1, t1.compareTo(t2));
		assertEquals(-1, t2.compareTo(t1));
		
		assertEquals(1, t1.compareTo(t3));
		assertEquals(-1, t3.compareTo(t1));

		assertEquals(0, t1.compareTo(t1));
	}
}
