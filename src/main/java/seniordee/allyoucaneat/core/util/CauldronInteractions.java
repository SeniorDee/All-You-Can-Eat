package seniordee.allyoucaneat.core.util;

import java.util.Map;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;

public interface CauldronInteractions extends CauldronInteraction {
    Map<Item, CauldronInteraction> MILK = newInteractionMap();
    Map<Item, CauldronInteraction> RED_WINE = newInteractionMap();
    Map<Item, CauldronInteraction> WHITE_WINE = newInteractionMap();

    static Object2ObjectOpenHashMap<Item, CauldronInteraction> newInteractionMap() {
        return Util.make(new Object2ObjectOpenHashMap<>(), (p_175646_) -> {
            p_175646_.defaultReturnValue((p_175739_, p_175740_, p_175741_, p_175742_, p_175743_, p_175744_) -> {
                return InteractionResult.PASS;
            });
        });
    }
}
