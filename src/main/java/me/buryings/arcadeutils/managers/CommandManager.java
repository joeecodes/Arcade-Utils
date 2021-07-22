package me.buryings.arcadeutils.managers;

import me.buryings.arcadeutils.ArcadeUtils;
import me.buryings.arcadeutils.commands.CommandArcade;
import me.buryings.arcadeutils.commands.blockbreaker.CommandForceStart;
import me.buryings.arcadeutils.commands.config.CommandReloadConfig;

public class CommandManager {

    private ArcadeUtils main;

    // register and manage commands
    // DOESNT REALLY WORK BUT WILL GET TO IT SOON
    public void register() {

        new CommandArcade();
        new CommandForceStart();
        new CommandReloadConfig(this.main);
    }
}
