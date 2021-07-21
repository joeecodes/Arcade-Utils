package me.buryings.arcadeutils;

import me.buryings.arcadeutils.managers.CommandManager;
import me.buryings.arcadeutils.managers.ConfigManager;
import org.bukkit.*;
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
        new ConfigManager();

        // Instance
        ArcadeUtils.instance = this;

        registerCommands();
        registerListeners();
        new CommandManager().register();

        Bukkit.getServer().getConsoleSender().sendMessage("Arcade has started!");

    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("Arcade has stopped!");
    }
    public void registerCommands() {
        new CommandManager().register();
    }
    public void registerListeners() {
        // new ListenerManager().register();
    }


    // ARCADE MENU CREATION
    public void createMenu(Player player) {
        Inventory menu = Bukkit.getServer().createInventory(null, 9, ChatColor.translateAlternateColorCodes('&',"&e&lARCADE MENU"));

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
        return false;
    }
}
