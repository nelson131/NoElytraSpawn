package me.nelson131.nes;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class NoElytraSpawn extends JavaPlugin {

    FileConfiguration config = getConfig();
    public static Plugin plugin = NoElytraSpawn.getPlugin();

    private static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new ChunkListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);

        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }
}
