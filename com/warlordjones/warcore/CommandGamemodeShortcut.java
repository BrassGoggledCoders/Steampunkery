/*
 * @author warlordjones
 * 
 * Using this source for addon development or examples/education is cool with me. 
 * Taking this source code and claiming it is yours isn't cool!

 */
package com.warlordjones.warcore;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.WorldSettings;

public class CommandGamemodeShortcut extends CommandBase {
    /**
     * Adds the strings available in this command to the given list of tab
     * completion options.
     */
    @Override
    public List addTabCompletionOptions(
	    final ICommandSender par1ICommandSender,
	    final String[] par2ArrayOfStr) {
	return par2ArrayOfStr.length == 1 ? CommandBase
		.getListOfStringsMatchingLastWord(par2ArrayOfStr, new String[] {
			"survival", "creative", "adventure" })
		: par2ArrayOfStr.length == 2 ? CommandBase
			.getListOfStringsMatchingLastWord(par2ArrayOfStr,
				getListOfPlayerUsernames()) : null;
    }

    @Override
    public String getCommandName() {
	return "gm";
    }

    @Override
    public String getCommandUsage(final ICommandSender par1ICommandSender) {
	return "commands.gamemode.usage";
    }

    /**
     * Return the required permission level for this command.
     */
    @Override
    public int getRequiredPermissionLevel() {
	return 2;
    }

    /**
     * Return whether the specified command parameter index is a username
     * parameter.
     */
    @Override
    public boolean isUsernameIndex(final String[] par1ArrayOfStr, final int par2) {
	return par2 == 1;
    }

    @Override
    public void processCommand(final ICommandSender par1ICommandSender,
	    final String[] par2ArrayOfStr) {
	if (par2ArrayOfStr.length > 0) {
	    final EnumGameType enumgametype = getGameModeFromCommand(
		    par1ICommandSender, par2ArrayOfStr[0]);
	    final EntityPlayerMP entityplayermp = par2ArrayOfStr.length >= 2 ? CommandBase
		    .getPlayer(par1ICommandSender, par2ArrayOfStr[1])
		    : CommandBase.getCommandSenderAsPlayer(par1ICommandSender);
	    entityplayermp.setGameType(enumgametype);
	    entityplayermp.fallDistance = 0.0F;
	    final ChatMessageComponent chatmessagecomponent = ChatMessageComponent
		    .createFromTranslationKey("gameMode."
			    + enumgametype.getName());

	    if (entityplayermp != par1ICommandSender)
		CommandBase.notifyAdmins(par1ICommandSender, 1,
			"commands.gamemode.success.other", new Object[] {
				entityplayermp.getEntityName(),
				chatmessagecomponent });
	    else
		CommandBase.notifyAdmins(par1ICommandSender, 1,
			"commands.gamemode.success.self",
			new Object[] { chatmessagecomponent });
	} else
	    throw new WrongUsageException("commands.gamemode.usage",
		    new Object[0]);
    }

    /**
     * Gets the Game Mode specified in the command.
     */
    protected EnumGameType getGameModeFromCommand(
	    final ICommandSender par1ICommandSender, final String par2Str) {
	return !par2Str.equalsIgnoreCase(EnumGameType.SURVIVAL.getName())
		&& !par2Str.equalsIgnoreCase("s") ? !par2Str
		.equalsIgnoreCase(EnumGameType.CREATIVE.getName())
		&& !par2Str.equalsIgnoreCase("c") ? !par2Str
		.equalsIgnoreCase(EnumGameType.ADVENTURE.getName())
		&& !par2Str.equalsIgnoreCase("a") ? WorldSettings
		.getGameTypeById(CommandBase.parseIntBounded(
			par1ICommandSender, par2Str, 0,
			EnumGameType.values().length - 2))
		: EnumGameType.ADVENTURE : EnumGameType.CREATIVE
		: EnumGameType.SURVIVAL;
    }

    /**
     * Returns String array containing all player usernames in the server.
     */
    protected String[] getListOfPlayerUsernames() {
	return MinecraftServer.getServer().getAllUsernames();
    }
}
