package seniordee.allyoucaneat.world.features.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import seniordee.allyoucaneat.core.init.FoliagePlacerInit;

public class FigFoliagePlacer extends FoliagePlacer {
    public static final Codec<FigFoliagePlacer> CODEC =
            RecordCodecBuilder.create(figFoliagePlacerInstance -> foliagePlacerParts(figFoliagePlacerInstance).and(Codec.intRange(0, 16)
            .fieldOf("height").forGetter(fp -> fp.height)).apply(figFoliagePlacerInstance, FigFoliagePlacer::new));

    private final int height;

    public FigFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return FoliagePlacerInit.FIG_FOLIAGE_PLACE.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random,
                                 TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment,
                                 int foliageHeight, int foliageRadius, int offset) {
        BlockPos position = attachment.pos();

        // Call the method to place all the leaves around the trunk and branches
        placeLeavesAroundBranches(level, blockSetter, random, position, config);
    }

    private void placeLeavesAroundBranches(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random
            , BlockPos pos, TreeConfiguration config) {
        
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange,
                                         boolean pLarge) {
        return false;
    }
}
