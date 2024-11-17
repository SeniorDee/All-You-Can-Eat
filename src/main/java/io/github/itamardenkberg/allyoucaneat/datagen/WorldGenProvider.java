package io.github.itamardenkberg.allyoucaneat.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.world.BiomeModifiersInit;
import io.github.itamardenkberg.allyoucaneat.world.features.ConfiguredFeaturesInit;
import io.github.itamardenkberg.allyoucaneat.world.features.PlacedFeaturesInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenProvider extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, ConfiguredFeaturesInit::bootstrap)
			.add(Registries.PLACED_FEATURE, PlacedFeaturesInit::bootstrap)
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiersInit::bootstrap);

	public WorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(AllYouCanEat.MOD_ID));
	}
}