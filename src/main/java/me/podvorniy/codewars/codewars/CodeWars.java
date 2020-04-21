package me.podvorniy.codewars.codewars;
import me.podvorniy.codewars.codewars.commands.setupGame;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

public final class CodeWars extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("codewars").setExecutor(new setupGame());

    }

    @Override
    public void onDisable() {

    }

}
