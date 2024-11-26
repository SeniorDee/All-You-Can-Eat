package seniordee.allyoucaneat.world.features.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import seniordee.allyoucaneat.world.features.ConfiguredFeaturesInit;

import javax.annotation.Nullable;

public class FigTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return ConfiguredFeaturesInit.FIG_KEY;
    }
}
