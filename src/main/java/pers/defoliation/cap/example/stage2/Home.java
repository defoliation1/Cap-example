package pers.defoliation.cap.example.stage2;

import org.bukkit.Location;

public class Home {

    private String ownerName;

    private String homeName;

    private Location location;

    public Home(String ownerName, String homeName, Location location) {
        this.ownerName = ownerName;
        this.homeName = homeName;
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
