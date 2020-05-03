package me.podvorniy.codewars.codewars;
import me.podvorniy.codewars.codewars.commands.CommandManager;
import me.podvorniy.codewars.codewars.gameManager.Game;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public final class CodeWars extends JavaPlugin {
    private static CodeWars instance;
    public CommandManager commandManager;
    @Override
    public void onEnable() {
        setInstance(this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        commandManager = new CommandManager();
        commandManager.setup();
    }

    @Override
    public void onDisable() {

    }
    public static CodeWars getInstance() {
        return instance;
    }

    private static void setInstance(CodeWars instance) {
        CodeWars.instance = instance;
    }
}
