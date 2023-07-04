package net.atilist.betterthanwolves.events.init;

import net.atilist.betterthanwolves.blocks.HempCrop;
import net.atilist.betterthanwolves.wrappers.ExampleBlockWithModel;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.BlockBase;
import net.minecraft.block.material.Material;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.template.block.TemplateBlockBase;
import net.modificationstation.stationapi.api.template.block.TemplatePlant;
import net.modificationstation.stationapi.api.util.Null;

public class BlockListener {

    public static TemplatePlant hempCrop;

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerBlocks(BlockRegistryEvent event) {
        hempCrop = new HempCrop(Identifier.of(MOD_ID, "hemp_crop"), 1);
    }
}
