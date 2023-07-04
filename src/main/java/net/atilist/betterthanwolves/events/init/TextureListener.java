package net.atilist.betterthanwolves.events.init;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.modificationstation.stationapi.api.client.event.texture.TextureRegisterEvent;
import net.modificationstation.stationapi.api.client.texture.atlas.Atlases;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.registry.Identifier;
import net.modificationstation.stationapi.api.registry.ModID;
import net.modificationstation.stationapi.api.util.Null;

public class TextureListener {

    @Entrypoint.ModID
    public static final ModID MOD_ID = Null.get();

    @EventListener
    public void registerTextures(TextureRegisterEvent event) {
        ItemListener.hempSeeds.setTexture(Identifier.of(MOD_ID, "item/hemp_seeds"));
        ItemListener.hemp.setTexture(Identifier.of(MOD_ID, "item/hemp"));
        ItemListener.dung.setTexture(Identifier.of(MOD_ID, "item/dung"));

        HempCrop0 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop0")).index;
        HempCrop1 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop1")).index;
        HempCrop2 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop2")).index;
        HempCrop3 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop3")).index;
        HempCrop4 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop4")).index;
        HempCrop5 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop5")).index;
        HempCrop6 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop6")).index;
        HempCrop7 = Atlases.getTerrain().addTexture(Identifier.of(MOD_ID, "block/hemp_crop7")).index;
    }

    public static int
            HempCrop0,
            HempCrop1,
            HempCrop2,
            HempCrop3,
            HempCrop4,
            HempCrop5,
            HempCrop6,
            HempCrop7;
}
