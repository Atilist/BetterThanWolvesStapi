package net.atilist.betterthanwolves.items;

import net.atilist.betterthanwolves.events.init.BlockListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.animal.Wolf;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.registry.Identifier;

public class HempSeeds extends LazyItemTemplate {
    public HempSeeds(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean useOnTile(ItemInstance itemInstance, PlayerBase player, Level level, int x, int y, int z, int l) {
        Wolf wolf = new Wolf(level);
        wolf.setPosition(x, y + 1, z);
        level.spawnEntity(wolf);
        if (level.getTileId(x, y, z) != BlockBase.FARMLAND.id || level.getTileId(x, y + 1, z) != 0) return false;
        level.setTile(x, y + 1, z, BlockListener.hempCrop.id);
        itemInstance.count--;
        return true;
    }
}
