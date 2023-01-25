package me.lagggpixel.moderation.Managers;

import me.lagggpixel.moderation.Utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class StaffManager {

    static StaffManager INSTANCE;

    public StaffManager() {
        INSTANCE = this;
    }

    public static StaffManager getInstance() {
        return INSTANCE;
    }

    public void setInventory(Player player) {
        PlayerInventory inventory = player.getInventory();
        inventory.clear();

        ItemStack vanishItem = new ItemBuilder(Material.LIME_DYE)
                .setDisplayName(ChatColor.GREEN + "Vanish")
                .setLore(ChatColor.GRAY + "" + ChatColor.ITALIC + "Right click")
                .build();
        inventory.setItem(8, vanishItem);


        ItemStack freezeItem = new ItemBuilder(Material.PACKED_ICE)
                .setDisplayName(ChatColor.GREEN + "Freeze/Unfreeze player")
                .setLore(ChatColor.GRAY + "" + ChatColor.ITALIC + "Left click on player")
                .build();
        inventory.setItem(4, freezeItem);


        ItemStack historyItem = new ItemBuilder(Material.BOOKSHELF)
                .setDisplayName(ChatColor.GREEN + "History player")
                .setLore(ChatColor.GRAY + "" + ChatColor.ITALIC + "Left click on player")
                .build();
        inventory.setItem(2, historyItem);


        ItemStack invseeItem = new ItemBuilder(Material.BOOK)
                .setDisplayName(ChatColor.GREEN + "Invsee player")
                .setLore(ChatColor.GRAY + "" + ChatColor.ITALIC + "Left click on player")
                .build();
        inventory.setItem(1, invseeItem);

        ItemStack compassItem = new ItemBuilder(Material.COMPASS).build();
        inventory.setItem(0, compassItem);
    }
}
