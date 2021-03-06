package me.buryings.arcadeutils;

import me.buryings.arcadeutils.managers.CommandManager;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerConfig;
import me.buryings.arcadeutils.managers.gamemanagers.BlockBreakerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ArcadeUtils extends JavaPlugin {

    private static ArcadeUtils instance;

    public static ArcadeUtils getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {

        // config file load
        new BlockBreakerConfig(this);

        // Game Managers
        new BlockBreakerManager();

        // Instance
        instance = this;

        registerListeners();
        new CommandManager().register();

        // Using as config manager not working currently
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();

        Bukkit.getServer().getConsoleSender().sendMessage("Arcade has started!");

    }

    @Override
    public void onDisable() {

        Bukkit.getServer().getConsoleSender().sendMessage("Arcade has stopped!");
    }


    public void registerListeners() {
        // new ListenerManager().register();
    }


    // ARCADE MENU CREATION
    public void createMenu(Player player) {
        Inventory menu = Bukkit.getServer().createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&e&lARCADE MENU"));

        ItemStack item1 = new ItemStack(Material.BEACON);
        ItemMeta item1Meta = item1.getItemMeta();

        // BEACON ITEM
        ArrayList<String> item1Lore = new ArrayList<String>();

        item1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lARCADE MENU"));
        item1Lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        item1Lore.add(ChatColor.translateAlternateColorCodes('&', "&8>> &7Currently playing &eplay.arcade.net"));
        item1Lore.add(ChatColor.translateAlternateColorCodes('&', ""));
        item1Lore.add(ChatColor.translateAlternateColorCodes('&', "&fUse this menu to navigate to around the arcade!"));
        item1Meta.setLore(item1Lore);
        item1.setItemMeta(item1Meta);

        // BLOCK BREAKER GAME ITEM

        ArrayList<String> blockbreakerLore = new ArrayList<String>();

        ItemStack blockbreaker = new ItemStack(Material.STONE);
        ItemMeta blockbreakermeta = blockbreaker.getItemMeta();

        blockbreakermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBlock Breaker"));
        blockbreakerLore.add("");
        blockbreakerLore.add(ChatColor.translateAlternateColorCodes('&', "&f&nHow to play&r"));
        blockbreakerLore.add("");
        blockbreakerLore.add(ChatColor.translateAlternateColorCodes('&', "&7Mine as many blocks as you  within"));
        blockbreakerLore.add(ChatColor.translateAlternateColorCodes('&', "&7the set time limit of 2 minutes in order to win."));
        blockbreakerLore.add(ChatColor.translateAlternateColorCodes('&', ""));

        blockbreakermeta.setLore(blockbreakerLore);
        blockbreaker.setItemMeta(blockbreakermeta);

        menu.setItem(0, item1);
        menu.setItem(1, blockbreaker);

        player.openInventory(menu);
        // MENU CREATION ENDS HERE
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if (p.hasPermission("arcadeutils.menu")) {
            if (command.getName().equalsIgnoreCase("menu")) {
                createMenu(p);
            }
        }

        // CONFIG RELOAD
        if (p.hasPermission("arcadeutils.reload")) {
            if (command.getName().equalsIgnoreCase("arcadereload")) {
                this.reloadConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin-settings.plugin-prefix"))
                        + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin-settings.config-reloaded")
                        .replace("%prefix%", this.getConfig().getString("plugin-settings.plugin-prefix"))));
            } else {
                if (!(p.hasPermission("arcadeutils.reload"))) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin-settings.plugin-prefix"))
                            + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("plugin-settings.no-permission")));
                }
            }

            return false;
        }
        return false;
    }
}
