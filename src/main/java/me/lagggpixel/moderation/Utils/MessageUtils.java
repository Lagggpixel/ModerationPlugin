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
        setDefault("prefix", "&a&lModeration &e»&r ");

        setDefault("invalidUsage", "&cInvalid Usage");
        setDefault("playerNotOnline", "&cThat player is not online");
        setDefault("cannotFreezeSelf", "&cYou can not freeze yourself");
        setDefault("cannotFreezePlayer", "&cThat player can not be frozen");
        setDefault("frozePlayer", "You have frozen {PLAYER}");
        setDefault("unFrozePlayer", "You have unfrozen {PLAYER}");
        setDefault("loggedWhileFrozen", "&c{PLAYER} logged out while frozen");
        setDefault("playerOnlyCommand", "&cOnly players can execute that command");
        setDefault("playerModMode", "&cYou are now in mod mode");
        setDefault("playerUnModMode", "&cYou are now out of mod mode");
        setDefault("cannotHitModPlayer", "&cYou can not hit a player that is in mod mode");
        setDefault("cannotHitFrozenPlayer", "&cYou can not hit a frozen player");
        setDefault("cannotDoThatWhileFrozen", "&cYou can not do that while frozen");
        setDefault("cannotDoThatWhileMod", "&cYou can not do that while in mod mode");
        save();
    }
}
