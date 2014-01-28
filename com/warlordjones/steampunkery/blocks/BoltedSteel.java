package com.warlordjones.steampunkery.blocks;

import java.util.List;

import com.warlordjones.steampunkery.ConfigSetup;
import com.warlordjones.steampunkery.SteamConstants;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class BoltedSteel extends BlockBase {
    public static int[] textureRefByID = { 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19,
	    15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2,
	    27, 14, 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1,
	    18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 4, 4, 5, 5, 4, 4,
	    5, 5, 17, 17, 22, 26, 17, 17, 22, 26, 16, 16, 20, 20, 16, 16, 28,
	    28, 21, 21, 46, 42, 21, 21, 43, 38, 4, 4, 5, 5, 4, 4, 5, 5, 9, 9,
	    30, 12, 9, 9, 30, 12, 16, 16, 20, 20, 16, 16, 28, 28, 25, 25, 45,
	    37, 25, 25, 40, 32, 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19,
	    15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 0, 0,
	    6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1,
	    13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 4, 4, 5, 5, 4, 4, 5, 5, 17, 17,
	    22, 26, 17, 17, 22, 26, 7, 7, 24, 24, 7, 7, 10, 10, 29, 29, 44, 41,
	    29, 29, 39, 33, 4, 4, 5, 5, 4, 4, 5, 5, 9, 9, 30, 12, 9, 9, 30, 12,
	    7, 7, 24, 24, 7, 7, 10, 10, 8, 8, 36, 35, 8, 8, 34, 11 };
    public static Icon[] textures = new Icon[47];

    public BoltedSteel() {
	super(ConfigSetup.bolted_steelID, Material.glass);
	setHardness(0.5F);
    }

    public void addInformation(final ItemStack itemstack,
	    final EntityPlayer player, final List descriptiveList,
	    final boolean B) {

	descriptiveList.add("Test CTM Block");

    }

    @Override
    public Icon getBlockTexture(final IBlockAccess world, final int x,
	    final int y, final int z, final int side) {
	final boolean[] bitMatrix = new boolean[8];

	if (side == 0 || side == 1) {
	    bitMatrix[0] = world.getBlockId(x - 1, y, z - 1) == blockID;
	    bitMatrix[1] = world.getBlockId(x, y, z - 1) == blockID;
	    bitMatrix[2] = world.getBlockId(x + 1, y, z - 1) == blockID;
	    bitMatrix[3] = world.getBlockId(x - 1, y, z) == blockID;
	    bitMatrix[4] = world.getBlockId(x + 1, y, z) == blockID;
	    bitMatrix[5] = world.getBlockId(x - 1, y, z + 1) == blockID;
	    bitMatrix[6] = world.getBlockId(x, y, z + 1) == blockID;
	    bitMatrix[7] = world.getBlockId(x + 1, y, z + 1) == blockID;
	}
	if (side == 2 || side == 3) {
	    bitMatrix[0] = world.getBlockId(x + (side == 2 ? 1 : -1), y + 1, z) == blockID;
	    bitMatrix[1] = world.getBlockId(x, y + 1, z) == blockID;
	    bitMatrix[2] = world.getBlockId(x + (side == 3 ? 1 : -1), y + 1, z) == blockID;
	    bitMatrix[3] = world.getBlockId(x + (side == 2 ? 1 : -1), y, z) == blockID;
	    bitMatrix[4] = world.getBlockId(x + (side == 3 ? 1 : -1), y, z) == blockID;
	    bitMatrix[5] = world.getBlockId(x + (side == 2 ? 1 : -1), y - 1, z) == blockID;
	    bitMatrix[6] = world.getBlockId(x, y - 1, z) == blockID;
	    bitMatrix[7] = world.getBlockId(x + (side == 3 ? 1 : -1), y - 1, z) == blockID;
	}
	if (side == 4 || side == 5) {
	    bitMatrix[0] = world.getBlockId(x, y + 1, z + (side == 5 ? 1 : -1)) == blockID;
	    bitMatrix[1] = world.getBlockId(x, y + 1, z) == blockID;
	    bitMatrix[2] = world.getBlockId(x, y + 1, z + (side == 4 ? 1 : -1)) == blockID;
	    bitMatrix[3] = world.getBlockId(x, y, z + (side == 5 ? 1 : -1)) == blockID;
	    bitMatrix[4] = world.getBlockId(x, y, z + (side == 4 ? 1 : -1)) == blockID;
	    bitMatrix[5] = world.getBlockId(x, y - 1, z + (side == 5 ? 1 : -1)) == blockID;
	    bitMatrix[6] = world.getBlockId(x, y - 1, z) == blockID;
	    bitMatrix[7] = world.getBlockId(x, y - 1, z + (side == 4 ? 1 : -1)) == blockID;
	}

	int idBuilder = 0;

	for (int i = 0; i <= 7; i++)
	    idBuilder = idBuilder
		    + (bitMatrix[i] ? i == 0 ? 1 : i == 1 ? 2 : i == 2 ? 4
			    : i == 3 ? 8 : i == 4 ? 16 : i == 5 ? 32
				    : i == 6 ? 64 : 128 : 0);

	return idBuilder > 255 || idBuilder < 0 ? BoltedSteel.textures[0]
		: BoltedSteel.textures[BoltedSteel.textureRefByID[idBuilder]];
    }

    @Override
    public Icon getIcon(final int side, final int meta) {
	return BoltedSteel.textures[0];
    }

    @Override
    public void registerIcons(final IconRegister iconRegistry) {
	for (int i = 0; i < 47; i++)
	    BoltedSteel.textures[i] = iconRegistry
		    .registerIcon(SteamConstants.prefix + "woodGlass_"
			    + (i + 1));
    }
}