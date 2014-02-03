/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.steampunkery.blocks;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.warcore.RegistryUtils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class SteamBlocks {
    public static Block asteroid_block;
    public static Block asteroid_iron;
    public static Block bolted_steel;
    public static Block bomb;
    public static Block brass_block;
    public static Block brass_plaque;
    public static Block cloudy_ether, smog, psmog;
    public static Block conveyor;
    public static Block cryo_player;
    public static Block deep_carpet;
    public static BlockDeeps deeps;
    public static Block eldritch_metal;
    public static BlockEtherPortal ether_portal;
    public static Block flesh_block;
    public static Block gaslamp, gaslight, gaslight_frame;
    public static Block hatch;
    public static Block hot_mud;
    public static Block i_beam;
    public static Block lightning_rod;
    public static Block mercury_dirt;
    // Block Section
    public static Block metal_blocks, alloy_blocks, ore_blocks;
    public static Block meteor;
    public static Block plated_metals;
    public static Block sky_rail;
    public static Block slate, slate_cobble, slate_brick, slate_stair,
	    slate_slab;
    public static Block soul_pumpkin;
    public static Fluid steam;
    public static Block steam_block;
    public static Block tank;
    public static Block tank_track, gun_barrel, engine_block;
    public static Block tesla_coil;
    public static Block star;

    public static void RegisterBlocks() {
	SteamBlocks.steam = new FluidSteam("Steam");
	// brass_block = alloy_blocks;
	SteamBlocks.metal_blocks = new MetalBlocks(ConfigSetup.metal_blocksID);
	SteamBlocks.alloy_blocks = new AlloyBlocks(ConfigSetup.alloy_blocksID);
	SteamBlocks.ore_blocks = new OreBlocks(ConfigSetup.ore_blocksID);
	SteamBlocks.ether_portal = new BlockEtherPortal(ConfigSetup.portalID);
	SteamBlocks.gaslamp = new Gaslamp(ConfigSetup.gaslampID,
		Material.redstoneLight);
	SteamBlocks.gaslight = new Gaslight(ConfigSetup.gaslightID,
		Material.redstoneLight);
	SteamBlocks.gaslight_frame = new GaslightFrame(
		ConfigSetup.gaslight_frameID, Material.redstoneLight)
		.setUnlocalizedName("gaslight_frame");
	SteamBlocks.lightning_rod = new LightningRod(
		ConfigSetup.lightning_rodID, Material.anvil);
	SteamBlocks.flesh_block = new FleshBlock(ConfigSetup.flesh_blockID,
		Material.sponge);
	SteamBlocks.soul_pumpkin = new SoulPumpkin(ConfigSetup.soul_pumpkinID,
		Material.pumpkin);
	SteamBlocks.meteor = new BlockMeteorite(ConfigSetup.meteorID,
		Material.rock).setUnlocalizedName("meteor");
	SteamBlocks.asteroid_block = new BlockBase(
		ConfigSetup.asteroid_blockID, Material.rock)
		.setUnlocalizedName("asteroid_block");
	SteamBlocks.asteroid_iron = new BlockBase(ConfigSetup.asteroid_ironID,
		Material.rock).setUnlocalizedName("asteroid_iron");
	SteamBlocks.mercury_dirt = new BlockBase(ConfigSetup.mercury_dirtID,
		Material.ground).setUnlocalizedName("mercury_dirt");
	SteamBlocks.hot_mud = new BlockBase(ConfigSetup.hot_mudID,
		Material.ground).setUnlocalizedName("hot_mud");
	SteamBlocks.eldritch_metal = new BlockBase(
		ConfigSetup.eldritch_metalID, Material.iron)
		.setUnlocalizedName("eldritch_metal").setBlockUnbreakable()
		.setResistance(-1);
	SteamBlocks.slate = new SlateBlock(ConfigSetup.slateID, Material.rock)
		.setHardness(1.0F).setResistance(9.0F);
	SteamBlocks.slate_cobble = new BlockBase(ConfigSetup.slate_cobbleID,
		Material.rock).setUnlocalizedName("slate_cobble")
		.setHardness(1.0F).setResistance(9.0F);
	SteamBlocks.slate_brick = new BlockBase(ConfigSetup.slate_brickID,
		Material.rock).setUnlocalizedName("slate_brick")
		.setCreativeTab(Steampunkery.BlockTab).setHardness(1.0F)
		.setResistance(9.0F);
	SteamBlocks.slate_stair = new SlateStair(ConfigSetup.slate_stairID, 0)
		.setHardness(1.0F).setResistance(9.0F);
	SteamBlocks.slate_slab = new SlateSlab(ConfigSetup.slate_slabID, false,
		Material.rock).setHardness(1.0F).setResistance(9.0F);
	SteamBlocks.smog = new Smog(ConfigSetup.smogID, Material.air);
	SteamBlocks.psmog = new PSmog(ConfigSetup.psmogID, Material.air);
	SteamBlocks.deeps = new BlockDeeps(ConfigSetup.deeps_blockID,
		Material.air);
	SteamBlocks.i_beam = new IBeamBlock(ConfigSetup.ibeamID, Material.iron);
	SteamBlocks.tesla_coil = new TeslaCoil(ConfigSetup.tesla_coilID,
		Material.iron).setUnlocalizedName("tesla_coil");
	SteamBlocks.sky_rail = new SkyRail(ConfigSetup.sky_railID)
		.setUnlocalizedName("sky_rail");
	SteamBlocks.deep_carpet = new DeepCarpet(ConfigSetup.deep_carpetID)
		.setUnlocalizedName("deep_carpet");
	SteamBlocks.brass_plaque = new BrassPlaque(ConfigSetup.brass_plaqueID,
		Material.iron).setUnlocalizedName("brass_plaque");
	SteamBlocks.tank = new Tank(ConfigSetup.tankID)
		.setUnlocalizedName("tank");
	SteamBlocks.bomb = new Bomb(ConfigSetup.bombID, Material.iron)
		.setUnlocalizedName("bomb");
	SteamBlocks.bolted_steel = new BoltedSteel()
		.setUnlocalizedName("bolted_steel");
	SteamBlocks.tank_track = new TankTrack(ConfigSetup.tank_trackID,
		Material.iron).setUnlocalizedName("tank_track");
	SteamBlocks.gun_barrel = new GunBarrel(ConfigSetup.gun_barrelID,
		Material.iron).setUnlocalizedName("gun_barrel");
	SteamBlocks.engine_block = new EngineBlock(ConfigSetup.engine_blockID,
		Material.iron).setUnlocalizedName("engine_block");
	SteamBlocks.hatch = new Hatch(ConfigSetup.hatchID, Material.iron)
		.setUnlocalizedName("hatch");
	SteamBlocks.conveyor = new Conveyor(ConfigSetup.conveyorID,
		Material.iron).setUnlocalizedName("conveyor_belt");
	star = new Star(ConfigSetup.starID).setUnlocalizedName("star");
	// cryo_player= new CryoPlayerBlock(ConfigSetup.cryo_playerID,
	// Material.ice);
	SteamBlocks.steam_block = new SteamBlock(ConfigSetup.steam_blockID)
		.setUnlocalizedName("steam");
	RegistryUtils.addMetaBlocks(SteamBlocks.metal_blocks,
		ItemBlockMetals.class);
	RegistryUtils.addMetaBlocks(SteamBlocks.alloy_blocks,
		ItemBlockAlloys.class);
	RegistryUtils
		.addMetaBlocks(SteamBlocks.ore_blocks, ItemBlockOres.class);
	RegistryUtils.addMetaBlocks(SteamBlocks.slate_stair,
		ItemBlockSlateStair.class);
	RegistryUtils.addMetaBlocks(SteamBlocks.slate_slab,
		ItemBlockSlateSlab.class);
	RegistryUtils.addMetaBlocks(SteamBlocks.deep_carpet,
		ItemBlockDeepCarpet.class);
	RegistryUtils.addMetaBlocks(star, ItemBlockStar.class);
	RegistryUtils.addBlock(SteamBlocks.gaslight_frame, "Gaslight Frame");
	RegistryUtils.addBlock(SteamBlocks.gaslamp, "Gaslamp");
	RegistryUtils.addBlock(SteamBlocks.gaslight, "Gaslight");
	RegistryUtils.addBlock(SteamBlocks.lightning_rod, "Lightning Rod");
	RegistryUtils.addBlock(SteamBlocks.flesh_block, "Flesh Block");
	RegistryUtils.addBlock(SteamBlocks.soul_pumpkin, "Ensouled Pumpkin");
	RegistryUtils.addBlock(SteamBlocks.ether_portal, "Ether Portal");
	RegistryUtils.addBlock(SteamBlocks.asteroid_block, "Asteroid Rock");
	RegistryUtils.addBlock(SteamBlocks.asteroid_iron, "Asteroid Iron Ore");
	RegistryUtils.addBlock(SteamBlocks.meteor, "Meteor");
	RegistryUtils.addBlock(SteamBlocks.eldritch_metal, "Eldritch Metal");
	RegistryUtils.addBlock(SteamBlocks.mercury_dirt, "Mercurial Dirt");
	RegistryUtils.addBlock(SteamBlocks.slate, "Slate");
	RegistryUtils.addBlock(SteamBlocks.slate_cobble, "Slate Cobblestone");
	RegistryUtils.addBlock(SteamBlocks.slate_brick, "Slate Bricks");
	RegistryUtils.addBlock(SteamBlocks.smog, "Smog");
	RegistryUtils.addBlock(SteamBlocks.psmog, "Poisonous Smog");
	RegistryUtils.addBlock(SteamBlocks.deeps, "Deeps");
	RegistryUtils.addBlock(SteamBlocks.i_beam, "I-Beam");
	RegistryUtils.addBlock(SteamBlocks.tesla_coil, "Tesla Coil");
	RegistryUtils.addBlock(SteamBlocks.sky_rail, "Golden Skyrail");
	RegistryUtils.addBlock(SteamBlocks.hot_mud, "Scalding Mud");
	RegistryUtils.addBlock(SteamBlocks.brass_plaque, "Brass Plaque");
	RegistryUtils.addBlock(SteamBlocks.tank, "Test Tank");
	RegistryUtils.addBlock(SteamBlocks.bomb, "Bomb");
	RegistryUtils.addBlock(SteamBlocks.bolted_steel, "Bolted Steel");
	RegistryUtils.addBlock(SteamBlocks.gun_barrel, "Gun Barrel");
	RegistryUtils.addBlock(SteamBlocks.tank_track, "Tank Track");
	RegistryUtils.addBlock(SteamBlocks.engine_block, "Engine Block");
	RegistryUtils.addBlock(SteamBlocks.hatch, "Hatch");
	RegistryUtils.addBlock(SteamBlocks.conveyor, "Conveyor Belt");
	RegistryUtils.addBlock(SteamBlocks.steam_block, "Steam");
    }
}
