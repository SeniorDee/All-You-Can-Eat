package seniordee.allyoucaneat.core.util;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.client.render.entity.BoatEntityRenderer;
import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.EntityTypesInit;
import seniordee.allyoucaneat.core.init.FluidInit;
import seniordee.allyoucaneat.core.init.ModelLayerInit;
import seniordee.allyoucaneat.core.init.TileEntitiesInit;
import seniordee.allyoucaneat.core.init.WoodTypesInit;
import seniordee.allyoucaneat.world.FoliageColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AllYouCanEat.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(FluidInit.SOURCE_RED_WINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_RED_WINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.SOURCE_WHITE_WINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidInit.FLOWING_WHITE_WINE.get(), RenderType.translucent());

        EntityRenderers.register(EntityTypesInit.BOAT_ENTITY.get(), context -> new BoatEntityRenderer(context, false));
        EntityRenderers.register(EntityTypesInit.CHEST_BOAT_ENTITY.get(), context -> new BoatEntityRenderer(context,
                true));

        WoodType.register(WoodTypesInit.HAZEL);
        WoodType.register(WoodTypesInit.FIG);

        event.enqueueWork(() -> {
            Sheets.addWoodType(WoodTypesInit.HAZEL);
            Sheets.addWoodType(WoodTypesInit.FIG);
        });
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayerInit.HAZEL_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModelLayerInit.HAZEL_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        event.registerLayerDefinition(ModelLayerInit.FIG_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModelLayerInit.FIG_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerTileEntityRenderers(RegisterRenderers event) {
        event.registerBlockEntityRenderer(TileEntitiesInit.SIGN_TILE_ENTITIES.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(TileEntitiesInit.HANGING_SIGN_TILE_ENTITIES.get(), HangingSignRenderer::new);
    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((p_92626_, tint, pos, p_92629_) -> {
            return tint != null && pos != null ? BiomeColors.getAverageFoliageColor(tint, pos) :
                    FoliageColor.getHazelColor();
        }, BlockInit.HAZEL_LEAVES.get());
        event.getBlockColors().register((p_92626_, tint, pos, p_92629_) -> {
            return tint != null && pos != null ? BiomeColors.getAverageFoliageColor(tint, pos) :
                    FoliageColor.getFigColor();
        }, BlockInit.FIG_LEAVES.get());
    }

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register(new HazelLeaveColor(), BlockInit.HAZEL_LEAVES.get().asItem());
        event.getItemColors().register(new FigLeaveColor(), BlockInit.FIG_LEAVES.get().asItem());
    }

    public static class HazelLeaveColor implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int color) {
            return FoliageColor.getHazelColor();
        }
    }

    public static class FigLeaveColor implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int color) {
            return FoliageColor.getFigColor();
        }
    }
}