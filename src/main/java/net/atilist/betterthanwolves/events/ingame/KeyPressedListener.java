package net.atilist.betterthanwolves.events.ingame;

import net.atilist.betterthanwolves.events.init.KeyBindingListener;
import net.fabricmc.loader.api.FabricLoader;
import net.atilist.betterthanwolves.events.init.AchievementListener;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import org.lwjgl.input.Keyboard;

public class KeyPressedListener {

    @EventListener
    public void keyPressed(KeyStateChangedEvent event) {
    }
}
