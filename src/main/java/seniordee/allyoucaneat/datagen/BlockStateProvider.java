package seniordee.allyoucaneat.datagen;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.blocks.*;
import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.BlockStatePropertiesInit;
import seniordee.allyoucaneat.core.integrations.farmersdelight.init.FDBlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;

import java.util.function.Function;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AllYouCanEat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockInit.HAZEL_PLANKS);

        blockItem(BlockInit.HAZEL_LOG);
        blockItem(BlockInit.HAZEL_WOOD);
        blockItem(BlockInit.STRIPPED_HAZEL_LOG);
        blockItem(BlockInit.STRIPPED_HAZEL_WOOD);
        blockItem(BlockInit.BROWN_HAY_BLOCK);

        strawberryBush((StrawberryBushBlock) BlockInit.STRAWBERRY_BUSH.get(), "strawberry_bush_stage",
                "strawberry_bush_stage");

        blackGrapeCrop((BlackGrapeCropBlock) BlockInit.BLACK_GRAPE_CROP.get(), "black_grape_stage",
                "black_grape_stage");

        whiteGrapeCrop((WhiteGrapeCropBlock) BlockInit.WHITE_GRAPE_CROP.get(), "white_grape_stage",
                "white_grape_stage");

        brownWheatCrop((BrownWheatCropBlock) BlockInit.BROWN_WHEAT_CROP.get(), "brown_wheat_stage",
                "brown_wheat_stage");

        tomatoCrop((TomatoCropBlock) BlockInit.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");

        cakeBlock(BlockInit.CHOCOLATE_CAKE);
        cakeBlock(BlockInit.STRAWBERRY_CAKE);

        candleCakeBlock(BlockInit.CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.BLACK_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.BLUE_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.BROWN_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.CYAN_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.GRAY_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.GREEN_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.LIME_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.MAGENTA_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.ORANGE_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.PINK_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.PURPLE_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.RED_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.WHITE_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.YELLOW_CANDLE_CHOCOLATE_CAKE);
        candleCakeBlock(BlockInit.CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.BLACK_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.BLUE_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.BROWN_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.CYAN_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.GRAY_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.GREEN_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.LIGHT_BLUE_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.LIGHT_GRAY_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.LIME_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.MAGENTA_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.ORANGE_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.PINK_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.PURPLE_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.RED_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.WHITE_CANDLE_STRAWBERRY_CAKE);
        candleCakeBlock(BlockInit.YELLOW_CANDLE_STRAWBERRY_CAKE);

        stairsBlock(((StairBlock) BlockInit.HAZEL_STAIRS.get()), blockTexture(BlockInit.HAZEL_PLANKS.get()));

        slabBlock(((SlabBlock) BlockInit.HAZEL_SLAB.get()), blockTexture(BlockInit.HAZEL_PLANKS.get()),
                blockTexture(BlockInit.HAZEL_PLANKS.get()));

        pressurePlateBlock(((PressurePlateBlock) BlockInit.HAZEL_PRESSURE_PLATE.get()),
                blockTexture(BlockInit.HAZEL_PLANKS.get()));

        buttonBlock(((ButtonBlock) BlockInit.HAZEL_BUTTON.get()), blockTexture(BlockInit.HAZEL_PLANKS.get()));

        fenceBlock(((FenceBlock) BlockInit.HAZEL_FENCE.get()), blockTexture(BlockInit.HAZEL_PLANKS.get()));

        fenceGateBlock(((FenceGateBlock) BlockInit.HAZEL_FENCE_GATE.get()), blockTexture(BlockInit.HAZEL_PLANKS.get()));

        doorBlockWithRenderType(((DoorBlock) BlockInit.HAZEL_DOOR.get()), modLoc("block/hazel_door_bottom"), modLoc(
                "block/hazel_door_top"), "cutout");

        trapdoorBlockWithRenderType(((TrapDoorBlock) BlockInit.HAZEL_TRAPDOOR.get()), modLoc("block" +
                "/hazel_trapdoor"), true, "cutout");

        signBlock((StandingSignBlock) BlockInit.HAZEL_SIGN.get(), (WallSignBlock) BlockInit.HAZEL_WALL_SIGN.get(),
                blockTexture(BlockInit.HAZEL_PLANKS.get()));

        hangingSignBlock(BlockInit.HAZEL_HANGING_SIGN.get(), BlockInit.HAZEL_WALL_HANGING_SIGN.get(),
                blockTexture(BlockInit.HAZEL_PLANKS.get()));

        leavesBlock(BlockInit.HAZEL_LEAVES);

        saplingBlock(BlockInit.HAZEL_SAPLING);

        logBlock(((RotatedPillarBlock) BlockInit.HAZEL_LOG.get()));

        axisBlock(((RotatedPillarBlock) BlockInit.HAZEL_WOOD.get()), blockTexture(BlockInit.HAZEL_LOG.get()),
                blockTexture(BlockInit.HAZEL_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockInit.STRIPPED_HAZEL_LOG.get()),
                blockTexture(BlockInit.STRIPPED_HAZEL_LOG.get()), new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block" + "/stripped_hazel_log_top"));
        axisBlock(((RotatedPillarBlock) BlockInit.STRIPPED_HAZEL_WOOD.get()),
                blockTexture(BlockInit.STRIPPED_HAZEL_LOG.get()), blockTexture(BlockInit.STRIPPED_HAZEL_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockInit.BROWN_HAY_BLOCK.get()), new ResourceLocation(AllYouCanEat.MOD_ID,
                "block/brown_hay_block_side"), new ResourceLocation(AllYouCanEat.MOD_ID, "block" +
                "/brown_hay_block_top"));

        layeredCauldron(BlockInit.MILK_CAULDRON);
        layeredCauldron(BlockInit.RED_WINE_CAULDRON);
        layeredCauldron(BlockInit.WHITE_WINE_CAULDRON);

        pizzaBlock(BlockInit.PIZZA);

        wineBottleBlock(BlockInit.RED_WINE_BOTTLE);
        wineBottleBlock(BlockInit.WHITE_WINE_BOTTLE);

        customBlock(BlockInit.RED_WINE_BLOCK);
        customBlock(BlockInit.WHITE_WINE_BLOCK);
        customBlock(BlockInit.WINE_BOTTLE);

        if (ModList.get().isLoaded("farmersdelight")) {
            cabinetBlock(FDBlockInit.HAZEL_CABINET.get(), "hazel");
        }
    }

    private void blockItem(RegistryObject<Block> block) {
        simpleBlockItem(block.get(),
                new ModelFile.UncheckedModelFile(AllYouCanEat.MOD_ID + ":block/" + ForgeRegistries.BLOCKS.getKey(block.get())
                .getPath()));
    }

    public void customBlock(RegistryObject<? extends Block> block) {
        simpleBlock((Block) block.get(), new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                "block/" + ForgeRegistries.BLOCKS.getKey(block.get())
                .getPath())));
    }

    private void blockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())
                        .getPath(), new ResourceLocation("minecraft:block/leaves"), "all",
                                blockTexture(blockRegistryObject.get()))
                .renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())
                .getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void strawberryBush(StrawberryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName,
                textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, StrawberryBushBlock block, String modelName,
                                               String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] =
                new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryBushBlock) block).getAgeProperty()), new ResourceLocation(AllYouCanEat.MOD_ID, "block/" + textureName + state.getValue(((StrawberryBushBlock) block).getAgeProperty())))
                .renderType("cutout"));

        return models;
    }

    public void blackGrapeCrop(BlackGrapeCropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> blackGrapeStates(state, block, modelName,
                textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] blackGrapeStates(BlockState state, BlackGrapeCropBlock block, String modelName,
                                               String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] =
                new ConfiguredModel(models().crop(modelName + state.getValue(((BlackGrapeCropBlock) block).getAgeProperty()), new ResourceLocation(AllYouCanEat.MOD_ID, "block/" + textureName + state.getValue(((BlackGrapeCropBlock) block).getAgeProperty())))
                .renderType("cutout"));

        return models;
    }

    public void whiteGrapeCrop(WhiteGrapeCropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> whiteGrapeStates(state, block, modelName,
                textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] whiteGrapeStates(BlockState state, WhiteGrapeCropBlock block, String modelName,
                                               String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] =
                new ConfiguredModel(models().crop(modelName + state.getValue(((WhiteGrapeCropBlock) block).getAgeProperty()), new ResourceLocation(AllYouCanEat.MOD_ID, "block/" + textureName + state.getValue(((WhiteGrapeCropBlock) block).getAgeProperty())))
                .renderType("cutout"));

        return models;
    }

    public void brownWheatCrop(BrownWheatCropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> brownWheatStates(state, block, modelName,
                textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] brownWheatStates(BlockState state, BrownWheatCropBlock block, String modelName,
                                               String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] =
                new ConfiguredModel(models().crop(modelName + state.getValue(((BrownWheatCropBlock) block).getAgeProperty()), new ResourceLocation(AllYouCanEat.MOD_ID, "block/" + textureName + state.getValue(((BrownWheatCropBlock) block).getAgeProperty())))
                .renderType("cutout"));

        return models;
    }

    public void tomatoCrop(TomatoCropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> tomatoStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] tomatoStates(BlockState state, TomatoCropBlock block, String modelName,
                                           String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] =
                new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()), new ResourceLocation(AllYouCanEat.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty())))
                .renderType("cutout"));

        return models;
    }

    private void cakeBlock(RegistryObject<Block> cake) {
        getVariantBuilder(cake.get()).partialState().with(BlockStateProperties.BITES, 0).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(cake.get())
                        .getPath()))).addModel();

        for (int i = 1; i <= 6; i++) {
            getVariantBuilder(cake.get()).partialState().with(BlockStateProperties.BITES, i).modelForState()
                    .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                            "block/" + ForgeRegistries.BLOCKS.getKey(cake.get())
                            .getPath() + "_slice" + i))).addModel();
        }
    }

    private void candleCakeBlock(RegistryObject<Block> candleCake) {
        getVariantBuilder(candleCake.get()).partialState().with(BlockStateProperties.LIT, false).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(candleCake.get())
                        .getPath()))).addModel();

        getVariantBuilder(candleCake.get()).partialState().with(BlockStateProperties.LIT, true).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(candleCake.get())
                        .getPath() + "_lit"))).addModel();
    }

    private void layeredCauldron(RegistryObject<Block> cauldronBlock) {
        getVariantBuilder(cauldronBlock.get()).partialState().with(LayeredCauldronBlock.LEVEL, 1).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(cauldronBlock.get())
                        .getPath() + "_level1"))).addModel();

        getVariantBuilder(cauldronBlock.get()).partialState().with(LayeredCauldronBlock.LEVEL, 2).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(cauldronBlock.get())
                        .getPath() + "_level2"))).addModel();

        getVariantBuilder(cauldronBlock.get()).partialState().with(LayeredCauldronBlock.LEVEL, 3).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(cauldronBlock.get())
                        .getPath() + "_full"))).addModel();
    }

    private void pizzaBlock(RegistryObject<Block> pizza) {
        getVariantBuilder(pizza.get()).partialState().with(BlockStatePropertiesInit.BITES, 0).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(pizza.get())
                        .getPath()))).addModel();

        for (int i = 1; i <= 3; i++) {
            getVariantBuilder(pizza.get()).partialState().with(BlockStatePropertiesInit.BITES, i).modelForState()
                    .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                            "block/" + ForgeRegistries.BLOCKS.getKey(pizza.get())
                            .getPath() + "_slice" + i))).addModel();
        }
    }

    private void wineBottleBlock(RegistryObject<Block> wineBottle) {
        getVariantBuilder(wineBottle.get()).partialState().with(BlockStatePropertiesInit.LEVEL_0_3, 0).modelForState()
                .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID, "block" +
                        "/wine_bottle")))
                .addModel();

        for (int i = 1; i <= 3; i++) {
            getVariantBuilder(wineBottle.get()).partialState().with(BlockStatePropertiesInit.LEVEL_0_3, i)
                    .modelForState()
                    .modelFile(new ModelFile.UncheckedModelFile(new ResourceLocation(AllYouCanEat.MOD_ID,
                            "block/" + ForgeRegistries.BLOCKS.getKey(wineBottle.get())
                            .getPath() + "_level" + i))).addModel();
        }
    }

    public void cabinetBlock(Block block, String woodType) {
        this.horizontalBlock(block, (state) -> {
            String suffix = (Boolean) state.getValue(CabinetBlock.OPEN) ? "_open" : "";
            return this.models().orientable(ForgeRegistries.BLOCKS.getKey(block)
                    .getPath() + suffix, new ResourceLocation(AllYouCanEat.MOD_ID,
                    "block/integration/farmersdelight" + "/" + woodType + "_cabinet_side"),
                    new ResourceLocation(AllYouCanEat.MOD_ID, "block/integration" + "/farmersdelight/" + woodType +
                            "_cabinet_front" + suffix), new ResourceLocation(AllYouCanEat.MOD_ID,
                            "block/integration" + "/farmersdelight/" + woodType + "_cabinet_top"));
        });
    }
}
