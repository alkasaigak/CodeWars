package me.podvorniy.codewars.codewars.listeners;

import me.podvorniy.codewars.codewars.CodeWars;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{
    private CodeWars plugin;
    public JoinListener(CodeWars plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }
}