package kik.socially;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class ConfigManager {
    private final Plugin plugin;
    private FileConfiguration configurazione;

    public ConfigManager(Plugin plugin) {
        this.plugin = plugin;
        this.configurazione = plugin.getConfig();
    }
    public void reload(){
        plugin.reloadConfig();
        this.configurazione = plugin.getConfig();
    }
    public ConfigurationSection getSocials(){
        return configurazione.getConfigurationSection("socials");
    }
    public List<String> getMessages(String social){
        return configurazione.getStringList(social);
    }
}
