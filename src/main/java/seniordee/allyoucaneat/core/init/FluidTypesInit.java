package seniordee.allyoucaneat.core.init;

import org.joml.Vector3f;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.fluids.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FluidTypesInit {
	public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
	public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
	public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister
			.create(ForgeRegistries.Keys.FLUID_TYPES, AllYouCanEat.MOD_ID);

	public static final RegistryObject<FluidType> RED_WINE_FLUID_TYPE = register("red_wine_fluid", 0xF2821225, 94f, 13f,
			23f, FluidType.Properties.create());

	public static final RegistryObject<FluidType> WHITE_WINE_FLUID_TYPE = register("white_wine_fluid", 0xF2cfbd5b, 189f,
			168f, 83f, FluidType.Properties.create().lightLevel(2).density(15).viscosity(5));

	private static RegistryObject<FluidType> register(String name, int tint, float red, float green, float blue,
			FluidType.Properties properties) {
		return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
				tint, new Vector3f(red / 255f, green / 255f, blue / 255f), properties));
	}
}
