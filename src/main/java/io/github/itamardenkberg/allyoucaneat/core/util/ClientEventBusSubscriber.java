package io.github.itamardenkberg.allyoucaneat.core.util;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.client.guis.GlassFurnaceScreen;
import io.github.itamardenkberg.allyoucaneat.client.render.entity.BoatEntityRenderer;
import io.github.itamardenkberg.allyoucaneat.core.init.BlockInit;
import io.github.itamardenkberg.allyoucaneat.core.init.EntityTypesInit;
import io.github.itamardenkberg.allyoucaneat.core.init.FluidInit;
import io.github.itamardenkberg.allyoucaneat.core.init.MenuTypesInit;
import io.github.itamardenkberg.allyoucaneat.core.init.WoodTypesInit;
import io.github.itamardenkberg.allyoucaneat.world.FoliageColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AllYouCanEat.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WINE_BOTTLE.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.RED_WINE_BOTTLE.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WHITE_WINE_BOTTLE.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.BLACK_GRAPE_CROP.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.WHITE_GRAPE_CROP.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.TOMATO_CROP.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.HAZEL_DOOR.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.HAZEL_TRAPDOOR.get(), RenderType.cutoutMipped());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.STRAWBERRY_BUSH.get(), RenderType.cutoutMipped());

		ItemBlockRenderTypes.setRenderLayer(BlockInit.HAZEL_SAPLING.get(), RenderType.cutout());
		ItemBlockRenderTypes.setRenderLayer(BlockInit.HAZEL_LEAVES.get(), RenderType.cutout());

		ItemBlockRenderTypes.setRenderLayer(FluidInit.RED_WINE_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidInit.RED_WINE_FLUID.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidInit.RED_WINE_FLOWING.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidInit.WHITE_WINE_BLOCK.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidInit.WHITE_WINE_FLUID.get(), RenderType.translucent());
		ItemBlockRenderTypes.setRenderLayer(FluidInit.WHITE_WINE_FLOWING.get(), RenderType.translucent());

		EntityRenderers.register(EntityTypesInit.BOAT_ENTITY.get(), BoatEntityRenderer::new);

		WoodType.register(WoodTypesInit.HAZEL);

		MenuScreens.register(MenuTypesInit.GLASS_FURNACE_MENU.get(), GlassFurnaceScreen::new);
	}

	@SubscribeEvent
	public static void registerBlockColors(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((p_92626_, tint, pos, p_92629_) -> {
			return tint != null && pos != null ? BiomeColors.getAverageFoliageColor(tint, pos)
					: FoliageColor.getHazelColor();
		}, BlockInit.HAZEL_LEAVES.get());
	}

	@SubscribeEvent
	public static void onItemColors(ColorHandlerEvent.Item event) {
		event.getItemColors().register(new HazelLeaveColor(), BlockInit.HAZEL_LEAVES.get().asItem());
	}

	public static class HazelLeaveColor implements ItemColor {

		@Override
		public int getColor(ItemStack stack, int color) {
			return FoliageColor.getHazelColor();
		}
	}
}