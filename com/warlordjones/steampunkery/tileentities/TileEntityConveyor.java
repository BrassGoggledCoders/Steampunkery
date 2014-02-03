/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.tileentities;

import java.util.List;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityConveyor extends TileEntity {
    @Override
    public void updateEntity() {
	super.updateEntity();
	final AxisAlignedBB box = AxisAlignedBB
		.getBoundingBox(0, 0, 0, 3, 3, 3);
	final List items = worldObj
		.getEntitiesWithinAABB(EntityItem.class, box);
	for (int i = 0; i < items.size(); i++) {
	    final EntityItem item = (EntityItem) items.get(i);
	    if (item.age > item.lifespan - 20)
		item.age = item.lifespan - 30;
	    if (item.motionY == 0)
		item.motionY = 0.4;
	}

    }
}
