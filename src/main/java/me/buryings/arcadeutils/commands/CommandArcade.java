package me.buryings.arcadeutils.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandArcade implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        // command: /arcade - listing version of plugin and creator(s)
        if (p.hasPermission("arcadeutils.arcade")) {
            if (command.getName().equalsIgnoreCase("arcade"))
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e&lARCADE &8> &7Version 1.1.5 &8- &fCreated by Buryings"));
        }

        return false;
    }
}
