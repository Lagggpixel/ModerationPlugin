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
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.UUID;

public class PlayerFrozenListeners implements Listener {
    public PlayerFrozenListeners() {
        Main.getInstance().getServer().getPluginManager().registerEvents(this, Main.getInstance());
    }

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isFrozen()) {
            event.setCancelled(true);
            MessageManager.getInstance().sendCannotDoThatWhileFrozen(player);
        }

    }

    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isFrozen()) {
            event.setCancelled(true);
            MessageManager.getInstance().sendCannotDoThatWhileFrozen(player);
        }

    }

    @EventHandler
    public void ItemPickupEvent(EntityPickupItemEvent event) {
        if (event.getEntity() instanceof Player player) {
            UUID uuid = player.getUniqueId();

            if (Main.getInstance().getPlayers().get(uuid).isFrozen()) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void ItemDropEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isFrozen()) {
            MessageManager.getInstance().sendCannotDoThatWhileFrozen(player);
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void PlayerHitEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            if (Main.getInstance().getPlayers().get(player.getUniqueId()).isFrozen()) {
                MessageManager.getInstance().sendCannotDoThatWhileFrozen(player);
                event.setCancelled(true);
            }
        }

        if (event.getEntity() instanceof Player entity) {
            if (Main.getInstance().getPlayers().get(entity.getUniqueId()).isFrozen()) {
                if (event.getDamager() instanceof Player) {
                    MessageManager.getInstance().sendCannotDoThatWhileFrozen((Player) event.getDamager());
                }
                event.setCancelled(true);
            }

        }
    }

    @EventHandler
    public void PlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isFrozen()) {
            MessageManager.getInstance().sendCannotDoThatWhileFrozen(player);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void PlayerCommandExecute(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        if (Main.getInstance().getPlayers().get(uuid).isFrozen()) {

            String command = event.getMessage();
            String mainCommand = command.split(" ", 2)[0];

            if (!(mainCommand.equalsIgnoreCase("message")
                    || mainCommand.equalsIgnoreCase("msg")
                    || mainCommand.equalsIgnoreCase("reply")
                    || mainCommand.equalsIgnoreCase("tell")
                    || mainCommand.equalsIgnoreCase("r")
                    || mainCommand.equalsIgnoreCase("w")
            )) {
                event.setCancelled(true);
                MessageManager.getInstance().sendCannotDoThatWhileFrozen(player);
            }
        }
    }
}
