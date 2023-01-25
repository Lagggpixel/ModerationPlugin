package me.lagggpixel.moderation.Managers;

import me.lagggpixel.moderation.Utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Objects;

public class MessageManager {

    static MessageManager INSTANCE;

    //<editor-fold desc="Message Variables">
    private String prefix;
    private String noPermission;
    private String invalidUsage;
    private String playerAlreadyFrozen;
    private String playerNotOnline;
    private String cannotFreezeSelf;
    private String cannotFreezePlayer;
    private String frozePlayer;
    private String cannotUnFreezeSelf;
    private String playerNotFrozen;
    private String unFrozePlayer;
    private String cannotMoveWhileFrozen;
    private String cannotHitWhileFrozen;
    private String cannotHitFrozenPlayer;
    private String cannotSendCommandsWhileFrozen;
    private String cannotBreakBlocksWhileFrozen;
    private String cannotPlaceBlocksWhileFrozen;
    private String loggedWhileFrozen;
    private String playerVanished;
    private String playerUnVanished;
    private String playerOnlyCommand;
    private String playerFirstJoinMessage;
    private String playerJoinMessage;
    private String playerLeaveMessage;
    private String staffJoinMessage;
    private String staffLeaveMessage;
    private String playerModMode;
    private String playerUnModMode;
    private String reloadSuccessful;
    private String reloadFailed;
    private String cannotHitModPlayer;
    private String cannotPlaceBlocksWhileMod;
    private String cannotBreakBlocksWhileMod;
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
        noPermission = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("insufficientPermission")));
        invalidUsage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("invalidUsage")));
        playerAlreadyFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerAlreadyFrozen")));
        playerNotOnline = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerNotOnline")));
        cannotFreezeSelf = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotFreezeSelf")));
        cannotFreezePlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotFreezePlayer")));
        frozePlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("frozePlayer")));
        cannotUnFreezeSelf = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotUnFreezeSelf")));
        playerNotFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerNotFrozen")));
        unFrozePlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("unFreezePlayer")));
        cannotMoveWhileFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotMoveWhileFrozen")));
        cannotHitWhileFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotHitWhileFrozen")));
        cannotHitFrozenPlayer = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotHitFrozenPlayer")));
        loggedWhileFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("loggedWhileFrozen")));
        playerVanished = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerVanished")));
        playerUnVanished = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerUnVanished")));
        playerOnlyCommand = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerOnlyCommand")));
        playerFirstJoinMessage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerFirstJoinMessage")));
        playerJoinMessage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerJoinMessage")));
        playerLeaveMessage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerLeaveMessage")));
        staffJoinMessage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("staffJoinMessage")));
        staffLeaveMessage = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("staffLeaveMessage")));
        playerModMode = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerModMode")));
        playerUnModMode = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("playerUnModMode")));
        reloadSuccessful = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("reloadSuccessful")));
        reloadFailed = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("reloadFailed")));

        cannotDoThatWhileFrozen = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotDoThatWhileFrozen")));
        cannotDoThatWhileMod = ChatColor.translateAlternateColorCodes(
                '&', Objects.requireNonNull(MessageUtils.get().getString("cannotDoThatWhileMod")));

    }

    public static MessageManager getInstance() {
        return INSTANCE;
    }

    public void sendNoPerm(Player player) {
        player.sendMessage(prefix + noPermission);
    }
    public void sendInvalidUsage(Player player) {
        player.sendMessage(prefix + invalidUsage);
    }
    public void sendInvalidUsage() {
        Bukkit.getConsoleSender().sendMessage(prefix + invalidUsage);
    }
    public void sendPlayerAlreadyFrozen(Player player) {
        player.sendMessage(prefix + playerAlreadyFrozen);
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
    public void sendCannotUnFreezeSelf(Player player) {
        player.sendMessage(prefix + cannotUnFreezeSelf);
    }
    public void sendPlayerNotFrozen(Player player) {
        player.sendMessage(prefix + playerNotFrozen);
    }
    public void sendUnFreezePlayer(Player player, Player frozenPlayer) {
        player.sendMessage(prefix + unFrozePlayer.replace("{PLAYER}", frozenPlayer.getDisplayName()));
    }
    public void sendCannotMoveWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotMoveWhileFrozen);
    }
    public void sendCannotFreezePlayer(Player player) {
        player.sendMessage(prefix + cannotFreezePlayer);
    }
    public void sendCannotHitWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotHitWhileFrozen);
    }
    public void sendCannotHitFrozenPlayer(Player player) {
        player.sendMessage(prefix + cannotHitFrozenPlayer);
    }
    public void sendCannotSendCommandsWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotSendCommandsWhileFrozen);
    }
    public void sendCannotBreakBlocksWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotBreakBlocksWhileFrozen);
    }
    public void sendCannotPlaceBlocksWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotPlaceBlocksWhileFrozen);
    }
    public void sendLoggedWhileFrozen(Player staff, Player player) {
        staff.sendMessage(prefix + loggedWhileFrozen.replace("{PLAYER}", player.getName()));
    }
    public void sendPlayerVanished(Player player) {
        player.sendMessage(prefix + playerVanished);
    }
    public void sendPlayerUnVanished(Player player) {
        player.sendMessage(prefix + playerUnVanished);
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
    public void sendReloadSuccessful(Player player) {
        player.sendMessage(prefix + reloadSuccessful);
    }
    public void sendReloadSuccessful() {
        Bukkit.getConsoleSender().sendMessage(prefix + reloadSuccessful);
    }
    public void sendReloadFailed(Player player) {
        player.sendMessage(prefix + reloadFailed);
    }
    public void sendReloadFailed() {
        Bukkit.getConsoleSender().sendMessage(prefix + reloadFailed);
    }
    public void sendCannotHitModPlayer(Player player) {
        player.sendMessage(prefix + cannotHitModPlayer);
    }
    public void sendCannotPlaceBlocksWhileMod(Player player) {
        player.sendMessage(prefix + cannotPlaceBlocksWhileMod);
    }
    public void sendCannotBreakBlocksWhileMod(Player player) {
        player.sendMessage(prefix + cannotBreakBlocksWhileMod);
    }

    public void sendCannotDoThatWhileFrozen(Player player) {
        player.sendMessage(prefix + cannotDoThatWhileFrozen);
    }
    public void sendCannotDoThatWhileMod(Player player) {
        player.sendMessage(prefix + cannotDoThatWhileMod);
    }

    public String getPlayerFirstJoinMessage() {
        return playerFirstJoinMessage;
    }
    public String getPlayerJoinMessage() {
        return playerJoinMessage;
    }
    public String getPlayerLeaveMessage() {
        return playerLeaveMessage;
    }
    public String getStaffJoinMessage() {
        return staffJoinMessage;
    }
    public String getStaffLeaveMessage() {
        return staffLeaveMessage;
    }


}
