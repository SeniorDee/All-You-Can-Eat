package seniordee.allyoucaneat.datagen;

import com.google.common.collect.Maps;
import seniordee.allyoucaneat.core.init.BlockInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.stream.Stream;

public class BlockFamiliesGenerator extends BlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
    private static final String RECIPE_GROUP_PREFIX_WOODEN = "wooden";
    private static final String RECIPE_UNLOCKED_BY_HAS_PLANKS = "has_planks";

    public static final BlockFamily HAZEL_PLANKS =
            familyBuilder(BlockInit.HAZEL_PLANKS.get()).button(BlockInit.HAZEL_BUTTON.get())
            .fence(BlockInit.HAZEL_FENCE.get()).fenceGate(BlockInit.HAZEL_FENCE_GATE.get())
            .pressurePlate(BlockInit.HAZEL_PRESSURE_PLATE.get())
            .sign(BlockInit.HAZEL_SIGN.get(), BlockInit.HAZEL_WALL_SIGN.get()).slab(BlockInit.HAZEL_SLAB.get())
            .stairs(BlockInit.HAZEL_STAIRS.get()).door(BlockInit.HAZEL_DOOR.get())
            .trapdoor(BlockInit.HAZEL_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily FIG_PLANKS =
            familyBuilder(BlockInit.FIG_PLANKS.get()).button(BlockInit.FIG_BUTTON.get())
            .fence(BlockInit.FIG_FENCE.get()).fenceGate(BlockInit.FIG_FENCE_GATE.get())
            .pressurePlate(BlockInit.FIG_PRESSURE_PLATE.get())
            .sign(BlockInit.FIG_SIGN.get(), BlockInit.FIG_WALL_SIGN.get()).slab(BlockInit.FIG_SLAB.get())
            .stairs(BlockInit.FIG_STAIRS.get()).door(BlockInit.FIG_DOOR.get()).trapdoor(BlockInit.FIG_TRAPDOOR.get())
            .recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

    private static BlockFamily.Builder familyBuilder(Block pBaseBlock) {
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(pBaseBlock);
        BlockFamily blockfamily = MAP.put(pBaseBlock, blockfamily$builder.getFamily());

        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(pBaseBlock));
        } else {
            return blockfamily$builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
