package me.nelson131.nes;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static me.nelson131.nes.NoElytraSpawn.plugin;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event){
        ItemStack itemStack = event.getCurrentItem();
        Boolean click = plugin.getConfig().getBoolean("disable-click-inventory");
        if(click == true){
            if(itemStack.getType() == Material.ELYTRA){
                itemStack.setAmount(0);
            }
        }
    }
}
