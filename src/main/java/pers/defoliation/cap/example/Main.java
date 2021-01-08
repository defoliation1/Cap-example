package pers.defoliation.cap.example;

import org.bukkit.plugin.java.JavaPlugin;
import pers.defoliation.cap.CapCommandManager;
import pers.defoliation.cap.example.stage1.Commands;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        CapCommandManager capCommandManager = new CapCommandManager(this);
        capCommandManager.getBuilder()
                .addCommandHandler(new Commands())
                .register();
    }
}
