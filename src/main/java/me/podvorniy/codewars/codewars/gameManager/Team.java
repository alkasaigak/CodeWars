package me.podvorniy.codewars.codewars.gameManager;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Team {
    private Color color;
    public int size;
    private int score;
    private Location spawn;
    private List<Player> players;
    private List<Color> colors = Arrays.asList(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE, Color.AQUA, Color.ORANGE);
    Team(int index, Location spawn) {
        this.color = colors.get(index);
        this.players = new ArrayList<>();
        this.spawn = spawn;
    }
    void addPlayer(Player p) {
        this.players.add(p);
        this.size++;
    }
}
