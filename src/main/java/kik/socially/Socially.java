package kik.socially;

import org.bukkit.plugin.java.JavaPlugin;

public final class Socially extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        ConfigManager config = new ConfigManager(this);
        CommandManager cmdmanager = new CommandManager(this);
        cmdmanager.registraCMDS();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
