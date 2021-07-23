package me.buryings.arcadeutils.managers.gamemanagers;

import lombok.Data;
import me.buryings.arcadeutils.managers.gamemanagers.enums.BlockBreakerGameState;
import me.buryings.arcadeutils.managers.gamemanagers.games.BlockBreaker;
import me.buryings.arcadeutils.managers.gamemanagers.games.BlockBreakerCountdown;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@Data
public class BlockBreakerArenas {

    private int id;
    private ArrayList<UUID> players;
    private Location spawn;
    private BlockBreaker game;
    private BlockBreakerGameState state;
    private BlockBreakerCountdown countdown;

    public BlockBreakerArenas(int id) {
        this.id = id;
        players = new ArrayList<>();
        spawn = BlockBreakerConfig.getArenaSpawn(id);
        state = BlockBreakerGameState.WAITING;
        countdown = new BlockBreakerCountdown(this);
        game = new BlockBreaker(this);

    }

    // TODO: add somewhere
    public void addPlayer(Player player) throws IOException {
        players.add(player.getUniqueId());
        player.teleport(spawn);

        if (players.size() >= BlockBreakerConfig.getRequiredPlayers())
            countdown.begin();


    }

    public void start() {
        game.start();
    }

    public void reset() {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).teleport(BlockBreakerConfig.getLobbySpawn());
        }

        state = BlockBreakerGameState.WAITING;
        players.clear();
        countdown = new BlockBreakerCountdown(this);
        game = new BlockBreaker(this);

    }

    public void sendMessage(String message) {
        for (UUID uuid : players) {
            Bukkit.getPlayer(uuid).sendMessage(message);
        }
    }

    public void removePlayer(Player player) throws IOException {
        players.remove(player.getUniqueId());
        player.teleport(BlockBreakerConfig.getLobbySpawn());

        if (players.size() <= BlockBreakerConfig.getRequiredPlayers()) {
            if (state.equals(BlockBreakerGameState.COUNTDOWN))
                reset();
        }
        if (players.size() == 0 && state.equals(BlockBreakerGameState.PLAYING))
            reset();
    }

}
