package io.github.itamardenkberg.allyoucaneat.core.init;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.common.entities.vehicle.BoatEntity;
import io.github.itamardenkberg.allyoucaneat.common.entities.vehicle.ChestBoatEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypesInit {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
			.create(ForgeRegistries.ENTITY_TYPES, AllYouCanEat.MOD_ID);

	public static final RegistryObject<EntityType<BoatEntity>> BOAT_ENTITY = ENTITY_TYPES.register("boat",
			() -> EntityType.Builder.<BoatEntity>of(BoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F)
					.build("boat"));

	public static final RegistryObject<EntityType<ChestBoatEntity>> CHEST_BOAT_ENTITY = ENTITY_TYPES
			.register("chest_boat", () -> EntityType.Builder.<ChestBoatEntity>of(ChestBoatEntity::new, MobCategory.MISC)
					.sized(1.375F, 0.5625F).build("chest_boat"));
}
