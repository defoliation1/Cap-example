package pers.defoliation.cap.example;

import engine.command.argument.FunctionSenderArgument;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import pers.defoliation.cap.CapCommandManager;
import pers.defoliation.cap.example.stage2.Commands;
import pers.defoliation.cap.example.stage2.Home;
import pers.defoliation.cap.example.stage2.HomeManager;

import java.util.Optional;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        CapCommandManager capCommandManager = new CapCommandManager(this);

        capCommandManager.getArgumentManager()
                .appendArgument(
                        FunctionSenderArgument.getBuilder(Home.class,"home")
                        .setSuggester((commandSender, s, strings) -> HomeManager.INSTANCE.getPlayerHomes((Player) commandSender))
                        .setParse((sender,argument) -> Optional.ofNullable(HomeManager.INSTANCE.getHome((Player) sender,argument)))
                        .get()
                );

        capCommandManager.getBuilder()
                .addCommandHandler(new Commands())
                .register();
    }
}
