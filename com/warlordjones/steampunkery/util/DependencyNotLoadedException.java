/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.util;

public class DependencyNotLoadedException extends RuntimeException {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public DependencyNotLoadedException(final String string) {
	super(string);
    }
}
