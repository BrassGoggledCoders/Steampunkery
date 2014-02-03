/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.ConfigSetup;

import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.*;

/**
 * Reference implementation of {@link IFluidTank}. Use/extend this or implement
 * your own.
 * 
 * @author King Lemming, cpw (LiquidTank)
 * 
 */
public class Tank extends BlockBase implements IFluidTank {
    protected int capacity = 100;
    protected FluidStack fluid;
    protected TileEntity tile;

    public Tank(final Fluid fluid, final int amount, final int capacity) {
	this(new FluidStack(fluid, amount), capacity);
    }

    public Tank(final FluidStack stack, final int capacity) {
	super(ConfigSetup.tankID, Material.iron);
	fluid = stack;
	this.capacity = capacity;
    }

    public Tank(final int capacity) {
	this(null, capacity);
    }

    @Override
    public FluidStack drain(final int maxDrain, final boolean doDrain) {
	if (fluid == null)
	    return null;

	int drained = maxDrain;
	if (fluid.amount < drained)
	    drained = fluid.amount;

	final FluidStack stack = new FluidStack(fluid, drained);
	if (doDrain) {
	    fluid.amount -= drained;
	    if (fluid.amount <= 0)
		fluid = null;

	    if (tile != null)
		FluidEvent.fireEvent(new FluidEvent.FluidDrainingEvent(fluid,
			tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord,
			this));
	}
	return stack;
    }

    @Override
    public int fill(final FluidStack resource, final boolean doFill) {
	if (resource == null)
	    return 0;

	if (!doFill) {
	    if (fluid == null)
		return Math.min(capacity, resource.amount);

	    if (!fluid.isFluidEqual(resource))
		return 0;

	    return Math.min(capacity - fluid.amount, resource.amount);
	}

	if (fluid == null) {
	    fluid = new FluidStack(resource,
		    Math.min(capacity, resource.amount));

	    if (tile != null)
		FluidEvent.fireEvent(new FluidEvent.FluidFillingEvent(fluid,
			tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord,
			this));
	    return fluid.amount;
	}

	if (!fluid.isFluidEqual(resource))
	    return 0;
	int filled = capacity - fluid.amount;

	if (resource.amount < filled) {
	    fluid.amount += resource.amount;
	    filled = resource.amount;
	} else
	    fluid.amount = capacity;

	if (tile != null)
	    FluidEvent
		    .fireEvent(new FluidEvent.FluidFillingEvent(fluid,
			    tile.worldObj, tile.xCoord, tile.yCoord,
			    tile.zCoord, this));
	return filled;
    }

    @Override
    public int getCapacity() {
	return capacity;
    }

    /* IFluidTank */
    @Override
    public FluidStack getFluid() {
	return fluid;
    }

    @Override
    public int getFluidAmount() {
	if (fluid == null)
	    return 0;
	return fluid.amount;
    }

    @Override
    public FluidTankInfo getInfo() {
	return new FluidTankInfo(this);
    }

    public Tank readFromNBT(final NBTTagCompound nbt) {
	if (!nbt.hasKey("Empty")) {
	    final FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt);

	    if (fluid != null)
		setFluid(fluid);
	}
	return this;
    }

    public void setCapacity(final int capacity) {
	this.capacity = capacity;
    }

    public void setFluid(final FluidStack fluid) {
	this.fluid = fluid;
    }

    public NBTTagCompound writeToNBT(final NBTTagCompound nbt) {
	if (fluid != null)
	    fluid.writeToNBT(nbt);
	else
	    nbt.setString("Empty", "");
	return nbt;
    }
}
