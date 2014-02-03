/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.warcore;

import java.util.Random;

public class RandomThings {
    public static int randInt(final int min, final int max) {
	// Usually this can be a field rather than a method variable
	final Random rand = new Random();

	// nextInt is normally exclusive of the top value,
	// so add 1 to make it inclusive
	final int randomNum = rand.nextInt(max - min + 1) + min;

	return randomNum;
    }
}
