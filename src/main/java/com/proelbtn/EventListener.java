package com.proelbtn;

import com.proelbtn.interfaces.Emitter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventListener implements Listener {
    Emitter emitter;

    EventListener(Emitter emitter) {
        this.emitter = emitter;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String name = event.getPlayer().getDisplayName();

        String message = name + " joined!";

        emitter.sendMessage(message);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String name = event.getPlayer().getDisplayName();

        String message = name + " quit!";

        emitter.sendMessage(message);
    }
}
