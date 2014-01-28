package com.warlordjones.warcore;

import java.util.Random;

import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class ExtraLivingDropsEvents {
    public static double rand;
    public Random r = new Random();

    public World worldObj;

    @ForgeSubscribe
    public void onEntityDrop(final LivingDropsEvent event) {
	if (event.entityLiving instanceof EntityZombie) {
	    final EntityZombie entityzombie = new EntityZombie(worldObj);
	    if (event.entityLiving instanceof EntityZombie
		    && entityzombie.isVillager())
		event.entityLiving.dropItem(Item.emerald.itemID, r.nextInt(2));
	    event.entityLiving.dropItem(Item.bone.itemID, r.nextInt(2));
	    // event.entityLiving.dropItem(Item..itemID, r.nextInt(3));

	    if (ExtraLivingDropsEvents.rand < 2.00D) {
		ExtraLivingDropsEvents.rand = Math.random();
		event.entityLiving.dropItem(Item.feather.itemID, r.nextInt(2));
	    }
	    if (event.entityLiving instanceof EntityEnderman)
		if (ExtraLivingDropsEvents.rand < 2.00D)
		    event.entityLiving.dropItem(Item.eyeOfEnder.itemID,
			    r.nextInt(2));

	}
    }
}
