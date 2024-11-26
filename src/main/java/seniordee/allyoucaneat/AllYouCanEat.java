package seniordee.allyoucaneat;

import seniordee.allyoucaneat.core.init.*;
import seniordee.allyoucaneat.core.integrations.farmersdelight.init.FDBlockInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import seniordee.allyoucaneat.core.config.CommonConfig;
import seniordee.allyoucaneat.core.integrations.farmersdelight.init.FDItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AllYouCanEat.MOD_ID)
public class AllYouCanEat {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "allyoucaneat";

    public AllYouCanEat() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::addCreative);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        TileEntitiesInit.BLOCK_ENTITES.register(bus);
        EntityTypesInit.ENTITY_TYPES.register(bus);
        FluidInit.FLUIDS.register(bus);
        FluidTypesInit.FLUID_TYPES.register(bus);
        EffectsInit.EFFECT.register(bus);
        CreativeTabInit.CREATIVE_MODE_TABS.register(bus);
        TrunkPlacerInit.TRUNK_PLACER.register(bus);
        FoliagePlacerInit.FOLIAGE_PLACER.register(bus);

        if (ModList.get().isLoaded("farmersdelight")) {
            FDItemInit.ITEMS.register(bus);
            FDBlockInit.BLOCKS.register(bus);
        }

        ModLoadingContext.get().registerConfig(Type.COMMON, CommonConfig.SPEC, "ayce-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        ItemInit.addSeeds();

        event.enqueueWork(() -> {
            ItemInit.compostables();
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == CreativeTabInit.MAIN.get()) {
            event.accept(ItemInit.WINE_GLASS.get());
            event.accept(ItemInit.RED_WINE_GLASS.get());
            event.accept(ItemInit.WHITE_WINE_GLASS.get());
            event.accept(ItemInit.WINE_BOTTLE.get());
            event.accept(ItemInit.RED_WINE_BOTTLE.get());
            event.accept(ItemInit.WHITE_WINE_BOTTLE.get());
            event.accept(ItemInit.BLACK_GRAPE.get());
            event.accept(ItemInit.WHITE_GRAPE.get());
            event.accept(ItemInit.BLACK_GRAPE_SEEDS.get());
            event.accept(ItemInit.WHITE_GRAPE_SEEDS.get());
            event.accept(ItemInit.RED_WINE_BUCKET.get());
            event.accept(ItemInit.WHITE_WINE_BUCKET.get());
            event.accept(ItemInit.GELATIN.get());
            event.accept(ItemInit.MARSHMALLOW_ON_A_STICK.get());
            event.accept(ItemInit.ROASTED_MARSHMALLOW_ON_A_STICK.get());
            event.accept(ItemInit.HAZELNUT.get());
            event.accept(ItemInit.HAZEL_LOG.get());
            event.accept(ItemInit.STRIPPED_HAZEL_LOG.get());
            event.accept(ItemInit.HAZEL_WOOD.get());
            event.accept(ItemInit.STRIPPED_HAZEL_WOOD.get());
            event.accept(ItemInit.HAZEL_PLANKS.get());
            event.accept(ItemInit.HAZEL_SLAB.get());
            event.accept(ItemInit.HAZEL_STAIRS.get());
            event.accept(ItemInit.HAZEL_BUTTON.get());
            event.accept(ItemInit.HAZEL_PRESSURE_PLATE.get());
            event.accept(ItemInit.HAZEL_FENCE.get());
            event.accept(ItemInit.HAZEL_FENCE_GATE.get());
            event.accept(ItemInit.HAZEL_DOOR.get());
            event.accept(ItemInit.HAZEL_TRAPDOOR.get());
            event.accept(ItemInit.HAZEL_SIGN_ITEM.get());
            event.accept(ItemInit.HAZEL_HANGING_SIGN_ITEM.get());
            event.accept(ItemInit.HAZEL_BOAT.get());
            event.accept(ItemInit.HAZEL_CHEST_BOAT.get());
            event.accept(ItemInit.HAZEL_LEAVES.get());
            event.accept(ItemInit.HAZEL_SAPLING.get());
            event.accept(ItemInit.TOMATO.get());
            event.accept(ItemInit.TOMATO_SEEDS.get());
            event.accept(ItemInit.STRAWBERRY.get());
            event.accept(ItemInit.SUGARED_STRAWBERRY.get());
            event.accept(ItemInit.STRAWBERRY_JAM.get());
            event.accept(ItemInit.STRAWBERRY_CAKE.get());
            event.accept(ItemInit.CHORUS_CHOCOLATE_COVERED_STRAWBERRY.get());
            event.accept(ItemInit.CHOCOLATE_COVERED_STRAWBERRY.get());
            event.accept(ItemInit.WHITE_CHOCOLATE_COVERED_STRAWBERRY.get());
            event.accept(ItemInit.CHOCOLATE_BAR.get());
            event.accept(ItemInit.WHITE_CHOCOLATE_BAR.get());
            event.accept(ItemInit.CHORUS_CHOCOLATE_BAR.get());
            event.accept(ItemInit.CHOCOLATE_BAR_WITH_NUTS.get());
            event.accept(ItemInit.HOT_CHOCOLATE.get());
            event.accept(ItemInit.CHOCOLATE_CAKE.get());
            event.accept(ItemInit.BROWN_WHEAT.get());
            event.accept(ItemInit.BROWN_WHEAT_SEEDS.get());
            event.accept(ItemInit.BROWN_HAY_BLOCK.get());
            event.accept(ItemInit.RAISINS.get());
            event.accept(ItemInit.RAISIN_COOKIE.get());
            event.accept(ItemInit.MILK_BOTTLE.get());
            event.accept(ItemInit.CHEESE.get());
            event.accept(ItemInit.PIZZA.get());
            event.accept(ItemInit.CHILI_PEPPER.get());
            event.accept(ItemInit.PARROTFRUIT.get());
            event.accept(ItemInit.SOUL_BOTTLE.get());
            event.accept(ItemInit.SOUL_SHAKE.get());
            event.accept(ItemInit.FIG.get());
            event.accept(ItemInit.FIG_LOG.get());
            event.accept(ItemInit.STRIPPED_FIG_LOG.get());
            event.accept(ItemInit.FIG_WOOD.get());
            event.accept(ItemInit.STRIPPED_FIG_WOOD.get());
            event.accept(ItemInit.FIG_PLANKS.get());
            event.accept(ItemInit.FIG_SLAB.get());
            event.accept(ItemInit.FIG_STAIRS.get());
            event.accept(ItemInit.FIG_BUTTON.get());
            event.accept(ItemInit.FIG_PRESSURE_PLATE.get());
            event.accept(ItemInit.FIG_FENCE.get());
            event.accept(ItemInit.FIG_FENCE_GATE.get());
            event.accept(ItemInit.FIG_DOOR.get());
            event.accept(ItemInit.FIG_TRAPDOOR.get());
            event.accept(ItemInit.FIG_SIGN_ITEM.get());
            event.accept(ItemInit.FIG_HANGING_SIGN_ITEM.get());
            event.accept(ItemInit.FIG_BOAT.get());
            event.accept(ItemInit.FIG_CHEST_BOAT.get());
            event.accept(ItemInit.FIG_LEAVES.get());
            event.accept(ItemInit.FIG_SAPLING.get());

            if (ModList.get().isLoaded("farmersdelight")) {
                event.accept(FDItemInit.CHOCOLATE_CAKE_SLICE.get());
                event.accept(FDItemInit.STRAWBERRY_CAKE_SLICE.get());
                event.accept(FDItemInit.PIZZA_SLICE.get());
                event.accept(FDItemInit.HAZEL_CABINET.get());
            }
        }
    }
}
