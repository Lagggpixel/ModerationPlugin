package me.lagggpixel.moderation.Commands;

import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Managers.MessageManager;
import me.lagggpixel.moderation.Managers.StaffManager;
import me.lagggpixel.moderation.Objects.PlayerData;
import me.quantiom.advancedvanish.util.AdvancedVanishAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.UUID;

public class ModCommand implements CommandExecutor {

    @SuppressWarnings("DataFlowIssue")
    public ModCommand() {
        Main.getInstance().getCommand("mod").setExecutor(this);
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender, @Nonnull Command command, @Nonnull String s, @Nonnull String[] args) {

        if (commandSender instanceof Player sender) {
            UUID uuid = sender.getUniqueId();
            PlayerData data = Main.getInstance().getPlayers().get(uuid);

            if (args.length == 0) {
                // Checks if the player is in staff mode
                if (data.isStaff()) {
                    // Player is in staff mode
                    sender.getInventory().clear();
                    sender.setAllowFlight(false);
                    // Puts the player out of vanish
                    if (AdvancedVanishAPI.INSTANCE.isPlayerVanished(sender)) {
                        sender.performCommand("vanish");
                    }
                    MessageManager.getInstance().sendPlayerUnModMode(sender);
                    data.setStaff(false);
                    sender.getInventory().setArmorContents(data.getArmour());
                    data.setArmour(null);
                    sender.getInventory().setContents(data.getInventory());
                    data.setInventory(null);
                } else {
                    // Player is not in staff mode
                    sender.setAllowFlight(true);
                    // Puts the player into vanish
                    if (!AdvancedVanishAPI.INSTANCE.isPlayerVanished(sender)) {
                        sender.performCommand("vanish");
                    }
                    MessageManager.getInstance().sendPlayerModMode(sender);
                    data.setStaff(true);
                    data.setInventory(sender.getInventory().getContents());
                    data.setArmour(sender.getInventory().getArmorContents());
                    StaffManager.getInstance().setInventory(sender);
                }
            } else {
                MessageManager.getInstance().sendInvalidUsage(sender);
            }
        } else {
            MessageManager.getInstance().sendPlayerOnlyCommand();
        }

        return true;
    }
}