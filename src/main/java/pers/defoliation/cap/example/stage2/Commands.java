package pers.defoliation.cap.example.stage2;

import engine.command.anno.Command;
import engine.command.anno.Required;
import engine.command.anno.Sender;
import org.bukkit.entity.Player;

public class Commands {

    @Command("home")
    public void teleportDefaultHome(@Sender Player player) {
        Home defaultHome = HomeManager.INSTANCE.getDefaultHome(player);
        if (defaultHome != null)
            player.teleport(defaultHome.getLocation());
    }

    @Command("home")
    public void teleportHome(@Sender Player player, Home home) {
        player.teleport(home.getLocation());
    }

    @Command("home")
    public void setDefaultHome(@Sender Player player, @Required("setHome") String setHome) {
        HomeManager.INSTANCE.setDefaultHome(player, player.getLocation());
        player.sendMessage("设置成功");
    }

    @Command("home")
    public void setHome(@Sender Player player, @Required("setHome") String setHome, String homeName) {
        Home home = new Home(player.getName(), homeName, player.getLocation());
        if (!HomeManager.INSTANCE.getPlayerHomes(player).contains(homeName)) {
            HomeManager.INSTANCE.addHome(player, home);
            player.sendMessage("设置成功");
        } else {
            player.sendMessage("设置失败，名字重复");
        }
    }

}
