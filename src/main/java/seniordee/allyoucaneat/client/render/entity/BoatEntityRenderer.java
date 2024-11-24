package seniordee.allyoucaneat.client.render.entity;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.entities.vehicle.BoatEntity;
import seniordee.allyoucaneat.common.entities.vehicle.ChestBoatEntity;

import java.util.Map;
import java.util.stream.Stream;

public class BoatEntityRenderer extends BoatRenderer {
	private final Map<BoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

	public BoatEntityRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
		super(pContext, pChestBoat);
		this.boatResources = Stream.of(BoatEntity.Type.values())
				.collect(ImmutableMap.toImmutableMap(type -> type,
						type -> Pair.of(new ResourceLocation(AllYouCanEat.MOD_ID, getTextureLocation(type, pChestBoat)),
								this.createBoatModel(pContext, type, pChestBoat))));
	}

	private static String getTextureLocation(BoatEntity.Type pType, boolean pChestBoat) {
		return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png"
				: "textures/entity/boat/" + pType.getName() + ".png";
	}

	private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, BoatEntity.Type pType,
			boolean pChestBoat) {
		ModelLayerLocation modellayerlocation = pChestBoat ? BoatEntityRenderer.createChestBoatModelName(pType)
				: BoatEntityRenderer.createBoatModelName(pType);
		ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
		return pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
	}

	public static ModelLayerLocation createBoatModelName(BoatEntity.Type pType) {
		return createLocation("boat/" + pType.getName(), "main");
	}

	public static ModelLayerLocation createChestBoatModelName(BoatEntity.Type pType) {
		return createLocation("chest_boat/" + pType.getName(), "main");
	}

	private static ModelLayerLocation createLocation(String pPath, String pModel) {
		return new ModelLayerLocation(new ResourceLocation(AllYouCanEat.MOD_ID, pPath), pModel);
	}

	public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
		if (boat instanceof BoatEntity modBoat) {
			return this.boatResources.get(modBoat.getModVariant());
		} else if (boat instanceof ChestBoatEntity chestBoatEntity) {
			return this.boatResources.get(chestBoatEntity.getModVariant());
		} else {
			return null;
		}
	}
}