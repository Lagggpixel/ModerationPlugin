package me.lagggpixel.moderation.Utils;

import com.google.gson.Gson;
import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Objects.PlayerData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

public class PlayerUtils {
    private static final String PATH = "player_data";
    private static final File parentFile = new File(Main.getInstance().getDataFolder(), PATH);

    @NotNull
    public static Map<UUID, PlayerData> loadData() {
        if (!parentFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            parentFile.mkdirs();
        }

        final var map = new ConcurrentHashMap<UUID, PlayerData>();
        final var files = parentFile.listFiles();

        if (files == null) {
            return new ConcurrentHashMap<>();
        }

        for (File file : files) {
            final var name = file.getName().split("\\.")[0];
            final UUID uuid;

            try {
                uuid = UUID.fromString(name);
            } catch (IllegalArgumentException e) {
                continue;
            }

            PlayerData data = null;
            try {
                data = getDataFromFile(file);
            } catch (FileNotFoundException e) {
                Main.getInstance().getLogger().log(Level.SEVERE,"Data file did not load correctly");
            }

            map.put(uuid, data == null ? new PlayerData(uuid) : data);
        }

        return map;
    }

    public static void saveData(Map<UUID, PlayerData> map) {
        for (PlayerData value : map.values()) {
            try {
                setData(value);
            } catch (IOException e) {
                Main.getInstance().getLogger().log(Level.SEVERE, "Data did not save correctly");
            }
        }
    }

    @Nullable
    public static PlayerData getDataFromFile(File file) throws FileNotFoundException {
        Gson gson = new Gson();

        Reader reader = new FileReader(file);
        return gson.fromJson(reader, PlayerData.class);
    }

    public static void setData(PlayerData data) throws IOException {
        Gson gson = new Gson();
        File file = getPlayerFile(data.getUuid());

        Writer writer = new FileWriter(file, false);

        gson.toJson(data, writer);
        writer.flush();
        writer.close();
    }

    public static File getPlayerFile(UUID player) {
        if (!parentFile.exists()) {
            //noinspection ResultOfMethodCallIgnored
            parentFile.mkdirs();
        }

        return new File(parentFile, player.toString() + ".json");
    }
}