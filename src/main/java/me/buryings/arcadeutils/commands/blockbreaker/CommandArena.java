package me.buryings.arcadeutils.commands.blockbreaker;

import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerArenas;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerConfig;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CommandArena implements CommandExecutor {

    /*
    NOTE (22/07/2021): Need to fix this class, specifically /arena leave is broken
     */

    private ArcadeUtils main;
    private BlockBreakerManager manager;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 1 && args[0].equalsIgnoreCase("list")) {
                p.sendMessage(ChatColor.GRAY + "Available arenas:");
                for (BlockBreakerArenas arena : BlockBreakerManager.getArenas()) {
                    p.sendMessage(ChatColor.GREEN + "- " + ChatColor.WHITE + " " + arena.getID());
                }
            } else if (args.length == 1 && args[0].equalsIgnoreCase("leave")) {
                if (BlockBreakerManager.isPlaying(p)) {
                    // WORK ON THIS ->> BlockBreakerManager.getArena(p).removePlayer();
                    p.sendMessage(ChatColor.GREEN + "You left the arena.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid arena id! See /arena list for availabe arenas.");
            }

        } else if (args.length == 2 && args[0].equalsIgnoreCase("join")) {
            try {
                int id = Integer.parseInt(args[1]);

                if (id >= 0 && id <= (BlockBreakerConfig.getArenaAmount() - 1)) {
                    Player p = (Player) sender;

                    if (BlockBreakerManager.isRecruiting(id)) {
                        BlockBreakerManager.getArenaId(id).addPlayer(p);

                        p.sendMessage(main.getConfig().getString("blockbreaker-config.playing-arena" + " " + ChatColor.WHITE + id));
                    } else {
                        p.sendMessage(ChatColor.RED + "This game is already in play! Try joining another one!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "Invalid arena id! See /arena list for availabe arenas.");
                }
            } catch (NumberFormatException | IOException x) {
                sender.sendMessage(ChatColor.RED + "Invalid arena id! See /arena list for availabe arenas.");
            }

        } else {
            sender.sendMessage(ChatColor.RED + "Invalid usage - Use the following options:");
            sender.sendMessage(ChatColor.RED + "/arena list");
            sender.sendMessage(ChatColor.RED + "/arena join [Arena id]");
            sender.sendMessage(ChatColor.RED + "/arena leave");
        }

        return false;
    }
}
   /* } else
            System.out.println("You cant use this command from console!");
        }
*/