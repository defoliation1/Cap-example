package pers.defoliation.cap.example.stage2;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeManager {

    public static final HomeManager INSTANCE = new HomeManager();

    private HashMap<String, Home> playerDefaultHomeMap = new HashMap<>();

    private HashMap<String, HashMap<String, Home>> playerHomeMap = new HashMap<>();

    public Home getDefaultHome(Player player) {
        return playerDefaultHomeMap.get(player.getName());
    }

    public void setDefaultHome(Player player, Location location) {
        playerDefaultHomeMap.put(player.getName(), new Home(null, null, location));
    }

    public void addHome(Player player, Home home) {
        playerHomeMap.computeIfAbsent(player.getName(), k -> new HashMap<>()).put(home.getHomeName(), home);
    }

    public Home getHome(Player player, String homeName) {
        return playerHomeMap.computeIfAbsent(player.getName(), k -> new HashMap<>()).get(homeName);
    }

    public void removeHome(Player player, String homeName) {
        playerHomeMap.computeIfAbsent(player.getName(), k -> new HashMap<>()).remove(homeName);
    }

    public List<String> getPlayerHomes(Player player) {
        return new ArrayList<>(playerHomeMap.computeIfAbsent(player.getName(), k -> new HashMap<>()).keySet());
    }

}
