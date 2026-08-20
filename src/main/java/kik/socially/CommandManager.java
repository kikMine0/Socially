package kik.socially;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Plugin plugin;
    private final CommandMap commandMap;
    private final Map<String, Command> cmdregistrati = new HashMap<>();
    public CommandManager(Plugin plugin) {
        this.plugin = plugin;
        this.commandMap = Bukkit.getCommandMap();
    }
    public void registraCMDS(){

    }
}
