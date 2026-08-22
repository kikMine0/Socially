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
            /// ora in realtà DOVREI fare tutta la conversione legacy -> adventure api -> legacy -> mi sbatto i coglioni su i pescepalla
            /// ma lo faccio per ultimo o lo copio dai miei progetti

        }
        return true;
    }
}
