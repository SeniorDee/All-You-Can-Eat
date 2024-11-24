package seniordee.allyoucaneat.world;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.world.features.PlacedFeaturesInit;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeModifiersInit {
	public static final ResourceKey<BiomeModifier> ADD_TREE_HAZEL = registerKey("add_tree_hazel");
	public static final ResourceKey<BiomeModifier> ADD_STRAWBERRY_BUSH_COMMON = registerKey(
			"add_strawberry_bush_common");
	public static final ResourceKey<BiomeModifier> ADD_STRAWBERRY_BUSH_RARE = registerKey("add_strawberry_bush_rare");

	public static void bootstrap(BootstapContext<BiomeModifier> context) {
		var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		var biomes = context.lookup(Registries.BIOME);

		context.register(ADD_TREE_HAZEL,
				new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
						HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesInit.HAZEL_PLACED_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(ADD_STRAWBERRY_BUSH_COMMON,
				new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
						HolderSet.direct(
								placedFeatures.getOrThrow(PlacedFeaturesInit.PATCH_STRAWBERRY_BUSH_COMMON_PLACED_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION));

		context.register(ADD_STRAWBERRY_BUSH_RARE,
				new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
						HolderSet.direct(
								placedFeatures.getOrThrow(PlacedFeaturesInit.PATCH_STRAWBERRY_BUSH_RARE_PLACED_KEY)),
						GenerationStep.Decoration.VEGETAL_DECORATION));
	}

	private static ResourceKey<BiomeModifier> registerKey(String name) {
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
				new ResourceLocation(AllYouCanEat.MOD_ID, name));
	}
}
