package seniordee.allyoucaneat.core.init;

import seniordee.allyoucaneat.AllYouCanEat;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModelLayerInit {
    public static final ModelLayerLocation HAZEL_BOAT_LAYER =
            new ModelLayerLocation(new ResourceLocation(AllYouCanEat.MOD_ID, "boat/hazel"), "main");
    public static final ModelLayerLocation HAZEL_CHEST_BOAT_LAYER =
            new ModelLayerLocation(new ResourceLocation(AllYouCanEat.MOD_ID, "chest_boat/hazel"), "main");
    public static final ModelLayerLocation FIG_BOAT_LAYER =
            new ModelLayerLocation(new ResourceLocation(AllYouCanEat.MOD_ID, "boat/fig"), "main");
    public static final ModelLayerLocation FIG_CHEST_BOAT_LAYER =
            new ModelLayerLocation(new ResourceLocation(AllYouCanEat.MOD_ID, "chest_boat/fig"), "main");
}
