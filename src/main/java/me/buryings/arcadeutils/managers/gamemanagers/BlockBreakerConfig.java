package me.buryings.arcadeutils.managers.gamemanagers;

import me.buryings.arcadeutils.ArcadeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.IOException;

public class BlockBreakerConfig {

    private static ArcadeUtils main;

    public BlockBreakerConfig(ArcadeUtils main) {
        BlockBreakerConfig.main = main;

    }

    public static int getRequiredPlayers() throws IOException {
        return main.getConfig().getInt("blockbreaker-config.required-players");
    }

    public static int getCoundownSeconds() {
        return main.getConfig().getInt("blockbreaker-config.countdown-seconds");
    }

    public static Location getLobbySpawn() {
        return new Location(Bukkit.getWorld(main.getConfig().getString("blockbreaker-config.lobby.spawn.world")),
                main.getConfig().getDouble("blockbreaker-config.lobby-spawn.x"),
                main.getConfig().getDouble("blockbreaker-config.lobby-spawn.y"),
                main.getConfig().getDouble("blockbreaker-config.lobby-spawn.z"),
                main.getConfig().getInt("pitch"),
                main.getConfig().getInt("yaw"));
    }

    public static Location getArenaSpawn(int id) {
        return new Location(Bukkit.getWorld(main.getConfig().getString("blockbreaker-config" + id + ".world")),
                main.getConfig().getDouble("blockbreaker-config" + id + ".x"),
                main.getConfig().getDouble("blockbreaker-config" + id + ".y"),
                main.getConfig().getDouble("blockbreaker-config" + id + ".z"),
                main.getConfig().getInt("blockbreaker-config" + id + ".pitch"),
                main.getConfig().getInt("blockbreaker-config" + id + ".yaw"));
    }
    public static int getArenaAmount() {
        return main.getConfig().getConfigurationSection("blockbreaker-config.arenas.").getKeys(false).size();
    }
}
