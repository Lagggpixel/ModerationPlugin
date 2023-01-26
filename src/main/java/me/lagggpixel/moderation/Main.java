package me.lagggpixel.moderation;

import lombok.Getter;
import me.lagggpixel.moderation.Commands.FreezeCommand;
import me.lagggpixel.moderation.Commands.ModCommand;
import me.lagggpixel.moderation.Listeners.PlayerFrozenListeners;
import me.lagggpixel.moderation.Listeners.PlayerInteractListener;
import me.lagggpixel.moderation.Listeners.PlayerModListeners;
import me.lagggpixel.moderation.Objects.PlayerData;
import me.lagggpixel.moderation.Utils.PlayerUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

@Getter
public final class Main extends JavaPlugin {

    private static Main INSTANCE;

    Map<UUID, PlayerData> players;

    @Override
    public void onEnable() {

        INSTANCE = this;

        Main.getInstance().getLogger().log(Level.INFO, "Loading configs");
        setupConfigs();
        Main.getInstance().getLogger().log(Level.INFO, "Registering listeners");
        setupListeners();
        Main.getInstance().getLogger().log(Level.INFO, "Registering commands");
        setupCommands();
    }

    @Override
    public void onDisable() {
        PlayerUtils.saveData(players);
    }

    private void setupCommands() {
        new ModCommand();
        new FreezeCommand();
    }
    private void setupListeners() {
        new PlayerModListeners();
        new PlayerFrozenListeners();
        new PlayerInteractListener();
    }
    private void setupConfigs() {
        players = PlayerUtils.loadData();
    }

    public static Main getInstance() {
        return INSTANCE;
    }

}
