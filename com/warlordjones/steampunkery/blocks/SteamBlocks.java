package com.warlordjones.steampunkery.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.Steampunkery;
import com.warlordjones.warcore.RegistryUtils;

public class SteamBlocks {
    public static Block asteroid_block;
    public static Block asteroid_iron;
    public static Block brass_block;
    public static Block cloudy_ether, smog, psmog;
    public static Block eldritch_metal;
    public static BlockEtherPortal ether_portal;
    public static Block flesh_block;
    public static Block gaslamp, gaslight, gaslight_frame;
    public static Block hot_mud;
    public static Block lightning_rod;
    public static Block mercury_dirt;
    public static BlockDeeps deeps;
    // Block Section
    public static Block metal_blocks, alloy_blocks, ore_blocks;
    public static Block meteor;
    public static Block slate, slate_cobble, slate_brick, slate_stair,
	    slate_slab;
    public static Block soul_pumpkin;
    public static Block i_beam;
    public static Block tesla_coil;
    public static Block sky_rail;
    public static Block deep_carpet;
    public static Block cryo_player;
    public static Block brass_plaque;
    public static Block tank;
    public static Block bomb;
    public static Block bolted_steel;
    public static Block plated_metals;
    public static Block tank_track, gun_barrel, engine_block;
    public static Block hatch;
    public static Block conveyor;

    public static void RegisterBlocks() {
	// brass_block = alloy_blocks;
	metal_blocks = new MetalBlocks(ConfigSetup.metal_blocksID);
	alloy_blocks = new AlloyBlocks(ConfigSetup.alloy_blocksID);
	ore_blocks = new OreBlocks(ConfigSetup.ore_blocksID);
	ether_portal = new BlockEtherPortal(ConfigSetup.portalID);
	gaslamp = new Gaslamp(ConfigSetup.gaslampID,
		Material.redstoneLight);
	gaslight = new Gaslight(ConfigSetup.gaslightID,
		Material.redstoneLight);
	gaslight_frame = new GaslightFrame(
		ConfigSetup.gaslight_frameID, Material.redstoneLight)
		.setUnlocalizedName("gaslight_frame");
	lightning_rod = new LightningRod(
		ConfigSetup.lightning_rodID, Material.anvil);
	flesh_block = new FleshBlock(ConfigSetup.flesh_blockID,
		Material.sponge);
	soul_pumpkin = new SoulPumpkin(ConfigSetup.soul_pumpkinID,
		Material.pumpkin);
	meteor = new BlockMeteorite(ConfigSetup.meteorID,
		Material.rock).setUnlocalizedName("meteor");
	asteroid_block = new BlockBase(
		ConfigSetup.asteroid_blockID, Material.rock)
		.setUnlocalizedName("asteroid_block");
	asteroid_iron = new BlockBase(ConfigSetup.asteroid_ironID,
		Material.rock).setUnlocalizedName("asteroid_iron");
	mercury_dirt = new BlockBase(ConfigSetup.mercury_dirtID,
		Material.ground).setUnlocalizedName("mercury_dirt");
	hot_mud = new BlockBase(ConfigSetup.hot_mudID,
		Material.ground).setUnlocalizedName("hot_mud");
	eldritch_metal = new BlockBase(
		ConfigSetup.eldritch_metalID, Material.iron)
		.setUnlocalizedName("eldritch_metal").setBlockUnbreakable()
		.setResistance(-1);
	slate = new SlateBlock(ConfigSetup.slateID, Material.rock)
		.setHardness(1.0F).setResistance(9.0F);
	slate_cobble = new BlockBase(ConfigSetup.slate_cobbleID,
		Material.rock).setUnlocalizedName("slate_cobble")
		.setHardness(1.0F).setResistance(9.0F);
	slate_brick = new BlockBase(ConfigSetup.slate_brickID,
		Material.rock).setUnlocalizedName("slate_brick")
		.setCreativeTab(Steampunkery.steampunkeryTab).setHardness(1.0F)
		.setResistance(9.0F);
	slate_stair = new SlateStair(ConfigSetup.slate_stairID, 0)
		.setHardness(1.0F).setResistance(9.0F);
	slate_slab = new SlateSlab(ConfigSetup.slate_slabID, false,
		Material.rock).setHardness(1.0F).setResistance(9.0F);
	smog = new Smog(ConfigSetup.smogID, Material.air);
	psmog = new PSmog(ConfigSetup.psmogID, Material.air);
	deeps = new BlockDeeps(ConfigSetup.deeps_blockID, Material.air);
	i_beam = new IBeamBlock(ConfigSetup.ibeamID, Material.iron);
	tesla_coil = new TeslaCoil(ConfigSetup.tesla_coilID, Material.iron)
		.setUnlocalizedName("tesla_coil");
	sky_rail = new SkyRail(ConfigSetup.sky_railID)
		.setUnlocalizedName("sky_rail");
	deep_carpet = new DeepCarpet(ConfigSetup.deep_carpetID)
		.setUnlocalizedName("deep_carpet");
	brass_plaque = new BrassPlaque(ConfigSetup.brass_plaqueID,
		Material.iron).setUnlocalizedName("brass_plaque");
	tank = new Tank(ConfigSetup.tankID).setUnlocalizedName("tank");
	bomb = new Bomb(ConfigSetup.bombID, Material.iron)
		.setUnlocalizedName("bomb");
	bolted_steel =  new BoltedSteel().setUnlocalizedName("bolted_steel");
	tank_track = new TankTrack(ConfigSetup.tank_trackID, Material.iron).setUnlocalizedName("tank_track");
	gun_barrel = new GunBarrel(ConfigSetup.gun_barrelID, Material.iron).setUnlocalizedName("gun_barrel");
	engine_block = new EngineBlock(ConfigSetup.engine_blockID, Material.iron).setUnlocalizedName("engine_block");
	hatch = new Hatch(ConfigSetup.hatchID, Material.iron).setUnlocalizedName("hatch");
	conveyor = new Conveyor(ConfigSetup.conveyorID, Material.iron).setUnlocalizedName("conveyor_belt");
	// cryo_player= new CryoPlayerBlock(ConfigSetup.cryo_playerID,
	// Material.ice);
	RegistryUtils.addMetaBlocks(metal_blocks,
		ItemBlockMetals.class);
	RegistryUtils.addMetaBlocks(alloy_blocks,
		ItemBlockAlloys.class);
	RegistryUtils
		.addMetaBlocks(ore_blocks, ItemBlockOres.class);
	RegistryUtils.addMetaBlocks(slate_stair,
		ItemBlockSlateStair.class);
	RegistryUtils.addMetaBlocks(slate_slab,
		ItemBlockSlateSlab.class);
	RegistryUtils.addMetaBlocks(deep_carpet, ItemBlockDeepCarpet.class);
	RegistryUtils.addBlock(gaslight_frame, "Gaslight Frame");
	RegistryUtils.addBlock(gaslamp, "Gaslamp");
	RegistryUtils.addBlock(gaslight, "Gaslight");
	RegistryUtils.addBlock(lightning_rod, "Lightning Rod");
	RegistryUtils.addBlock(flesh_block, "Flesh Block");
	RegistryUtils.addBlock(soul_pumpkin, "Ensouled Pumpkin");
	RegistryUtils.addBlock(ether_portal, "Ether Portal");
	RegistryUtils.addBlock(asteroid_block, "Asteroid Rock");
	RegistryUtils.addBlock(asteroid_iron, "Asteroid Iron Ore");
	RegistryUtils.addBlock(meteor, "Meteor");
	RegistryUtils.addBlock(eldritch_metal, "Eldritch Metal");
	RegistryUtils.addBlock(mercury_dirt, "Mercurial Dirt");
	RegistryUtils.addBlock(slate, "Slate");
	RegistryUtils.addBlock(slate_cobble, "Slate Cobblestone");
	RegistryUtils.addBlock(slate_brick, "Slate Bricks");
	RegistryUtils.addBlock(smog, "Smog");
	RegistryUtils.addBlock(psmog, "Poisonous Smog");
	RegistryUtils.addBlock(deeps, "Deeps");
	RegistryUtils.addBlock(i_beam, "I-Beam");
	RegistryUtils.addBlock(tesla_coil, "Tesla Coil");
	RegistryUtils.addBlock(sky_rail, "Golden Skyrail");
	RegistryUtils.addBlock(hot_mud, "Scalding Mud");
	RegistryUtils.addBlock(brass_plaque, "Brass Plaque");
	RegistryUtils.addBlock(tank, "Test Tank");
	RegistryUtils.addBlock(bomb, "Bomb");
	RegistryUtils.addBlock(bolted_steel, "Bolted Steel");
	RegistryUtils.addBlock(gun_barrel, "Gun Barrel");
	RegistryUtils.addBlock(tank_track, "Tank Track");
	RegistryUtils.addBlock(engine_block, "Engine Block");
	RegistryUtils.addBlock(hatch, "Hatch");
	RegistryUtils.addBlock(conveyor, "Conveyor Belt");
    }
}
