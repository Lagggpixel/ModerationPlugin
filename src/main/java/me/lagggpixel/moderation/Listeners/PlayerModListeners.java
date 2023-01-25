package me.lagggpixel.moderation.Listeners;

import me.lagggpixel.moderation.Main;
import me.lagggpixel.moderation.Managers.MessageManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.UUID;

public class PlayerModListeners implements Listener {

    public PlayerModListeners() {
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isStaff()) {
            event.setCancelled(true);
            MessageManager.getInstance().sendCannotDoThatWhileMod(player);
        }

    }

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isStaff()) {
            event.setCancelled(true);
            MessageManager.getInstance().sendCannotDoThatWhileMod(player);
        }

    }

    @EventHandler
    public void ItemPickupEvent(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            UUID uuid = player.getUniqueId();

            if (Main.getInstance().getPlayers().get(uuid).isStaff()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void ItemDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isStaff()) {
            MessageManager.getInstance().sendCannotDoThatWhileMod(player);
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void PlayerHitEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            if (Main.getInstance().getPlayers().get(player.getUniqueId()).isStaff()) {
                MessageManager.getInstance().sendCannotDoThatWhileMod(player);
                event.setCancelled(true);
            }
        }

        if (event.getEntity() instanceof Player entity) {
            if (Main.getInstance().getPlayers().get(entity.getUniqueId()).isStaff()) {
                if (event.getDamager() instanceof Player) {
                    MessageManager.getInstance().sendCannotHitModPlayer((Player) event.getDamager());
                }
                event.setCancelled(true);
            }

        }
    }
}

