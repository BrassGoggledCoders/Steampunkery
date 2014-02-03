/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidSteam extends Fluid {

    public FluidSteam(final String fluidName) {
	super("Steam");
	setDensity(-1);
	setViscosity(700);
	isGaseous();
	setTemperature(1000);
	FluidRegistry.registerFluid(this);
    }

}
