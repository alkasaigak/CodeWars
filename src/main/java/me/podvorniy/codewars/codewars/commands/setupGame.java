package me.podvorniy.codewars.codewars.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setupGame implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (!player.isOp()) {
                player.sendMessage("Sorry, you are isnt admin");
                return true;
            }
            if (strings.length == 0) {
                player.sendMessage("CodeWars setup work properly");

            }
            return true;
        }
        return false;
    }
}
