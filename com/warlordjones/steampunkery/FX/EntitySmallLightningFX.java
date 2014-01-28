package com.warlordjones.steampunkery.FX;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class EntitySmallLightningFX extends EntityFX {
    private final float portalParticleScale;
    private final double portalPosX;
    private final double portalPosY;
    private final double portalPosZ;

    public EntitySmallLightningFX(final World par1World, final double par2,
	    final double par4, final double par6, final double par8,
	    final double par10, final double par12) {
	super(par1World, par2, par4, par6, par8, par10, par12);
	motionX = par8;
	motionY = par10;
	motionZ = par12;
	portalPosX = posX = par2;
	portalPosY = posY = par4;
	portalPosZ = posZ = par6;
	final float f = rand.nextFloat() * 0.6F + 0.4F;
	portalParticleScale = particleScale = rand.nextFloat() * 0.2F + 0.5F;
	particleRed = particleGreen = particleBlue = 1.0F * f;
	particleGreen *= 0.3F;
	particleRed *= 0.9F;
	particleMaxAge = (int) (Math.random() * 10.0D) + 40;
	noClip = true;
	setParticleTextureIndex((int) (Math.random() * 8.0D));
    }

    /**
     * Gets how bright this entity is.
     */
    @Override
    public float getBrightness(final float par1) {
	final float f1 = super.getBrightness(par1);
	float f2 = (float) particleAge / (float) particleMaxAge;
	f2 = f2 * f2 * f2 * f2;
	return f1 * (1.0F - f2) + f2;
    }

    @Override
    public int getBrightnessForRender(final float par1) {
	final int i = super.getBrightnessForRender(par1);
	float f1 = (float) particleAge / (float) particleMaxAge;
	f1 *= f1;
	f1 *= f1;
	final int j = i & 255;
	int k = i >> 16 & 255;
	k += (int) (f1 * 15.0F * 16.0F);

	if (k > 240)
	    k = 240;

	return j | k << 16;
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
	prevPosX = posX;
	prevPosY = posY;
	prevPosZ = posZ;
	float f = (float) particleAge / (float) particleMaxAge;
	final float f1 = f;
	f = -f + f * f * 2.0F;
	f = 1.0F - f;
	posX = portalPosX + motionX * f;
	posY = portalPosY + motionY * f + (1.0F - f1);
	posZ = portalPosZ + motionZ * f;

	if (particleAge++ >= particleMaxAge)
	    setDead();
    }

    @Override
    public void renderParticle(final Tessellator par1Tessellator,
	    final float par2, final float par3, final float par4,
	    final float par5, final float par6, final float par7) {
	float f6 = (particleAge + par2) / particleMaxAge;
	f6 = 1.0F - f6;
	f6 *= f6;
	f6 = 1.0F - f6;
	particleScale = portalParticleScale * f6;
	super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6,
		par7);
    }
}
