package seniordee.allyoucaneat.core.init;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.blocks.CeilingHangingSignBlock;
import seniordee.allyoucaneat.common.blocks.StandingSignBlock;
import seniordee.allyoucaneat.common.blocks.WallHangingSignBlock;
import seniordee.allyoucaneat.common.blocks.WallSignBlock;
import seniordee.allyoucaneat.common.blocks.*;
import seniordee.allyoucaneat.core.util.CauldronInteractions;
import seniordee.allyoucaneat.world.features.tree.FigTreeGrower;
import seniordee.allyoucaneat.world.features.tree.HazelTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            AllYouCanEat.MOD_ID);

    public static final RegistryObject<Block> WINE_BOTTLE = BLOCKS.register("wine_bottle",
            () -> new EmptyWineBottleBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
            .strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> RED_WINE_BOTTLE = BLOCKS.register("red_wine_bottle",
            () -> new WineBottleBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
            .strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> WHITE_WINE_BOTTLE = BLOCKS.register("white_wine_bottle",
            () -> new WineBottleBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)
            .strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    public static final RegistryObject<Block> BLACK_GRAPE_CROP = BLOCKS.register("black_grape_crop",
            () -> new BlackGrapeCropBlock(Block.Properties.copy(Blocks.WHEAT)
            .noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> WHITE_GRAPE_CROP = BLOCKS.register("white_grape_crop",
            () -> new WhiteGrapeCropBlock(Block.Properties.copy(Blocks.WHEAT)
            .noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> HAZEL_LOG = BLOCKS.register("hazel_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> HAZEL_WOOD = BLOCKS.register("hazel_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_HAZEL_LOG = BLOCKS.register("stripped_hazel_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_HAZEL_WOOD = BLOCKS.register("stripped_hazel_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> HAZEL_LEAVES = BLOCKS.register("hazel_leaves",
            () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> HAZEL_SAPLING = BLOCKS.register("hazel_sapling",
            () -> new SaplingBlock(new HazelTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> HAZEL_PLANKS = BLOCKS.register("hazel_planks",
            () -> new FlammablePlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> HAZEL_SLAB = BLOCKS.register("hazel_slab",
            () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> HAZEL_STAIRS = BLOCKS.register("hazel_stairs",
            () -> new FlammableStairBlock(() -> HAZEL_PLANKS.get()
            .defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> HAZEL_BUTTON = BLOCKS.register("hazel_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<Block> HAZEL_PRESSURE_PLATE = BLOCKS.register("hazel_pressure_plate",
            () -> new PressurePlateBlock(Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> HAZEL_FENCE = BLOCKS.register("hazel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> HAZEL_FENCE_GATE = BLOCKS.register("hazel_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> HAZEL_DOOR = BLOCKS.register("hazel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> HAZEL_TRAPDOOR = BLOCKS.register("hazel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> HAZEL_SIGN = BLOCKS.register("hazel_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodTypesInit.HAZEL));

    public static final RegistryObject<Block> HAZEL_WALL_SIGN = BLOCKS.register("hazel_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodTypesInit.HAZEL));

    public static final RegistryObject<Block> HAZEL_HANGING_SIGN = BLOCKS.register("hazel_hanging_sign",
            () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN),
                    WoodTypesInit.HAZEL));

    public static final RegistryObject<Block> HAZEL_WALL_HANGING_SIGN = BLOCKS.register("hazel_wall_hanging_sign",
            () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN),
                    WoodTypesInit.HAZEL));

    public static final RegistryObject<Block> TOMATO_CROP = BLOCKS.register("tomato_crop",
            () -> new TomatoCropBlock(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH)
            .noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> CHOCOLATE_CAKE = BLOCKS.register("chocolate_cake",
            () -> new ChocolateCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));

    public static final RegistryObject<Block> CANDLE_CHOCOLATE_CAKE = BLOCKS.register("candle_chocolate_cake",
            () -> new CandleChocolateCakeBlock(Blocks.CANDLE, BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> WHITE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "white_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.WHITE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> ORANGE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "orange_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.ORANGE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> MAGENTA_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "magenta_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.MAGENTA_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "light_blue_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.LIGHT_BLUE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> YELLOW_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "yellow_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.YELLOW_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> LIME_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "lime_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.LIME_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> PINK_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "pink_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.PINK_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> GRAY_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "gray_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.GRAY_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "light_gray_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.LIGHT_GRAY_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> CYAN_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "cyan_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.CYAN_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> PURPLE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "purple_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.PURPLE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> BLUE_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "blue_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.BLUE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> BROWN_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "brown_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.BROWN_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> GREEN_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "green_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.GREEN_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> RED_CANDLE_CHOCOLATE_CAKE = BLOCKS.register("red_candle_chocolate_cake"
            , () -> new CandleChocolateCakeBlock(Blocks.RED_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> BLACK_CANDLE_CHOCOLATE_CAKE = BLOCKS.register(
            "black_candle_chocolate_cake", () -> new CandleChocolateCakeBlock(Blocks.BLACK_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> STRAWBERRY_BUSH = BLOCKS.register("strawberry_bush",
            () -> new StrawberryBushBlock(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH)
            .noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> STRAWBERRY_CAKE = BLOCKS.register("strawberry_cake",
            () -> new StrawberryCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));

    public static final RegistryObject<Block> CANDLE_STRAWBERRY_CAKE = BLOCKS.register("candle_strawberry_cake",
            () -> new CandleStrawberryCakeBlock(Blocks.CANDLE, BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> WHITE_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "white_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.WHITE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> ORANGE_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "orange_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.ORANGE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> MAGENTA_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "magenta_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.MAGENTA_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> LIGHT_BLUE_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "light_blue_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.LIGHT_BLUE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> YELLOW_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "yellow_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.YELLOW_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> LIME_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "lime_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.LIME_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> PINK_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "pink_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.PINK_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> GRAY_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "gray_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.GRAY_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> LIGHT_GRAY_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "light_gray_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.LIGHT_GRAY_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> CYAN_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "cyan_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.CYAN_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> PURPLE_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "purple_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.PURPLE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> BLUE_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "blue_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.BLUE_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> BROWN_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "brown_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.BROWN_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> GREEN_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "green_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.GREEN_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> RED_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "red_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.RED_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> BLACK_CANDLE_STRAWBERRY_CAKE = BLOCKS.register(
            "black_candle_strawberry_cake", () -> new CandleStrawberryCakeBlock(Blocks.BLACK_CANDLE,
                    BlockBehaviour.Properties.copy(Blocks.CANDLE_CAKE)));

    public static final RegistryObject<Block> PIZZA = BLOCKS.register("pizza",
            () -> new PizzaBlock(BlockBehaviour.Properties.copy(Blocks.CAKE)));

    public static final RegistryObject<Block> MILK_CAULDRON = BLOCKS.register("milk_cauldron",
            () -> new MilkCauldronBlock(BlockBehaviour.Properties.copy(Blocks.WATER_CAULDRON), (predicate) -> false,
                    CauldronInteractions.MILK));

    public static final RegistryObject<Block> RED_WINE_CAULDRON = BLOCKS.register("red_wine_cauldron",
            () -> new RedWineCauldronBlock(BlockBehaviour.Properties.copy(Blocks.WATER_CAULDRON),
                    (predicate) -> false, CauldronInteractions.RED_WINE));

    public static final RegistryObject<Block> WHITE_WINE_CAULDRON = BLOCKS.register("white_wine_cauldron",
            () -> new WhiteWineCauldronBlock(BlockBehaviour.Properties.copy(Blocks.WATER_CAULDRON),
                    (predicate) -> false, CauldronInteractions.WHITE_WINE));

    public static final RegistryObject<Block> BROWN_WHEAT_CROP = BLOCKS.register("brown_wheat_crop",
            () -> new BrownWheatCropBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> BROWN_HAY_BLOCK = BLOCKS.register("brown_hay_block",
            () -> new HayBlock(Block.Properties.copy(Blocks.HAY_BLOCK)));

    public static final RegistryObject<LiquidBlock> RED_WINE_BLOCK = BLOCKS.register("red_wine_block",
            () -> new LiquidBlock(FluidInit.SOURCE_RED_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)
            .noLootTable()));

    public static final RegistryObject<LiquidBlock> WHITE_WINE_BLOCK = BLOCKS.register("white_wine_block",
            () -> new LiquidBlock(FluidInit.SOURCE_WHITE_WINE, BlockBehaviour.Properties.copy(Blocks.WATER)
            .noLootTable()));

    public static final RegistryObject<Block> FIG_LOG = BLOCKS.register("fig_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> FIG_WOOD = BLOCKS.register("fig_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_FIG_LOG = BLOCKS.register("stripped_fig_log",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_FIG_WOOD = BLOCKS.register("stripped_fig_wood",
            () -> new FlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> FIG_LEAVES = BLOCKS.register("fig_leaves",
            () -> new FlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    public static final RegistryObject<Block> FIG_SAPLING = BLOCKS.register("fig_sapling",
            () -> new SaplingBlock(new FigTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> FIG_PLANKS = BLOCKS.register("fig_planks",
            () -> new FlammablePlankBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> FIG_SLAB = BLOCKS.register("fig_slab",
            () -> new FlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)));

    public static final RegistryObject<Block> FIG_STAIRS = BLOCKS.register("fig_stairs",
            () -> new FlammableStairBlock(() -> FIG_PLANKS.get()
            .defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)));

    public static final RegistryObject<Block> FIG_BUTTON = BLOCKS.register("fig_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));

    public static final RegistryObject<Block> FIG_PRESSURE_PLATE = BLOCKS.register("fig_pressure_plate",
            () -> new PressurePlateBlock(Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));

    public static final RegistryObject<Block> FIG_FENCE = BLOCKS.register("fig_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)));

    public static final RegistryObject<Block> FIG_FENCE_GATE = BLOCKS.register("fig_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> FIG_DOOR = BLOCKS.register("fig_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> FIG_TRAPDOOR = BLOCKS.register("fig_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));

    public static final RegistryObject<Block> FIG_SIGN = BLOCKS.register("fig_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), WoodTypesInit.FIG));

    public static final RegistryObject<Block> FIG_WALL_SIGN = BLOCKS.register("fig_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), WoodTypesInit.FIG));

    public static final RegistryObject<Block> FIG_HANGING_SIGN = BLOCKS.register("fig_hanging_sign",
            () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN),
                    WoodTypesInit.FIG));

    public static final RegistryObject<Block> FIG_WALL_HANGING_SIGN = BLOCKS.register("fig_wall_hanging_sign",
            () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN),
                    WoodTypesInit.FIG));
}