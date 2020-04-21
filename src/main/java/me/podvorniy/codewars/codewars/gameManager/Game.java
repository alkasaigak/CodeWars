package me.podvorniy.codewars.codewars.gameManager;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;


public class Game {
    private Plugin plugin;

    private String name;
    private int maxPlayerNumber;
    private int minPlayerNumber;
    private int maxPlayerPerTeam;
    private World world;
    private Location lobbySpawn;
    private List<Team> teams;
    private GameState gameState = GameState.LOBBY;
    private List<Player> players;
    private Map<Player, Team> playerToTeam = new HashMap<>();
    private UUID id;
    Game(String name, UUID id, Plugin plugin) {
        this.name = name;
        this.id = id;
        this.world = (new WorldCreator(name + id.toString())).createWorld();
        this.plugin = plugin;
        this.maxPlayerNumber = this.plugin.getConfig().getInt(name + ".maxPlayerNumber");
        this.minPlayerNumber = this.plugin.getConfig().getInt(name + ".minPlayerNumber");
        this.maxPlayerPerTeam = this.plugin.getConfig().getInt(name + ".maxPlayerPerTeam");
        List<Double> loc = this.plugin.getConfig().getDoubleList(name + ".lobbySpawn");
        this.lobbySpawn = new Location(this.world, loc.get(0), loc.get(1), loc.get(2));
        this.gameState = GameState.LOBBY;
        this.players = new ArrayList<>();
        IntStream.range(0, maxPlayerNumber / maxPlayerPerTeam).forEachOrdered(n -> {
            List<Double> locS = this.plugin.getConfig().getDoubleList(name + ".teamSpawn." + String.valueOf(n));
            teams.add(new Team(n, new Location(this.world, locS.get(0), locS.get(1), locS.get(2))));
        });
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.teleport(lobbySpawn);
        player.setGameMode(GameMode.ADVENTURE);
        if (players.size() == minPlayerNumber) {
            gameState = GameState.STARTING;
            new BukkitRunnable() {
                @SuppressWarnings("deprication")
                @Override
                public void run() {
                    setState(GameState.ACTIVE);
                }
            }.runTaskLater(plugin, 60);
        }
        for (Team team : teams) {
            if (team.size != maxPlayerPerTeam) {
                team.addPlayer(player);
                playerToTeam.put(player, team);
                break;
            }
        }
    }
    public boolean deleteWorld(File path) {
        if(path.exists()) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteWorld(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return(path.delete());
    }
    private void setState(GameState state) {
        if (state == GameState.ACTIVE) {

        }
        gameState = state;
    }
    public enum GameState {
        LOBBY, STARTING, ACTIVE;
    }
}
