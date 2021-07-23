package me.buryings.arcadeutils.commands;

import club.deltapvp.deltacore.api.commands.ICommand;
import club.deltapvp.deltacore.api.commands.annotation.CommandInfo;
import club.deltapvp.deltacore.api.utilities.Message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//public class CommandArcade implements CommandExecutor {
//
//
//    @Override
//    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
//        Player p = (Player) sender;
//
//        // command: /arcade - listing version of plugin and creator(s)
//        if (p.hasPermission("arcadeutils.arcade")) {
//            if (command.getName().equalsIgnoreCase("arcade"))
//                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
//        }
//
//        return false;
//    }
//}
@CommandInfo(name = "arcade", permission = "arcadeutils.arcade", playerOnly = true)
public class CommandArcade extends ICommand{

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        new Message("&e&lARCADE &8> &7Version 1.1.5 &8- &fCreated by Buryings").send(sender);
    }
}
