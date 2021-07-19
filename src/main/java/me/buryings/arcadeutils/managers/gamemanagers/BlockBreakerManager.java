package me.buryings.arcadeutils.managers.gamemanagers;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BlockBreakerManager {

    private static ArrayList<BlockBreakerArenas> arenas;

    public BlockBreakerManager() {
        arenas = new ArrayList<>();

        for (int i = 0; 1 <= (BlockBreakerConfig.getArenaAmount() - 1); i++) {
            arenas.add(new BlockBreakerArenas(i));
        }
    }

    public static List<BlockBreakerArenas> getArenas() {
        return arenas;
    }

    public boolean isPlaying(Player player) {
        for (BlockBreakerArenas arena : arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {

                return true;
            }
        }
        return false;
    }

    public BlockBreakerArenas getArena(Player player) {
        for (BlockBreakerArenas arena : arenas) {
            if (arena.getPlayers().contains(player.getUniqueId())) {
                return arena;
            }
        }
        return null;
    }
    public BlockBreakerArenas getArena(int id) {
        for (BlockBreakerArenas arena : arenas) {
            if (arena.getID() == id) {
                return arena;
            }
        }
        return null;
    }
}
