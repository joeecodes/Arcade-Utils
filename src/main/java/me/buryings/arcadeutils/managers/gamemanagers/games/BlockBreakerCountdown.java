package me.buryings.arcadeutils.managers.gamemanagers.games;

import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.managers.ConfigManager;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerArenas;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerConfig;
import me.buryings.arcadeutils.managers.gamemanagers.enums.BlockBreakerGameState;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;

public class BlockBreakerCountdown extends BukkitRunnable implements Listener {

    private BlockBreakerArenas arena;
    private ArcadeUtils main;
    private int seconds;

    public BlockBreakerCountdown(BlockBreakerArenas arenas) {
        this.arena = arena;
        this.seconds = BlockBreakerConfig.getCoundownSeconds();

    }

    public void begin() {
        arena.setState(BlockBreakerGameState.COUNTDOWN);
        this.runTaskTimer(ArcadeUtils.getInstance(), 0L, 120);
    }

    @Override
    public void run() {
        if (seconds == 0) {
            cancel();
            arena.start();
            return;
        }

        if (seconds % 120 == 0 || seconds <= 10) {
            if (seconds == 1) {
                arena.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("blockbreaker-config.countdown-messages.countdown-1-seconds")));
            } else {
                arena.sendMessage(ChatColor.translateAlternateColorCodes('&', ("&aGame will start in &2 " + seconds + " &aseconds!")));
            }
        }

        try {
            if (arena.getPlayers().size() < BlockBreakerConfig.getRequiredPlayers()) {
                cancel();
                arena.setState(BlockBreakerGameState.WAITING);
                arena.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("blockbreaker-config.countdown-messages.not-enough-players")));
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        seconds--;
    }
}
