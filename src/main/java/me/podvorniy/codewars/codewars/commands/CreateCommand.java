package me.podvorniy.codewars.codewars.commands;

import me.podvorniy.codewars.codewars.CodeWars;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.util.List;
import java.util.Random;

public class CreateCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args, CodeWars plugin) {
        if (args.length == 1) {
            player.sendMessage("Please write map name");
            return;
        }
        System.out.println(args[1]);
        String world_name = "map_" + args[1];
        String command = "mv create " + world_name + " NORMAL -g VoidGenerator:THE_VOID -t FLAT";
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        player.sendMessage("New map created");
        List<String> worlds = plugin.getConfig().getStringList("worlds");
        worlds.add("map_" + args[1]);
        plugin.getConfig().set("worlds", worlds);
        plugin.saveConfig();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv tp " + player.getName() + " map_" + args[1]);
    }

    @Override
    public String name() {
        return "create";
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
