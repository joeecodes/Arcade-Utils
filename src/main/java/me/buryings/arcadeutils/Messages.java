package me.buryings.arcadeutils;

import club.deltapvp.deltacore.api.utilities.Message;
import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class Messages {

    public Message PLUGIN_PREFIX;
    public Message NO_PERMISSION;
    public Message BB_PREFIX;
    public Message BB_COUNTDOWN_WAITING;
    public Message BB_COUNTDOWN_10_SECONDS;
    public Message BB_COUNTDOWN_5_SECONDS;
    public Message BB_COUNTDOWN_3_SECONDS;
    public Message BB_COUNTDOWN_2_SECONDS;
    public Message BB_COUNTDOWN_1_SECONDS;
    private static ArcadeUtils main;
    public Messages(ArcadeUtils main) {
        Messages.main = main;

        // MAIN PLUGIN CONFIG SETTINGS
        PLUGIN_PREFIX = new Message(main.getConfig().getString("plugin-settings.prefix"));
        NO_PERMISSION = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "plugin-settings.no-permission")));
        // BLOCKBREAKER CONFIG SETTINGS
        BB_PREFIX = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.game-prefix")));
        BB_COUNTDOWN_WAITING = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.waiting-message")));
        BB_COUNTDOWN_10_SECONDS = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-10-seconds")));
        BB_COUNTDOWN_5_SECONDS = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-5-seconds")));
        BB_COUNTDOWN_3_SECONDS = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-3-seconds")));
        BB_COUNTDOWN_2_SECONDS = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-2-seconds")));
        BB_COUNTDOWN_1_SECONDS = new Message(main.getConfig().getString(ChatColor.translateAlternateColorCodes('&', "blockbreaker-config.countdown-messages.countdown-1-second")));


    }
}


