package io.github.itamardenkberg.allyoucaneat.core.init;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModelLayerInit {
	public static final ModelLayerLocation HAZEL_BOAT_LAYER = new ModelLayerLocation(
			new ResourceLocation(AllYouCanEat.MOD_ID, "boat/hazel"), "main");
	public static final ModelLayerLocation HAZEL_CHEST_BOAT_LAYER = new ModelLayerLocation(
			new ResourceLocation(AllYouCanEat.MOD_ID, "chest_boat/hazel"), "main");
}
