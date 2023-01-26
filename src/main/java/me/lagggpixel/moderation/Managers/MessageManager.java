package me.lagggpixel.moderation.Managers;

import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MessageManager {

    static MessageManager INSTANCE;

    //<editor-fold desc="Message Variables">
    private String prefix;
    private String invalidUsage;
    private String playerNotOnline;
    private String cannotFreezeSelf;
    private String cannotFreezePlayer;
    private String frozePlayer;
    private String unFrozePlayer;
    private String loggedWhileFrozen;
    private String playerOnlyCommand;
    private String playerModMode;
    private String playerUnModMode;
    private String cannotHitModPlayer;
    private String cannotHitFrozenPlayer;
    private String cannotDoThatWhileFrozen;
    private String cannotDoThatWhileMod;
    //</editor-fold>

    public MessageManager() {
        INSTANCE = this;

        setupVar();
    }

    public void setupVar() {
        prefix = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("prefix")));
        invalidUsage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("invalidUsage")));
        playerNotOnline = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerNotOnline")));
        cannotFreezeSelf = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotFreezeSelf")));
        cannotFreezePlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotFreezePlayer")));
        frozePlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("frozePlayer")));
        unFrozePlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("unFrozePlayer")));
        loggedWhileFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("loggedWhileFrozen")));
        playerOnlyCommand = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerOnlyCommand")));
        playerModMode = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerModMode")));
        playerUnModMode = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerUnModMode")));
        cannotHitModPlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotHitModPlayer")));
        cannotHitFrozenPlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotHitFrozenPlayer")));
        cannotDoThatWhileFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotDoThatWhileFrozen")));
        cannotDoThatWhileMod = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotDoThatWhileMod")));

    }

    public static MessageManager getInstance() {
        return INSTANCE;
    }

    public void sendInvalidUsage(Player player) {
        player.sendMessage(prefix + invalidUsage);
    }
    public void sendInvalidUsage() {
        Bukkit.getConsoleSender().sendMessage(prefix + invalidUsage);
    }
    public void sendPlayerNotOnline(Player player) {
        player.sendMessage(prefix + playerNotOnline);
    }
    public void sendCannotFreezeSelf(Player player) {
        player.sendMessage(prefix + cannotFreezeSelf);
    }

    public void sendFreezePlayer(Player player, Player frozenPlayer) {
        player.sendMessage(prefix + frozePlayer.replace("{PLAYER}", frozenPlayer.getDisplayName()));
    }
    public void sendFreezePlayer(Player frozenPlayer) {
        Main.getInstance().getServer().getConsoleSender().sendMessage(prefix + frozePlayer.replace("{PLAYER}", frozenPlayer.getDisplayName()));
    }

    public void sendUnFreezePlayer(Player player, Player frozenPlayer) {
        player.sendMessage(prefix + unFrozePlayer.replace("{PLAYER}", frozenPlayer.getDisplayName()));
    }
    public void sendUnFreezePlayer(Player frozenPlayer) {
        Main.getInstance().getServer().getConsoleSender().sendMessage(prefix + unFrozePlayer.replace("{PLAYER}", frozenPlayer.getDisplayName()));
    }

    public void sendCannotFreezePlayer(Player player) {
        player.sendMessage(prefix + cannotFreezePlayer);
    }
    public void sendPlayerOnlyCommand() {
        Bukkit.getServer().getConsoleSender().sendMessage(prefix + playerOnlyCommand);
    }
    public void sendPlayerModMode(Player player) {
        player.sendMessage(prefix + playerModMode);
    }
    public void sendPlayerUnModMode(Player player) {
        player.sendMessage(prefix + playerUnModMode);
    }
    public void sendCannotHitModPlayer(Player player) {
        player.sendMessage(prefix + cannotHitModPlayer);
    }
    public void sendCannotHitFrozenPlayer(Player player) {
        player.sendMessage(prefix + cannotHitFrozenPlayer);
    }
    public void sendLoggedOutWhileFrozen(Player loggedPlayer) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.hasPermission("staff.notify")) {
                onlinePlayer.sendMessage(prefix + loggedWhileFrozen.replace("{PLAYER}", loggedPlayer.getName()));
            }
        }
    }

    public void sendCannotDoThatWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotDoThatWhileFrozen);
    }
    public void sendCannotDoThatWhileMod(Player player) {
        player.sendMessage(prefix + cannotDoThatWhileMod);
    }
}
