package net.atilist.betterthanwolves.events.init;

import net.atilist.betterthanwolves.items.HempSeeds;
import net.atilist.betterthanwolves.items.LazyItemTemplate;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.ItemBase;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.item.TemplateItemBase;
import net.modificationstation.stationapi.api.util.Null;

public class ItemListener {

    public static LazyItemTemplate
            hempSeeds,
            hemp,

            dung;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerItems(ItemRegistryEvent event) {
        hempSeeds = new HempSeeds(Identifier.of(MOD_ID, "hemp_seeds"));
        hemp = new LazyItemTemplate(Identifier.of(MOD_ID, "hemp"));

        dung = new LazyItemTemplate(Identifier.of(MOD_ID, "dung"));
    }
}
