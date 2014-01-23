package com.warlordjones.steampunkery;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import com.warlordjones.steampunkery.FX.SteamSoundHandler;
import com.warlordjones.steampunkery.entity.EntityBullet;
import com.warlordjones.steampunkery.entity.EntityFleshGolem;
import com.warlordjones.steampunkery.entity.EntityIBoat;
import com.warlordjones.steampunkery.entity.EntityMechanicalHorse;
import com.warlordjones.steampunkery.entity.EntitySkySquid;
import com.warlordjones.steampunkery.entity.model.ModelFleshGolem;
import com.warlordjones.steampunkery.entity.model.ModelIBoat;
import com.warlordjones.steampunkery.entity.model.ModelMechanicalHorse;
import com.warlordjones.steampunkery.entity.model.ModelSkySquid;
import com.warlordjones.steampunkery.entity.render.RenderBullet;
import com.warlordjones.steampunkery.entity.render.RenderFleshGolem;
import com.warlordjones.steampunkery.entity.render.RenderIBoat;
import com.warlordjones.steampunkery.entity.render.RenderMechanicalHorse;
import com.warlordjones.steampunkery.entity.render.RenderSkySquid;
import com.warlordjones.steampunkery.items.ItemRendererMusket;
import com.warlordjones.steampunkery.items.SteamItems;
import com.warlordjones.steampunkery.tileentities.TileEntityConveyor;
import com.warlordjones.steampunkery.tileentities.TileEntityConveyorRenderer;
import com.warlordjones.steampunkery.tileentities.TileEntityCryoPlayer;
import com.warlordjones.steampunkery.tileentities.TileEntityCryoPlayerRenderer;
import com.warlordjones.steampunkery.tileentities.TileEntityGaslight;
import com.warlordjones.steampunkery.tileentities.TileEntityGaslightRenderer;
import com.warlordjones.steampunkery.tileentities.TileEntityHatch;
import com.warlordjones.steampunkery.tileentities.TileEntityHatchRenderer;
import com.warlordjones.steampunkery.tileentities.TileEntityIBeamRenderer;
import com.warlordjones.steampunkery.tileentities.TileEntityIbeam;
import com.warlordjones.steampunkery.tileentities.TileEntityTeslaCoil;
import com.warlordjones.steampunkery.tileentities.TileEntityTeslaCoilRenderer;
import com.warlordjones.steampunkery.util.IGuiOverlayScheduledTickHandler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

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
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHatch.class, new TileEntityHatchRenderer());
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityConveyor.class, new TileEntityConveyorRenderer());
	MinecraftForgeClient.registerItemRenderer(SteamItems.musket.itemID,
		(IItemRenderer) new ItemRendererMusket());
	CapeHandler.handleCapes();
	MinecraftForge.EVENT_BUS.register(new SteamSoundHandler());
    }

    @Override
    public void registerTickHandlers() {
	TickRegistry.registerScheduledTickHandler(
		new IGuiOverlayScheduledTickHandler(), Side.CLIENT);
	TickRegistry.registerTickHandler(new SteamTickHandler(), Side.CLIENT);
    }
    @Override
    public void registerSoundEffects()
    {
	MinecraftForge.EVENT_BUS.register(new SteamSoundHandler());
    }
}
