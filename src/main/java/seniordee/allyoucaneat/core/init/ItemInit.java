package seniordee.allyoucaneat.core.init;

import java.util.ArrayList;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.entities.vehicle.BoatEntity;
import seniordee.allyoucaneat.common.items.BoatItem;
import seniordee.allyoucaneat.common.items.ChiliPepperItem;
import seniordee.allyoucaneat.common.items.HotDrinkBottleItem;
import seniordee.allyoucaneat.common.items.JamBottleItem;
import seniordee.allyoucaneat.common.items.MarshmallowItem;
import seniordee.allyoucaneat.common.items.MilkBottleItem;
import seniordee.allyoucaneat.common.items.ParrotfruitItem;
import seniordee.allyoucaneat.common.items.SoulDrinkItem;
import seniordee.allyoucaneat.common.items.WineGlassItem;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            AllYouCanEat.MOD_ID);
    public static ArrayList<Item> seeds = new ArrayList<>();

    public static final RegistryObject<Item> WINE_GLASS = ITEMS.register("wine_glass",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> RED_WINE_GLASS = ITEMS.register("red_wine_glass",
            () -> new WineGlassItem(new Item.Properties().stacksTo(1)
            .craftRemainder(WINE_GLASS.get())));

    public static final RegistryObject<Item> WHITE_WINE_GLASS = ITEMS.register("white_wine_glass",
            () -> new WineGlassItem(new Item.Properties().stacksTo(1)
            .craftRemainder(WINE_GLASS.get())));

    public static final RegistryObject<Item> BLACK_GRAPE = ITEMS.register("black_grape",
            () -> new Item(new Item.Properties().food(FoodInit.BLACK_GRAPE)));

    public static final RegistryObject<Item> WHITE_GRAPE = ITEMS.register("white_grape",
            () -> new Item(new Item.Properties().food(FoodInit.WHITE_GRAPE)));

    public static final RegistryObject<Item> BLACK_GRAPE_SEEDS = ITEMS.register("black_grape_seeds",
            () -> new ItemNameBlockItem(BlockInit.BLACK_GRAPE_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> WHITE_GRAPE_SEEDS = ITEMS.register("white_grape_seeds",
            () -> new ItemNameBlockItem(BlockInit.WHITE_GRAPE_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> HAZELNUT = ITEMS.register("hazelnut",
            () -> new Item(new Item.Properties().food(FoodInit.HAZELNUT)));

    public static final RegistryObject<Item> GELATIN = ITEMS.register("gelatin", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MARSHMALLOW_ON_A_STICK = ITEMS.register("marshmallow_on_a_stick",
            () -> new MarshmallowItem(new Item.Properties().food(FoodInit.MARSHMALLOW_ON_A_STICK)
            .craftRemainder(Items.STICK)));

    public static final RegistryObject<Item> ROASTED_MARSHMALLOW_ON_A_STICK = ITEMS.register(
            "roasted_marshmallow_on_a_stick",
            () -> new MarshmallowItem(new Item.Properties().food(FoodInit.ROASTED_MARSHMALLOW_ON_A_STICK)
            .craftRemainder(Items.STICK)));

    public static final RegistryObject<Item> HAZEL_SIGN_ITEM = ITEMS.register("hazel_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BlockInit.HAZEL_SIGN.get(),
                    BlockInit.HAZEL_WALL_SIGN.get()));

    public static final RegistryObject<Item> HAZEL_HANGING_SIGN_ITEM = ITEMS.register("hazel_hanging_sign",
            () -> new HangingSignItem(BlockInit.HAZEL_HANGING_SIGN.get(), BlockInit.HAZEL_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> HAZEL_BOAT = ITEMS.register("hazel_boat", () -> new BoatItem(false,
            BoatEntity.Type.HAZEL, new Item.Properties()));

    public static final RegistryObject<Item> HAZEL_CHEST_BOAT = ITEMS.register("hazel_chest_boat",
            () -> new BoatItem(true, BoatEntity.Type.HAZEL, new Item.Properties()));

    public static final RegistryObject<Item> RED_WINE_BUCKET = ITEMS.register("red_wine_bucket",
            () -> new BucketItem(FluidInit.SOURCE_RED_WINE, new Item.Properties().craftRemainder(Items.BUCKET)
            .stacksTo(1)));

    public static final RegistryObject<Item> WHITE_WINE_BUCKET = ITEMS.register("white_wine_bucket",
            () -> new BucketItem(FluidInit.SOURCE_WHITE_WINE, new Item.Properties().craftRemainder(Items.BUCKET)
            .stacksTo(1)));

    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(FoodInit.TOMATO)));

    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(BlockInit.TOMATO_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new ItemNameBlockItem(BlockInit.STRAWBERRY_BUSH.get(),
                    new Item.Properties().food(FoodInit.STRAWBERRY)));

    public static final RegistryObject<Item> SUGARED_STRAWBERRY = ITEMS.register("sugared_strawberry",
            () -> new Item(new Item.Properties().food(FoodInit.SUGARED_STRAWBERRY)));

    public static final RegistryObject<Item> CHOCOLATE_BAR = ITEMS.register("chocolate_bar",
            () -> new Item(new Item.Properties().food(FoodInit.CHOCOLATE_BAR)));

    public static final RegistryObject<Item> WHITE_CHOCOLATE_BAR = ITEMS.register("white_chocolate_bar",
            () -> new Item(new Item.Properties().food(FoodInit.WHITE_CHOCOLATE_BAR)));

    public static final RegistryObject<Item> CHOCOLATE_COVERED_STRAWBERRY = ITEMS.register(
            "chocolate_covered_strawberry",
            () -> new Item(new Item.Properties().food(FoodInit.CHOCOLATE_COVERED_STRAWBERRY)));

    public static final RegistryObject<Item> WHITE_CHOCOLATE_COVERED_STRAWBERRY = ITEMS.register(
            "white_chocolate_covered_strawberry",
            () -> new Item(new Item.Properties().food(FoodInit.WHITE_CHOCOLATE_COVERED_STRAWBERRY)));

    public static final RegistryObject<Item> STRAWBERRY_JAM = ITEMS.register("strawberry_jam",
            () -> new JamBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> HOT_CHOCOLATE = ITEMS.register("hot_chocolate",
            () -> new HotDrinkBottleItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(FoodInit.CHEESE)));

    public static final RegistryObject<Item> CHORUS_CHOCOLATE_BAR = ITEMS.register("chorus_chocolate_bar",
            () -> new ChorusFruitItem(new Item.Properties().food(FoodInit.CHORUS_CHOCOLATE_BAR)));

    public static final RegistryObject<Item> CHORUS_CHOCOLATE_COVERED_STRAWBERRY = ITEMS.register(
            "chorus_chocolate_covered_strawberry",
            () -> new ChorusFruitItem(new Item.Properties().food(FoodInit.CHORUS_CHOCOLATE_COVERED_STRAWBERRY)));

    public static final RegistryObject<Item> SOUL_BOTTLE = ITEMS.register("soul_bottle",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL_SHAKE = ITEMS.register("soul_shake",
            () -> new SoulDrinkItem(new Item.Properties().stacksTo(16)
            .craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> MILK_BOTTLE = ITEMS.register("milk_bottle",
            () -> new MilkBottleItem(new Item.Properties().stacksTo(16)
            .craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> CHOCOLATE_BAR_WITH_NUTS = ITEMS.register("chocolate_bar_with_nuts",
            () -> new Item(new Item.Properties().food(FoodInit.CHOCOLATE_BAR_WITH_NUTS)));

    public static final RegistryObject<Item> RAISINS = ITEMS.register("raisins",
            () -> new Item(new Item.Properties().food(FoodInit.RAISINS)));

    public static final RegistryObject<Item> BROWN_WHEAT = ITEMS.register("brown_wheat",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BROWN_WHEAT_SEEDS = ITEMS.register("brown_wheat_seeds",
            () -> new ItemNameBlockItem(BlockInit.BROWN_WHEAT_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> RAISIN_COOKIE = ITEMS.register("raisin_cookie",
            () -> new Item(new Item.Properties().food(FoodInit.RAISIN_COOKIE)));

    public static final RegistryObject<Item> PARROTFRUIT = ITEMS.register("parrotfruit",
            () -> new ParrotfruitItem(new Item.Properties()));

    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper",
            () -> new ChiliPepperItem(new Item.Properties().food(FoodInit.CHILI_PEPPER)));

    public static final RegistryObject<Item> FIG = ITEMS.register("fig",
            () -> new Item(new Item.Properties().food(FoodInit.FIG)));

    public static final RegistryObject<Item> FIG_SIGN_ITEM = ITEMS.register("fig_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16), BlockInit.FIG_SIGN.get(),
                    BlockInit.FIG_WALL_SIGN.get()));

    public static final RegistryObject<Item> FIG_HANGING_SIGN_ITEM = ITEMS.register("fig_hanging_sign",
            () -> new HangingSignItem(BlockInit.FIG_HANGING_SIGN.get(), BlockInit.FIG_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> FIG_BOAT = ITEMS.register("fig_boat", () -> new BoatItem(false,
            BoatEntity.Type.FIG, new Item.Properties()));

    public static final RegistryObject<Item> FIG_CHEST_BOAT = ITEMS.register("fig_chest_boat",
            () -> new BoatItem(true, BoatEntity.Type.FIG, new Item.Properties()));

    // Blocks

    public static final RegistryObject<BlockItem> WINE_BOTTLE = ITEMS.register("wine_bottle",
            () -> new BlockItem(BlockInit.WINE_BOTTLE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> RED_WINE_BOTTLE = ITEMS.register("red_wine_bottle",
            () -> new BlockItem(BlockInit.RED_WINE_BOTTLE.get(),
                    new Item.Properties().craftRemainder(WINE_BOTTLE.get())));

    public static final RegistryObject<BlockItem> WHITE_WINE_BOTTLE = ITEMS.register("white_wine_bottle",
            () -> new BlockItem(BlockInit.WHITE_WINE_BOTTLE.get(),
                    new Item.Properties().craftRemainder(WINE_BOTTLE.get())));

    public static final RegistryObject<BlockItem> HAZEL_LOG = ITEMS.register("hazel_log",
            () -> new BlockItem(BlockInit.HAZEL_LOG.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> STRIPPED_HAZEL_LOG = ITEMS.register("stripped_hazel_log",
            () -> new BlockItem(BlockInit.STRIPPED_HAZEL_LOG.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_WOOD = ITEMS.register("hazel_wood",
            () -> new BlockItem(BlockInit.HAZEL_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> STRIPPED_HAZEL_WOOD = ITEMS.register("stripped_hazel_wood",
            () -> new BlockItem(BlockInit.STRIPPED_HAZEL_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_PLANKS = ITEMS.register("hazel_planks",
            () -> new BlockItem(BlockInit.HAZEL_PLANKS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_SLAB = ITEMS.register("hazel_slab",
            () -> new BlockItem(BlockInit.HAZEL_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_STAIRS = ITEMS.register("hazel_stairs",
            () -> new BlockItem(BlockInit.HAZEL_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_LEAVES = ITEMS.register("hazel_leaves",
            () -> new BlockItem(BlockInit.HAZEL_LEAVES.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_SAPLING = ITEMS.register("hazel_sapling",
            () -> new BlockItem(BlockInit.HAZEL_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_BUTTON = ITEMS.register("hazel_button",
            () -> new BlockItem(BlockInit.HAZEL_BUTTON.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_PRESSURE_PLATE = ITEMS.register("hazel_pressure_plate",
            () -> new BlockItem(BlockInit.HAZEL_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_FENCE = ITEMS.register("hazel_fence",
            () -> new BlockItem(BlockInit.HAZEL_FENCE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_FENCE_GATE = ITEMS.register("hazel_fence_gate",
            () -> new BlockItem(BlockInit.HAZEL_FENCE_GATE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_DOOR = ITEMS.register("hazel_door",
            () -> new BlockItem(BlockInit.HAZEL_DOOR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> HAZEL_TRAPDOOR = ITEMS.register("hazel_trapdoor",
            () -> new BlockItem(BlockInit.HAZEL_TRAPDOOR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> CHOCOLATE_CAKE = ITEMS.register("chocolate_cake",
            () -> new BlockItem(BlockInit.CHOCOLATE_CAKE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> STRAWBERRY_CAKE = ITEMS.register("strawberry_cake",
            () -> new BlockItem(BlockInit.STRAWBERRY_CAKE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> PIZZA = ITEMS.register("pizza",
            () -> new BlockItem(BlockInit.PIZZA.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> BROWN_HAY_BLOCK = ITEMS.register("brown_hay_block",
            () -> new BlockItem(BlockInit.BROWN_HAY_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_LOG = ITEMS.register("fig_log",
            () -> new BlockItem(BlockInit.FIG_LOG.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> STRIPPED_FIG_LOG = ITEMS.register("stripped_fig_log",
            () -> new BlockItem(BlockInit.STRIPPED_FIG_LOG.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_WOOD = ITEMS.register("fig_wood",
            () -> new BlockItem(BlockInit.FIG_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> STRIPPED_FIG_WOOD = ITEMS.register("stripped_fig_wood",
            () -> new BlockItem(BlockInit.STRIPPED_FIG_WOOD.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_PLANKS = ITEMS.register("fig_planks",
            () -> new BlockItem(BlockInit.FIG_PLANKS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_SLAB = ITEMS.register("fig_slab",
            () -> new BlockItem(BlockInit.FIG_SLAB.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_STAIRS = ITEMS.register("fig_stairs",
            () -> new BlockItem(BlockInit.FIG_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_LEAVES = ITEMS.register("fig_leaves",
            () -> new BlockItem(BlockInit.FIG_LEAVES.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_SAPLING = ITEMS.register("fig_sapling",
            () -> new BlockItem(BlockInit.FIG_SAPLING.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_BUTTON = ITEMS.register("fig_button",
            () -> new BlockItem(BlockInit.FIG_BUTTON.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_PRESSURE_PLATE = ITEMS.register("fig_pressure_plate",
            () -> new BlockItem(BlockInit.FIG_PRESSURE_PLATE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_FENCE = ITEMS.register("fig_fence",
            () -> new BlockItem(BlockInit.FIG_FENCE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_FENCE_GATE = ITEMS.register("fig_fence_gate",
            () -> new BlockItem(BlockInit.FIG_FENCE_GATE.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_DOOR = ITEMS.register("fig_door",
            () -> new BlockItem(BlockInit.FIG_DOOR.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_TRAPDOOR = ITEMS.register("fig_trapdoor",
            () -> new BlockItem(BlockInit.FIG_TRAPDOOR.get(), new Item.Properties()));

    // Other

    public static void addSeeds() {
        seeds.add(BLACK_GRAPE_SEEDS.get());
        seeds.add(WHITE_GRAPE_SEEDS.get());
        seeds.add(TOMATO_SEEDS.get());
        seeds.add(BROWN_WHEAT_SEEDS.get());
    }

    public static void compostables() {
        registerCompostable(0.3f, BLACK_GRAPE_SEEDS.get());
        registerCompostable(0.3f, WHITE_GRAPE_SEEDS.get());
        registerCompostable(0.3f, TOMATO_SEEDS.get());
        registerCompostable(0.3f, BLACK_GRAPE.get());
        registerCompostable(0.3f, WHITE_GRAPE.get());
        registerCompostable(0.3f, HAZELNUT.get());
        registerCompostable(0.3f, HAZEL_LEAVES.get());
        registerCompostable(0.3f, TOMATO.get());
        registerCompostable(0.3f, STRAWBERRY.get());
        registerCompostable(0.65f, BROWN_WHEAT.get());
        registerCompostable(0.3f, BROWN_WHEAT_SEEDS.get());
        registerCompostable(0.85f, BROWN_HAY_BLOCK.get());
        registerCompostable(0.3f, HAZEL_SAPLING.get());
        registerCompostable(0.3f, FIG.get());
        registerCompostable(0.3f, FIG_LEAVES.get());
        registerCompostable(0.3f, FIG_SAPLING.get());
    }

    private static void registerCompostable(float chance, ItemLike itemProvider) {
        ComposterBlock.COMPOSTABLES.put(itemProvider.asItem(), chance);
    }
}