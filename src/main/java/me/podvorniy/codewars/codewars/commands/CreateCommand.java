package me.podvorniy.codewars.codewars.commands;

import me.podvorniy.codewars.codewars.CodeWars;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import java.util.List;

public class CreateCommand extends SubCommand {
    @Override
    public void onCommand(Player player, String[] args, CodeWars plugin) {
        if (args.length == 0) {
            player.sendMessage("Please write map name");
        }
        World new_world = (new WorldCreator("map_" + args[0])).createWorld();
        player.teleport(new Location(new_world, 0, 0, 0));
        player.sendMessage("New map has benn created suceessfully");
        List<String> worlds = plugin.getConfig().getStringList("worlds");
        worlds.add(args[0]);
        plugin.getConfig().set("worlds", worlds);
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
