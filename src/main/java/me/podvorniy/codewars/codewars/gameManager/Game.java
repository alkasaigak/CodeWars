package me.podvorniy.codewars.codewars.gameManager;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class Game {
    private String name;
    private int maxPlayerNumber;
    private int minPlayerNumber;
    private int maxPlayerPerTeam;
    private World world;
    private HashMap<Team, Location> spawns;
    private boolean isStart;
    private List<Player> players;
    private HashMap<Player, Team> playerToTeam;
    Game(String name) {
        this.name = name;

    }
}
