package seniordee.allyoucaneat.core.integrations.farmersdelight.init;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.blocks.FlammablePlankBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class FDBlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            AllYouCanEat.MOD_ID);

    public static final RegistryObject<Block> HAZEL_CABINET = BLOCKS.register("hazel_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(ModBlocks.OAK_CABINET.get())));

    public static final RegistryObject<Block> FIG_CABINET = BLOCKS.register("fig_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(ModBlocks.OAK_CABINET.get())));
}