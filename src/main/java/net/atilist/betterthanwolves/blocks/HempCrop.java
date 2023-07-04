package net.atilist.betterthanwolves.blocks;

import net.atilist.betterthanwolves.events.init.BlockListener;
import net.atilist.betterthanwolves.events.init.ItemListener;
import net.atilist.betterthanwolves.events.init.TextureListener;
import net.minecraft.block.BlockBase;
import net.minecraft.entity.Item;
import net.minecraft.item.ItemInstance;
import net.minecraft.level.Level;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.template.block.TemplatePlant;

import javax.swing.text.html.parser.Entity;
import java.util.Random;

public class HempCrop extends TemplatePlant {
    public HempCrop(Identifier identifier, int texture) {
        super(identifier, texture);
        setSounds(BlockBase.GRASS_SOUNDS);
        float f = 0.2F;
        setBoundingBox(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        setTicksRandomly(true);
    }

    @Override
    protected boolean canPlantOnTopOf(int i) {
        return i == BlockBase.FARMLAND.id || i == this.id;
    }

    @Override
    public int getDropCount(Random random) {
        return 0;
    }

    @Override
    public int getTextureForSide(int i, int j) {
        return switch (j) {
            case 0 -> TextureListener.HempCrop0;
            case 1 -> TextureListener.HempCrop1;
            case 2 -> TextureListener.HempCrop2;
            case 3 -> TextureListener.HempCrop3;
            case 4 -> TextureListener.HempCrop4;
            case 5 -> TextureListener.HempCrop5;
            case 6 -> TextureListener.HempCrop6;
            case 7 -> TextureListener.HempCrop7;
            default -> super.getTextureForSide(i, j);
        };
    }

    @Override
    public void onScheduledTick(Level level, int x, int y, int z, Random random) {
        super.onScheduledTick(level, x, y, z, random);
        if (!(level.getLightLevel(x, y, z) >= 15 || level.getLightLevel(x, y + 1, z) >= 15 || level.getLightLevel(x, y + 2, z) >= 15)) return;
        if (level.getTileId(x, y - 1, z) != BlockBase.FARMLAND.id) return;
        int selfMeta = level.getTileMeta(x, y, z);
        if (selfMeta < 7) level.placeBlockWithMetaData(x, y, z, this.id, selfMeta + 1);
        else if (level.getTileId(x, y + 1, z) == 0) level.placeBlockWithMetaData(x, y + 1, z, BlockListener.hempCrop.id, 7);
    }

    @Override
    public void dropWithChance(Level level, int x, int y, int z, BlockState state, int meta, float chance) {
        if (meta == 7) {
            float f1 = 0.7F;
            float f2 = level.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
            float f3 = level.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
            float f4 = level.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
            Item entityItem = new Item(level, (float) x + f2, (float) y + f3, (float) z + f4, new ItemInstance(ItemListener.hemp));
            entityItem.pickupDelay = 10;
            level.spawnEntity(entityItem);
        }
        if (level.rand.nextBoolean()) return;
        float f1 = 0.7F;
        float f2 = level.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
        float f3 = level.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
        float f4 = level.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
        Item entityItem = new Item(level, (float)x + f2, (float)y + f3, (float)z + f4, new ItemInstance(ItemListener.hempSeeds));
        entityItem.pickupDelay = 10;
        level.spawnEntity(entityItem);

    }
}
