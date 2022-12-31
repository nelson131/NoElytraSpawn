package me.nelson131.nes;

import io.papermc.paper.event.packet.PlayerChunkLoadEvent;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.nelson131.nes.NoElytraSpawn.plugin;

public class ChunkListener implements Listener {
    @EventHandler
    public void onChunk(PlayerChunkLoadEvent event) {

        Boolean elytraspawn = plugin.getConfig().getBoolean("disable-elytra-spawn");
        Chunk chunk = event.getChunk();

        if (elytraspawn == true) {
                if (chunk.getWorld().getEnvironment().equals(World.Environment.THE_END)) {
                    for (Entity entity : chunk.getEntities()) {
                        if (entity instanceof ItemFrame) {
                            ItemFrame frame = (ItemFrame) entity;
                            if (frame.getItem().getType() == Material.ELYTRA) {
                                frame.remove();
                            }
                        }
                    }
                }
            }
        }
    }


