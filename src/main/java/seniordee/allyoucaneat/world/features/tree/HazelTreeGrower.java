package seniordee.allyoucaneat.world.features.tree;

import javax.annotation.Nullable;

import seniordee.allyoucaneat.world.features.ConfiguredFeaturesInit;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class HazelTreeGrower extends AbstractTreeGrower {

	@Nullable
	@Override
	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
		return ConfiguredFeaturesInit.HAZEL_KEY;
	}
}
