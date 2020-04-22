package me.podvorniy.codewars.codewars.commands;

import me.podvorniy.codewars.codewars.CodeWars;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;

import java.util.List;
import java.util.Random;

public class SettingCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args, CodeWars plugin) {
        if (args.length != 4) {
            player.sendMessage("Please correct ur settings");
            return;
        }
        String world_name = player.getWorld().getName().substring(4);
        Integer min = Integer.valueOf(args[1]);
        Integer max = Integer.valueOf(args[1]);
        Integer perTeam = Integer.valueOf(args[1]);
        plugin.getConfig().set(world_name + "." + "minPlayerNumber", min);
        plugin.getConfig().set(world_name + "." + "maxPlayerNumber", max);
        plugin.getConfig().set(world_name + "." + "maxPlayerPerTeam", perTeam);
        plugin.saveConfig();
        player.sendMessage(ChatColor.GREEN + "Settings set to minPlayer:" + String.valueOf(min) +
                            ", maxPlayer" + String.valueOf(max) + ", playerPerTema:" + String.valueOf(perTeam));
    }

    @Override
    public String name() {
        return "setup";
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
