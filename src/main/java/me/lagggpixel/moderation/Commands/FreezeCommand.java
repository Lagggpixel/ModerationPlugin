package me.lagggpixel.moderation.Commands;


import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Managers.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class FreezeCommand implements CommandExecutor {

    @SuppressWarnings("DataFlowIssue")
    public FreezeCommand() {
        Main.getInstance().getCommand("freeze").setExecutor(this);
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] args) {

        if (commandSender instanceof Player sender) {
            // Player executed
            if (args.length == 1) {
                String playerName = args[0];
                Player player = Bukkit.getPlayerExact(playerName);

                if (player == null) {
                    MessageManager.getInstance().sendPlayerNotOnline(sender);
                    return true;
                }

                if (player.equals(sender)) {
                    MessageManager.getInstance().sendCannotFreezeSelf(sender);
                    return true;
                }

                if (player.hasPermission("staff.unfreezable")) {
                    MessageManager.getInstance().sendCannotFreezePlayer(sender);
                    return true;
                }

                if (Main.getInstance().getPlayers().get(player.getUniqueId()).isFrozen()) {
                    // Player is currently frozen
                    // Unfreezes player
                    Main.getInstance().getPlayers().get(player.getUniqueId()).setFrozen(false);
                    MessageManager.getInstance().sendUnFreezePlayer(sender, player);
                    player.closeInventory();
                }
                else {
                    // Player is currently frozen
                    // Unfreezes player
                    Main.getInstance().getPlayers().get(player.getUniqueId()).setFrozen(true);
                    MessageManager.getInstance().sendFreezePlayer(sender, player);
                    player.closeInventory();
                }
            }
            else {
                MessageManager.getInstance().sendInvalidUsage(sender);
            }
        }
        else {
            // Console
            if (args.length == 1) {
                String playerName = args[0];
                Player player = Bukkit.getPlayerExact(playerName);

                if (player == null) {
                    commandSender.sendMessage("That player is not online.");
                    return true;
                }

                if (player.hasPermission("staff.unfreezable")) {
                    commandSender.sendMessage("That player cannot be frozen");
                    return true;
                }

                if (Main.getInstance().getPlayers().get(player.getUniqueId()).isFrozen()) {
                    // Player is currently frozen
                    // Unfreezes player
                    Main.getInstance().getPlayers().get(player.getUniqueId()).setFrozen(false);
                    MessageManager.getInstance().sendUnFreezePlayer(player);
                    player.closeInventory();
                }
                else {
                    // Player is currently frozen
                    // Unfreezes player
                    Main.getInstance().getPlayers().get(player.getUniqueId()).setFrozen(true);
                    MessageManager.getInstance().sendFreezePlayer(player);
                    player.closeInventory();
                }
            }
            else {
                MessageManager.getInstance().sendInvalidUsage();
            }
        }

        return true;
    }
}

