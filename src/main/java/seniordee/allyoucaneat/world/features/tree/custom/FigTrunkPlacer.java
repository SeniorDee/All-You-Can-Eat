package seniordee.allyoucaneat.world.features.tree.custom;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import seniordee.allyoucaneat.core.init.TrunkPlacerInit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FigTrunkPlacer extends TrunkPlacer {
    public static final Codec<FigTrunkPlacer> CODEC =
            RecordCodecBuilder.create(figTrunkPlacerInstance -> trunkPlacerParts(figTrunkPlacerInstance).apply(figTrunkPlacerInstance, FigTrunkPlacer::new));

    public FigTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return TrunkPlacerInit.FIG_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos,
            BlockState> blockSetter, RandomSource random, int pFreeTreeHeight, BlockPos pos, TreeConfiguration config) {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        List<FoliagePlacer.FoliageAttachment> foliageList = Lists.newArrayList();
        BlockPos.MutableBlockPos currentPos = new BlockPos.MutableBlockPos();

        int branchTypeChance = random.nextInt(100);

        if (branchTypeChance < 20) {
            placeCustomBranches(level, blockSetter, random, pos, config, currentPos);
        } else {
            placeRandomBranches(level, blockSetter, random, pos, config, foliageList, currentPos);
        }

        return foliageList;
    }

    private void placeCustomBranches(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
                                     RandomSource random, BlockPos pos, TreeConfiguration config,
                                     BlockPos.MutableBlockPos currentPos) {
        int x = pos.getX();
        int z = pos.getZ();
        int y = pos.getY();

        for (int i = 0; i < 4; ++i) {
            this.placeLog(level, blockSetter, random, currentPos.set(x, y + i, z), config);
        }

        blockSetter.accept(pos.above(3).relative(Direction.SOUTH, 1), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
        blockSetter.accept(pos.above(3).relative(Direction.NORTH, 1), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
        blockSetter.accept(pos.above(3).relative(Direction.NORTH, 2), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
        blockSetter.accept(pos.above(3).relative(Direction.WEST, 1), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
        blockSetter.accept(pos.above(3).relative(Direction.WEST, 2), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
        blockSetter.accept(pos.above(4).relative(Direction.WEST, 3), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
        blockSetter.accept(pos.above(3).relative(Direction.EAST, 1), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
        blockSetter.accept(pos.above(3).relative(Direction.EAST, 2), ((BlockState) Function.identity()
                .apply(config.trunkProvider.getState(random, pos)
                        .setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
    }

    private void placeRandomBranches(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
                                     RandomSource random, BlockPos pos, TreeConfiguration config,
                                     List<FoliagePlacer.FoliageAttachment> foliageList,
                                     BlockPos.MutableBlockPos currentPos) {
        int x = pos.getX();
        int z = pos.getZ();
        int y = pos.getY();

        for (int i = 0; i < 4; ++i) {
            if (this.placeLog(level, blockSetter, random, currentPos.set(x, y + i, z), config)) {
                if (i == 3) {
                    foliageList.add(new FoliagePlacer.FoliageAttachment(currentPos.above(4), 0, false));
                }
            }
        }

        int branchCount;
        int branchRoll = random.nextInt(100);

        if (branchRoll < 70) {
            branchCount = 3;
        } else if (branchRoll < 90) {
            branchCount = 4;
        } else {
            branchCount = 2;
        }

        Set<Direction> usedDirections = new HashSet<>();

        for (int b = 0; b < branchCount; ++b) {
            Direction direction;

            do {
                direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
            } while (usedDirections.contains(direction));

            usedDirections.add(direction);

            int branchStartHeight = y + 2 + random.nextInt(2);
            int branchLength = 1 + random.nextInt(3);

            int branchX = x;
            int branchZ = z;

            for (int j = 0; j < branchLength; ++j) {
                branchX += direction.getStepX();
                branchZ += direction.getStepZ();

                int branchY = branchStartHeight + (j / 2);

                BlockState logState = config.trunkProvider.getState(random, currentPos)
                        .setValue(RotatedPillarBlock.AXIS, direction.getAxis());

                if (this.placeLog(level, (pos1, state) -> blockSetter.accept(pos1, logState), random,
                        currentPos.set(branchX, branchY, branchZ), config)) {
                    if (j == branchLength - 1) {
                        foliageList.add(new FoliagePlacer.FoliageAttachment(currentPos.above(4), 0, false));
                    }
                }
            }
        }
    }
}