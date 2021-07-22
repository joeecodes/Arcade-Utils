package me.buryings.arcadeutils.commands.config;

import me.buryings.arcadeutils.ArcadeUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandReloadConfig implements CommandExecutor {

    private ArcadeUtils main;

    public CommandReloadConfig(ArcadeUtils main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {

        Player p = (Player) sender;
        if (p.hasPermission("arcadeutils.reload")) {
            if (command.getName().equalsIgnoreCase("arcadereload")) {
                main.reloadConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("plugin-settings.config-reloaded")
                        .replace("%prefix%", main.getConfig().getString("plugin-settings.plugin-prefix"))));
            } else {
                if (!(p.hasPermission("arcadeutils.reload"))) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("plugin-settings.plugin-prefix"))
                            + ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("plugin-settings.no-permission")));
                }
            }

            return false;
        }
        return false;
    }
}
