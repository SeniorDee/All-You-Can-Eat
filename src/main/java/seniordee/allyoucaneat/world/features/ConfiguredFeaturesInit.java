package seniordee.allyoucaneat.world.features;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.core.init.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import seniordee.allyoucaneat.world.features.tree.custom.FigFoliagePlacer;
import seniordee.allyoucaneat.world.features.tree.custom.FigTrunkPlacer;

public class ConfiguredFeaturesInit {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAZEL_KEY = registerKey("hazel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH_KEY = registerKey("strawberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIG_KEY = registerKey("fig");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, HAZEL_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockInit.HAZEL_LOG.get()),
                        new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(BlockInit.HAZEL_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0
                        , 1)).ignoreVines()
                .build());

        register(context, FIG_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockInit.FIG_LOG.get()),
                        new FigTrunkPlacer(4, 2, 0), BlockStateProvider.simple(BlockInit.FIG_LEAVES.get()),
                        new FigFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0,
                        1)).ignoreVines()
                .build());

        register(context, STRAWBERRY_BUSH_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.STRAWBERRY_BUSH.get()
                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, Integer.valueOf(3)))))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AllYouCanEat.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
