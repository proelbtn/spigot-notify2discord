package com.proelbtn;

import com.proelbtn.interfaces.Emitter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void initialize(FileConfiguration config) {
        String webhook_uri = config.getString("uri");
        String name = config.getString("name");

        Emitter emitter = new DiscordEmitter(webhook_uri, name);
        Listener listener = new EventListener(emitter);

        getServer().getPluginManager().registerEvents(listener, this);
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        FileConfiguration config = this.getConfig();

        initialize(config);
    }

    @Override
    public void onDisable() {
    }
}
