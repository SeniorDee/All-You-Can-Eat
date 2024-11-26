package seniordee.allyoucaneat.world;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.world.features.PlacedFeaturesInit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class BiomeModifiersInit {
    public static final ResourceKey<BiomeModifier> ADD_TREE_HAZEL = registerKey("add_tree_hazel");
    public static final ResourceKey<BiomeModifier> ADD_STRAWBERRY_BUSH_COMMON = registerKey(
            "add_strawberry_bush_common");
    public static final ResourceKey<BiomeModifier> ADD_STRAWBERRY_BUSH_RARE = registerKey("add_strawberry_bush_rare");
    public static final ResourceKey<BiomeModifier> ADD_TREE_FIG = registerKey("add_tree_fig");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        HolderSet<Biome> figBiomes = HolderSet.direct(List.of(biomes.getOrThrow(Biomes.FOREST),
                biomes.getOrThrow(Biomes.FLOWER_FOREST)));

        HolderSet<Biome> strawberryBiomes = HolderSet.direct(Stream.concat(biomes.getOrThrow(Tags.Biomes.IS_PLAINS)
                .stream(), biomes.getOrThrow(BiomeTags.IS_FOREST).stream()).toList());

        context.register(ADD_TREE_HAZEL,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                        HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesInit.HAZEL_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_STRAWBERRY_BUSH_COMMON,
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(strawberryBiomes,
                        HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesInit.PATCH_STRAWBERRY_BUSH_COMMON_PLACED_KEY)), GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_STRAWBERRY_BUSH_RARE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(strawberryBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesInit.PATCH_STRAWBERRY_BUSH_RARE_PLACED_KEY))
                , GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_FIG, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(figBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeaturesInit.FIG_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(AllYouCanEat.MOD_ID,
                name));
    }
}
