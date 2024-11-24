package seniordee.allyoucaneat.core.init;

import seniordee.allyoucaneat.AllYouCanEat;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidInit {
	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
			AllYouCanEat.MOD_ID);

	// RED WINE
	public static final RegistryObject<FlowingFluid> SOURCE_RED_WINE = FLUIDS.register("red_wine_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.RED_WINE_FLUID_PROPERTIES));

	public static final RegistryObject<FlowingFluid> FLOWING_RED_WINE = FLUIDS.register("flowing_red_wine",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.RED_WINE_FLUID_PROPERTIES));

	public static final ForgeFlowingFluid.Properties RED_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
			FluidTypesInit.RED_WINE_FLUID_TYPE, SOURCE_RED_WINE, FLOWING_RED_WINE).slopeFindDistance(2)
			.levelDecreasePerBlock(2).block(BlockInit.RED_WINE_BLOCK).bucket(ItemInit.RED_WINE_BUCKET);

	// WHITE WINE
	public static final RegistryObject<FlowingFluid> SOURCE_WHITE_WINE = FLUIDS.register("white_wine_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.WHITE_WINE_FLUID_PROPERTIES));

	public static final RegistryObject<FlowingFluid> FLOWING_WHITE_WINE = FLUIDS.register("flowing_white_wine",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.WHITE_WINE_FLUID_PROPERTIES));

	public static final ForgeFlowingFluid.Properties WHITE_WINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
			FluidTypesInit.WHITE_WINE_FLUID_TYPE, SOURCE_WHITE_WINE, FLOWING_WHITE_WINE).slopeFindDistance(2)
			.levelDecreasePerBlock(2).block(BlockInit.WHITE_WINE_BLOCK).bucket(ItemInit.WHITE_WINE_BUCKET);
}
