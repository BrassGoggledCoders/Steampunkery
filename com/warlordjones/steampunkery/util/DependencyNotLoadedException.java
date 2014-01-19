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
