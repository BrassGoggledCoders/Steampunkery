package com.warlordjones.steampunkery;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.oredict.OreDictionary;

public class CapeHandler {
    public static void handleCapes() {
final ResourceLocation capeTextures = new ResourceLocation(
		"steampunkery:textures/capes/bg.png");
/*
	String[] users = { "warlordjones", "Player192", "Player345", "Player" + OreDictionary.WILDCARD_VALUE + OreDictionary.WILDCARD_VALUE + OreDictionary.WILDCARD_VALUE };
	String capeUrl = "http://i.imgur.com/sZ6wSBh.png";

	ThreadDownloadImageData image = new ThreadDownloadImageData(capeUrl,
		capeTextures, null);

	for (String username : users) {
	    Minecraft.getMinecraft().renderEngine.loadTexture(
		    new ResourceLocation("cloaks/" + username),
		    (TextureObject) image);
	}*/
	AbstractClientPlayer.getDownloadImageCape(capeTextures, "steampunkery:textures/capes/bg.png");
    }
}
