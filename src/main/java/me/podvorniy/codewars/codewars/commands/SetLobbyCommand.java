package me.podvorniy.codewars.codewars.commands;

import me.podvorniy.codewars.codewars.CodeWars;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SetLobbyCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args, CodeWars plugin) {
        if (args.length != 1) {
            player.sendMessage("Please correct ur args");
            return;
        }
        String world_name = player.getWorld().getName().substring(4);
        List<Double> loc = new ArrayList<>();
        loc.add(player.getLocation().getX());
        loc.add(player.getLocation().getY());
        loc.add(player.getLocation().getZ());

        plugin.getConfig().set(world_name + "." + "lobbySpawn", loc);
        plugin.saveConfig();
        player.sendMessage(ChatColor.GREEN + "Lobby spawn set to " + String.valueOf(loc));
    }

    @Override
    public String name() {
        return "setLobby";
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

