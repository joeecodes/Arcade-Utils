package me.buryings.arcadeutils.commands.blockbreaker;

import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerManager;
import me.buryings.arcadeutils.managers.gamemanagers.enums.BlockBreakerGameState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class BlockBreakerListener implements Listener {

    private ArcadeUtils main;

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) throws IOException {
        Player p = e.getPlayer();

        if (BlockBreakerManager.isPlaying(p) && BlockBreakerManager.getArena(p).getState().equals(BlockBreakerGameState.PLAYING)) {
            p.sendMessage(ChatColor.GREEN + "");
            BlockBreakerManager.getArena(p).BlockBreaker().addPoint(p);

        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) throws IOException {

        Player p = e.getPlayer();

        if (BlockBreakerManager.isPlaying(p)) {
            BlockBreakerManager.getArena(p).removePlayer(p);
        }
    }

}
