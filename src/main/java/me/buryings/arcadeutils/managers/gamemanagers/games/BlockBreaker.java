package me.buryings.arcadeutils.managers.gamemanagers.games;

import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerArenas;
import me.buryings.arcadeutils.managers.gamemanagers.enums.BlockBreakerGameState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class BlockBreaker {

    private BlockBreakerArenas arena;
    private ArcadeUtils main;
    private HashMap<UUID, Integer> points;

    public BlockBreaker(BlockBreakerArenas arena) {
        this.arena = arena;
        this.points = new HashMap<>();
    }

    public void start() {
        arena.setState(BlockBreakerGameState.PLAYING);
        arena.sendMessage(ChatColor.translateAlternateColorCodes('&', String.valueOf(main.getConfig().getStringList("blockbreaker-config.countdown-messages.game-start-message"))));

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
        }
    }
    // 1 Stone Block = 1 point
    public void addPoint(Player player) throws IOException {
        int point = points.get(player.getUniqueId()) + 1;
        if (point == 500) {
            arena.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("blockbreaker-config.winning-player-message")
                    .replace("%player%", player.getName())));

            arena.reset();
            return;
        }
        points.replace(player.getUniqueId(), point);

    }

}
