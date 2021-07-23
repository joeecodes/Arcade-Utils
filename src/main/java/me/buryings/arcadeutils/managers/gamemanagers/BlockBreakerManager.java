package me.buryings.arcadeutils.managers.gamemanagers;

import me.buryings.arcadeutils.managers.gamemanagers.enums.BlockBreakerGameState;
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


    public static boolean isPlaying(Player player) {
        BlockBreakerArenas e = arenas.stream().filter(blockBreakerArenas -> blockBreakerArenas.getPlayers().contains(player.getUniqueId())).findFirst().orElse(null);
        return e != null;
    }

    public static BlockBreakerArenas getArena(Player player) {
        BlockBreakerArenas e = arenas.stream().filter(blockBreakerArenas -> blockBreakerArenas.getPlayers().contains(player.getUniqueId())).findFirst().orElse(null);
        return e;
    }

    public static BlockBreakerArenas getArenaId(int id) {
        BlockBreakerArenas e = arenas.stream().filter(blockBreakerArenas -> blockBreakerArenas.getId() == id).findFirst().orElse(null);
        return e;
    }

    public static boolean isRecruiting(int id) {
        return getArenaId(id).getState() == BlockBreakerGameState.WAITING;
    }

}
