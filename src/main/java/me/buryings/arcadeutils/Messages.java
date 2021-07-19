package me.buryings.arcadeutils;

import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerConfig;
import org.bukkit.ChatColor;

public class Messages {

    private static ArcadeUtils main;

    public Messages(ArcadeUtils main) {
        Messages.main = main;

        // MAIN PLUGIN CONFIG SETTINGS
        String PLUGIN_PREFIX = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "plugin-settings.prefix"));
        String NO_PERMISSION = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "plugin-settings.no-permission"));
        // BLOCKBREAKER CONFIG SETTINGS
        String BB_PREFIX = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.game-prefix"));
        String BB_COUNTDOWN_WAITING = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.waiting-message"));
        String BB_COUNTDOWN_10_SECONDS = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-10-seconds"));
        String BB_COUNTDOWN_5_SECONDS = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-5-seconds"));
        String BB_COUNTDOWN_3_SECONDS = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-3-seconds"));
        String BB_COUNTDOWN_2_SECONDS = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-2-seconds"));
        String BB_COUNTDOWN_1_SECONDS = main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-1-second"));


    }
}


