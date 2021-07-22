package me.buryings.arcadeutils.commands.blockbreaker;

import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerArenas;
import me.buryings.arcadeutils.managers.gamemanagers.games.BlockBreakerCountdown;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandForceStart implements CommandExecutor {

    private ArcadeUtils main;
    private BlockBreakerArenas arenas;
    private BlockBreakerCountdown countdown;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        if (p.hasPermission("arcadeutils.admin.forcestart")) {
            if (command.getName().equalsIgnoreCase("forcestart")) {
                arenas.start();
                p.sendMessage(main.getConfig().getString("blockbreaker-config.game-forcestart-messages.force-start")
                        .replace("%prefix%", main.getConfig().getString("plugin-settings.plugin-prefix")));
            }
        } else {
            if (!(p.hasPermission("arcadeutils.admin.forcestart"))) {
                main.getConfig().getString("plugin-settings.no-permission").replace("%prefix%", main.getConfig().getString("plugin-settings.plugin-prefix"));

            }
        }

        return false;
    }
}
