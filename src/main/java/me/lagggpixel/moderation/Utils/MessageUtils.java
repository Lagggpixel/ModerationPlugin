package me.lagggpixel.moderation.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessageUtils {

    static File LangFile;
    public static FileConfiguration LangConfig;

    public static void setup() {
        LangFile = new File(Bukkit.getServer().getPluginManager().getPlugin("StaffPlus").getDataFolder(),
                "lang.yml");
        if (!LangFile.exists()) {
            try {
                LangFile.getParentFile().mkdirs();
                LangFile.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        LangConfig = YamlConfiguration.loadConfiguration(LangFile);
        setupDefaults();
    }

    public static FileConfiguration get() {
        return LangConfig;
    }

    public static void save() {
        try {
            LangConfig.save(LangFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        LangConfig = YamlConfiguration.loadConfiguration(LangFile);
    }

    public static void setDefault(String path, String value) {
        if (!get().contains(path)) {
            get().set(path, value);
        }
    }
    public static void setDefault(String path, int value) {
        if (!get().contains(path)) {
            get().set(path, value);
        }
    }
    public static void setDefault(String path, boolean value) {
        if (!get().contains(path)) {
            get().set(path, value);
        }
    }

    public static void setupDefaults() {
        setDefault("prefix", "&6&lInferno &e»&r ");

        setDefault("playerOnlyCommand", "&cOnly players can execute that command");
        setDefault("playerFirstJoinMessage", "&f{PLAYER} &bhas just joined the server for the first time");
        setDefault("playerJoinMessage", "&f[&a+&f] &f&f{PLAYER}");
        setDefault("playerLeaveMessage", "&f[&a-&f] &f&f{PLAYER}");
        setDefault("staffJoinMessage", "&f[&a+&f] &6Staff &f&f{PLAYER}");
        setDefault("staffLeaveMessage", "&f[&a-&f] &6Staff &f&f{PLAYER}");
        setDefault("insufficientPermission", "&cYou do not have permission to perform that command");
        setDefault("invalidUsage", "&cInvalid Usage");
        setDefault("playerAlreadyFrozen", "&cThat player is already frozen");
        setDefault("playerNotOnline", "&cThat player is not online");
        setDefault("cannotFreezeSelf", "&cYou can not freeze yourself");
        setDefault("frozePlayer", "You have frozen {PLAYER}");
        setDefault("cannotUnFreezeSelf", "&cYou can not unfreeze yourself");
        setDefault("playerNotFrozen", "&cThat player is not frozen");
        setDefault("unFreezePlayer", "You have unfrozen {PLAYER}");
        setDefault("cannotMoveWhileFrozen", "&cYou can not move while frozen");
        setDefault("cannotHitWhileFrozen", "&cYou can not hit others while frozen");
        setDefault("cannotHitFrozenPlayer", "&cYou can not hit a frozen player");
        setDefault("cannotSendCommandsWhileFrozen", "&cYou can not send commands while frozen");
        setDefault("cannotBreakBlocksWhileFrozen", "&cYou can not break blocks while frozen");
        setDefault("cannotPlaceBlocksWhileFrozen", "&cYou can not place blocks while frozen");
        setDefault("loggedWhileFrozen", "&c{PLAYER} logged out while frozen");
        setDefault("playerModMode", "&cYou are now in mod mode");
        setDefault("playerUnModMode", "&cYou are now out of mod mode");
        setDefault("reloadSuccessful", "&cReload successful");
        setDefault("reloadFailed", "&cReload failed");
        setDefault("cannotHitModPlayer", "&cYou can not hit a player that is in mod mode");
        setDefault("playerFlyEnabled", "&cYou have enabled flying");
        setDefault("playerFlyDisabled", "&cYou have disabled flying");
        setDefault("cannotPlaceBlocksWhileMod", "&cYou can not place blocks wile in mod mode");
        setDefault("cannotBreakBlocksWhileMod", "&cYou can not break blocks wile in mod mode");
        setDefault("playerReach", "&c{PLAYER} just hit something {DISTANCE} away");
        setDefault("otherVanished", "&c{PLAYER} is now vanished");
        setDefault("otherUnVanished", "&c{PLAYER} is now not vanished");
        setDefault("alertsEnabled", "&cYou will now receive anti-cheat alerts");
        setDefault("alertsDisabled", "&cYou will not receive anti-cheat alerts anymore");
        setDefault("cannotFreezePlayer", "&cThat player can not be frozen");
        save();
    }
}
