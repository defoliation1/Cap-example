package pers.defoliation.cap.example.stage1;

import engine.command.anno.Command;
import engine.command.anno.Sender;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {

    //命令发送者是玩家，且输入了位置的情况
    @Command("tp")
    public void tp(@Sender Player tpPlayer, Location location) {
        tpPlayer.teleport(location);
    }

    //命令发送者是玩家，且输入了其他玩家的情况
    @Command("tp")
    public void tp(@Sender Player tpPlayer, Player player) {
        tpPlayer.teleport(player);
    }

    //命令发送者是控制台，且输入被传送者和位置的情况
    @Command("tp")
    public void tp(@Sender CommandSender sender, Player player, Location location) {
        player.teleport(location);
    }

    //命令发送者是控制台，且输入被传送者和其他玩家的情况
    @Command("tp")
    public void tp(@Sender CommandSender sender, Player tpPlayer, Player player) {
        tpPlayer.teleport(player);
    }


}
