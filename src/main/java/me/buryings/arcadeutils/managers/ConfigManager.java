package me.buryings.arcadeutils.managers;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import me.buryings.arcadeutils.ArcadeUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private static ConfigManager configmgr;
    private File blockbreaker;
    private YamlConfiguration modifyblockbreaker;

    public void ConfigManager(ArcadeUtils main) {

        // MAIN FILE CONFIGURATION
        main.getConfig().options().copyDefaults();
        main.saveDefaultConfig();
    }
}
/*
        // BLOCK BREAKER MINIGAME CONFIGURATION
        public YamlConfiguration getBlockBreaker () {
            return modifyblockbreaker;
        }

        public void loadConfigFiles () throws IOException {
            blockbreaker = new File(Bukkit.getServer().getPluginManager().getPlugin("Arcadeutils").getDataFolder(), "blockbreaker.yml");
            if (!blockbreaker.exists()) {
                blockbreaker.createNewFile();

                modifyblockbreaker = YamlConfiguration.loadConfiguration(blockbreaker);
            }
        }
    }
*/