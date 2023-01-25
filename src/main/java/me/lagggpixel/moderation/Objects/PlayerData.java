package me.lagggpixel.moderation.Objects;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Utils.InventoryUtils;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;

@Getter
@Setter
@RequiredArgsConstructor
@Data
public class PlayerData implements ConfigurationSerializable {

    final UUID uuid;
    boolean isStaff;
    boolean isVanished;
    boolean isFrozen;
    ItemStack[] inventory;
    ItemStack[] armour;

    public PlayerData(Map<String, Object> map) {
        this.uuid = UUID.fromString(String.valueOf(map.get("uuid")));
        this.isStaff = Boolean.parseBoolean(String.valueOf(map.get("staff")));
        this.isVanished = Boolean.parseBoolean(String.valueOf(map.get("vanished")));
        this.isFrozen = Boolean.parseBoolean(String.valueOf(map.get("frozen")));
        try {
            this.inventory = InventoryUtils.itemStackArrayFromBase64(String.valueOf(map.get("inventory")));
            this.armour = InventoryUtils.itemStackArrayFromBase64(String.valueOf(map.get("armour")));
        }
        catch (IOException exception) {
            Main.getInstance().getLogger().log(Level.SEVERE, "Unable to load player data inventory for: ", uuid);
        }
    }

    @NotNull
    @Override
    public Map<String, Object> serialize() {
        return new HashMap<>() {{
                put("uuid", uuid);
                put("staff", isStaff);
                put("vanished", isVanished);
                put("frozen", isFrozen);
                put("inventory", InventoryUtils.itemStackArrayToBase64(inventory));
                put("armor",  InventoryUtils.itemStackArrayToBase64(armour));
        }};
    }
}
