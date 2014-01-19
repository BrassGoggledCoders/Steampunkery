package com.warlordjones.steampunkery.entity;

import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.Steampunkery;

import cpw.mods.fml.common.registry.EntityRegistry;

public class EntitySetup {
    public static void registerEntities() {
	int entity_id = 1;
	EntityRegistry.registerModEntity(EntityFleshGolem.class, "Flesh Golem",
		entity_id, Steampunkery.instance, 80, entity_id, true);
	entity_id++;
	EntityRegistry.registerModEntity(EntitySkySquid.class, "Sky Squid",
		entity_id, Steampunkery.instance, 80, 1, true);
	entity_id++;
	EntityRegistry.registerModEntity(EntityMechanicalHorse.class,
		"MechanicalHorse", entity_id, Steampunkery.instance, 80, 1,
		true);
	entity_id++;
	EntityRegistry.registerModEntity(EntityIBoat.class, "Dirigible Boat",
		entity_id, Steampunkery.instance, 80, 1, true);
	entity_id++;
	EntityRegistry.registerModEntity(EntityBullet.class, "Bullet",
		entity_id, Steampunkery.instance, 80, 1, true);
	entity_id++;
	EntityRegistry.registerModEntity(EntitySteamSpurt.class, "Steam Spurt",
		entity_id, Steampunkery.instance, 80, 1, true);
	entity_id++;
	if(ConfigSetup.debug_mode_B)
	{
	int id = 600; // has to be unique
	EntityList.IDtoClassMapping.put(id, EntitySkySquid.class);
	EntityList.entityEggs.put(id, new EntityEggInfo(id, 100, 200));
	id++;
	EntityList.IDtoClassMapping.put(id, EntityMechanicalHorse.class);
	EntityList.entityEggs.put(id, new EntityEggInfo(id, 100, 200));
	}
    }

    public static void addEntitySpawns() {

    }
}
