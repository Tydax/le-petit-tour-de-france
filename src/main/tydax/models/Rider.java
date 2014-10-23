package main.tydax.models;

import java.util.Random;

import grumpy.cub.tydax.toolbox.tools.StringGenerator;
import grumpy.cub.tydax.toolbox.tools.enums.Language;

/**
 * This class models a rider in the Tour de France (with his bike and stuff).
 * @author Armand BOUR
 *
 */

public class Rider {

	/** The rider's name. */
	private final String mName;
	/** The rider's age. */
	private final int mAge;
	/** The rider's number of license. */
	private final String mLicense;
	
	private static int sLicense = 0;
	
	private static final Random RAND = new Random();
	
	/**
	 * Constructor with three parameters.
	 * @param name The rider's name.
	 * @param age The rider's age.
	 * @param license The rider's number of license. Considered unique.
	 */
	public Rider(String name, int age, String license) {
		mName = name;
		mAge = age;
		mLicense = license;
	}
	
	public static Rider createRandomRider() {
		sLicense++;
		String licnum = Integer.toString(sLicense);
		
		return new Rider(StringGenerator.generateName(Language.FRENCH),
					RAND.nextInt(60) + 20,
					("LIC000" + licnum).substring(licnum.length()));
	}
	
	/**
	 * Gets the rider's name.
	 * @return The rider's name.
	 */
	public String getName() {
		return mName;
	}
	
	/** 
	 * Gets the rider's age.
	 * @return The rider's age.
	 */
	public int getAge() {
		return mAge;
	}
	
	@Override
	public int hashCode() {
		return mLicense.hashCode();
	}
	
	/**
	 * Gets the rider's number of license.
	 * @return The rider's number of license.
	 */
	public String getLicense() {
		return mLicense;
	}
}
