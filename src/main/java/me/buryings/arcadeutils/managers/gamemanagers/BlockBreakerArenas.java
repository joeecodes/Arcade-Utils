package me.buryings.arcadeutils.managers.gamemanagers;

import me.buryings.arcadeutils.managers.gamemanagers.enums.BlockBreakerGameState;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BlockBreakerArenas {

    private int id;
    private ArrayList<UUID> players;
    private Location spawn;
    private BlockBreakerGameState state;

    public BlockBreakerArenas(int id) {
        this.id = id;
        players = new ArrayList<>();
        spawn = BlockBreakerConfig.getArenaSpawn(id);
        state = BlockBreakerGameState.WAITING;

    }
    public void addPlayer(Player player) {
        players.add(player.getUniqueId());
        player.teleport(spawn);
    }
    public void removePlayer(Player player) {
        players.remove(player.getUniqueId());
        player.teleport(BlockBreakerConfig.getLobbySpawn());
    }
    public int getID() {
        return id;
    }
    public List<UUID> getPlayers() {
        return players;
    }
    public BlockBreakerGameState getState() {
        return state;
    }
}
