package me.buryings.arcadeutils.managers;

import me.buryings.arcadeutils.commands.CommandArcade;
import me.buryings.arcadeutils.commands.config.CommandReloadConfig;

public class CommandManager {

    // register and manage commands
    public void register() {

        new CommandArcade();
        new CommandReloadConfig();
    }
}
