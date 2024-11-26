package seniordee.allyoucaneat.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.blocks.WallSignBlock;
import seniordee.allyoucaneat.world.features.tree.custom.FigTrunkPlacer;

public class TrunkPlacerInit {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, AllYouCanEat.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<FigTrunkPlacer>> FIG_TRUNK_PLACER = TRUNK_PLACER.register(
            "fig_trunk_placer", () -> new TrunkPlacerType<>(FigTrunkPlacer.CODEC));
}
