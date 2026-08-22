package kik.socially;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CmdExecutor extends Command {
    private final List<String> righe;

    public CmdExecutor(String name, List<String> righe) {
        super(name);
        this.righe = righe;
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        for (String riga : righe) {
            sender.sendMessage(riga);
        }
        return true;
    }
}
