package me.lagggpixel.moderation.Listeners;

import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerInteractListener implements Listener {
    public PlayerInteractListener() {
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.getHand() != null) {
            if (event.getHand().equals(EquipmentSlot.OFF_HAND)) {

                if (Main.getInstance().getPlayers().get(player.getUniqueId()).isStaff()) {

                    if (player.getInventory().getItemInMainHand().getItemMeta() != null) {

                        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "vanish") || player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "vanish")) {
                            PlayerInventory inventory = player.getInventory();
                            player.performCommand("v");
                            if (inventory.getItemInMainHand().getType().equals(Material.GRAY_DYE)) {
                                ItemStack vanish = new ItemBuilder(Material.LIME_DYE)
                                        .setDisplayName(ChatColor.GRAY + "Vanish")
                                        .setLore(ChatColor.GRAY + "" + ChatColor.ITALIC + "Right click")
                                        .build();
                                inventory.setItem(7, vanish);
                            } else if (inventory.getItemInMainHand().getType().equals(Material.LIME_DYE)) {
                                ItemStack vanish = new ItemBuilder(Material.LIME_DYE)
                                        .setDisplayName(ChatColor.GRAY + "Vanish")
                                        .setLore(ChatColor.GRAY + "" + ChatColor.ITALIC + "Right click")
                                        .build();
                                inventory.setItem(7, vanish);
                            }
                        }
                    }
                }
            }
        }

    }
}
