package me.buryings.arcadeutils.managers;


import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.commands.blockbreaker.BlockBreakerListener;
import me.buryings.arcadeutils.managers.gamemanagers.games.BlockBreakerCountdown;
import org.bukkit.Bukkit;

public class ListenerManager {

    private ArcadeUtils main;
    private BlockBreakerCountdown countdown;

    // register and manage listeners
    public void register() {

        Bukkit.getPluginManager().registerEvents(new BlockBreakerListener(), this.main);


    }
}
