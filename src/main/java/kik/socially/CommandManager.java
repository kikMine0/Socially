package kik.socially;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    private final Plugin plugin;
    private final CommandMap commandMap;
    private final ConfigManager config;
    private final Map<String, Command> cmdregistrati = new HashMap<>();
    public CommandManager(Plugin plugin, ConfigManager config) {
        this.plugin = plugin;
        this.config = config;
        this.commandMap = Bukkit.getCommandMap();

    }
    public void registraCMDS(){
        ConfigurationSection entrate = config.getSocials();
        if (entrate == null) return;

        for (String comando : entrate.getKeys(false)){
            List<String> messaggi = config.getMessages(comando);
            CmdExecutor ccomando = new CmdExecutor(comando, messaggi);
            commandMap.register(plugin.getName().toLowerCase(), ccomando);
            cmdregistrati.put(comando,ccomando);

        }
        plugin.getLogger().info("Registrati " + cmdregistrati.size() + " social!");
    }
    @SuppressWarnings("unchecked")
    public void deregistraTutti(){
        if (cmdregistrati.isEmpty()) return;
        try{
            Field CAMPOcomandiconosciuti = SimpleCommandMap.class.getDeclaredField("knownCommands"); // prende tutti i comandi registrati nel server
            CAMPOcomandiconosciuti.setAccessible(true); // rende accessibile perché è protetto
            Map<String, Command> comandiConosciuti = (Map<String, Command>) CAMPOcomandiconosciuti.get(commandMap); // prendiamo solo i comandi registrati nostri
            for (Map.Entry<String, Command> comando : cmdregistrati.entrySet()){
                comando.getValue().unregister(commandMap); // deregistriamo il comando
                comandiConosciuti.remove(comando.getKey()); // togliamo
                comandiConosciuti.remove(plugin.getName().toLowerCase()+":"+comando.getKey()); // togliamo /socially:[social]
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public void reload() {
        deregistraTutti();
        plugin.reloadConfig();
        registraCMDS();

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.updateCommands();
        }
    }
}
