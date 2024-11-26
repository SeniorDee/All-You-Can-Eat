package seniordee.allyoucaneat.world.features;

import java.util.List;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.core.init.BlockInit;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class PlacedFeaturesInit {
    public static final ResourceKey<PlacedFeature> HAZEL_PLACED_KEY = registerKey("hazel_placed");
    public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_BUSH_COMMON_PLACED_KEY = registerKey(
            "patch_strawberry_bush_common");
    public static final ResourceKey<PlacedFeature> PATCH_STRAWBERRY_BUSH_RARE_PLACED_KEY = registerKey(
            "patch_strawberry_bush_rare");
    public static final ResourceKey<PlacedFeature> FIG_PLACED_KEY = registerKey("fig_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HAZEL_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeaturesInit.HAZEL_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.01f, 2),
                        BlockInit.HAZEL_SAPLING.get()));

        register(context, PATCH_STRAWBERRY_BUSH_COMMON_PLACED_KEY,
                configuredFeatures.getOrThrow(ConfiguredFeaturesInit.STRAWBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()));

        register(context, PATCH_STRAWBERRY_BUSH_RARE_PLACED_KEY,
                configuredFeatures.getOrThrow(ConfiguredFeaturesInit.STRAWBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(384), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP,
                        BiomeFilter.biome()));

        register(context, FIG_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeaturesInit.FIG_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.01f, 2),
                        BlockInit.FIG_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AllYouCanEat.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
