/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery;

import com.warlordjones.steampunkery.FX.SteamSoundHandler;
import com.warlordjones.steampunkery.entity.*;
import com.warlordjones.steampunkery.entity.model.ModelFleshGolem;
import com.warlordjones.steampunkery.entity.model.ModelIBoat;
import com.warlordjones.steampunkery.entity.model.ModelMechanicalHorse;
import com.warlordjones.steampunkery.entity.model.ModelSkySquid;
import com.warlordjones.steampunkery.entity.render.*;
import com.warlordjones.steampunkery.items.ItemRendererMusket;
import com.warlordjones.steampunkery.items.SteamItems;
import com.warlordjones.steampunkery.tileentities.*;
import com.warlordjones.steampunkery.util.IGuiOverlayScheduledTickHandler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class SteamClientProxy extends SteamCommonProxy {
    @Override
    public void registerRenderThings() {
	RenderingRegistry.registerEntityRenderingHandler(
		EntityFleshGolem.class, new RenderFleshGolem(
			new ModelFleshGolem(), 0));
	// the 0.5F is the shadowsize
	RenderingRegistry.registerEntityRenderingHandler(EntityIBoat.class,
		new RenderIBoat(new ModelIBoat(), 0));
	RenderingRegistry.registerEntityRenderingHandler(
		EntityMechanicalHorse.class, new RenderMechanicalHorse(
			new ModelMechanicalHorse(), 0));
	RenderingRegistry.registerEntityRenderingHandler(EntitySkySquid.class,
		new RenderSkySquid(new ModelSkySquid(), 0));
	RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class,
		new RenderBullet(SteamItems.bullet));
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIbeam.class,
		new TileEntityIBeamRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGaslight.class,
		new TileEntityGaslightRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTeslaCoil.class,
		new TileEntityTeslaCoilRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(
		TileEntityCryoPlayer.class, new TileEntityCryoPlayerRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHatch.class,
		new TileEntityHatchRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyor.class,
		new TileEntityConveyorRenderer());
	MinecraftForgeClient.registerItemRenderer(SteamItems.musket.itemID,
		new ItemRendererMusket());
	MinecraftForge.EVENT_BUS.register(new SteamSoundHandler());
    }

    @Override
    public void registerSoundEffects() {
	MinecraftForge.EVENT_BUS.register(new SteamSoundHandler());
    }

    @Override
    public void registerTickHandlers() {
	TickRegistry.registerScheduledTickHandler(
		new IGuiOverlayScheduledTickHandler(), Side.CLIENT);
	TickRegistry.registerTickHandler(new SteamTickHandler(), Side.CLIENT);
    }
}
