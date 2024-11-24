package seniordee.allyoucaneat.datagen;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.core.init.BlockInit;
import net.minecraft.core.Direction;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockModelProvider extends net.minecraftforge.client.model.generators.BlockModelProvider {
    public BlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AllYouCanEat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        cake(BlockInit.CHOCOLATE_CAKE);
        cake(BlockInit.STRAWBERRY_CAKE);

        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.BLACK_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.BLUE_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.BROWN_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.CYAN_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.GRAY_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.GREEN_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.LIGHT_BLUE_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.LIGHT_GRAY_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.LIME_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.MAGENTA_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.ORANGE_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.PINK_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.PURPLE_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.RED_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.WHITE_CANDLE);
        candleCake(BlockInit.CHOCOLATE_CAKE, Blocks.YELLOW_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.BLACK_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.BLUE_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.BROWN_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.CYAN_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.GRAY_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.GREEN_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.LIGHT_BLUE_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.LIGHT_GRAY_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.LIME_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.MAGENTA_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.ORANGE_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.PINK_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.PURPLE_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.RED_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.WHITE_CANDLE);
        candleCake(BlockInit.STRAWBERRY_CAKE, Blocks.YELLOW_CANDLE);

        pizza(BlockInit.PIZZA);

        layeredCauldron(BlockInit.MILK_CAULDRON);
        layeredCauldron(BlockInit.RED_WINE_CAULDRON);
        layeredCauldron(BlockInit.WHITE_WINE_CAULDRON);

        waterLiquidBlock(BlockInit.RED_WINE_BLOCK);
        waterLiquidBlock(BlockInit.WHITE_WINE_BLOCK);

        emptyWineBottle(BlockInit.WINE_BOTTLE);

        wineBottle(BlockInit.RED_WINE_BOTTLE);
        wineBottle(BlockInit.WHITE_WINE_BOTTLE);
    }

    public void cake(RegistryObject<Block> cakeBlock) {
        generateCakeModel(cakeBlock, "");

        for (int slice = 1; slice <= 6; slice++) {
            generateCakeModel(cakeBlock, "_slice" + slice);
        }
    }

    private void generateCakeModel(RegistryObject<Block> cakeBlock, String sliceSuffix) {
        String cakeName = ForgeRegistries.BLOCKS.getKey(cakeBlock.get()).getPath();
        String modelName = cakeName + sliceSuffix;

        String bottomTexture = "allyoucaneat:block/" + cakeName + "_bottom";
        String sideTexture = "allyoucaneat:block/" + cakeName + "_side";
        String topTexture = "allyoucaneat:block/" + cakeName + "_top";
        String insideTexture = "allyoucaneat:block/" + cakeName + "_inner";

        int fromX = 1 + (sliceSuffix.isEmpty() ? 0 : 2 * Integer.parseInt(sliceSuffix.replace("_slice", "")));
        int toX = 15;
        int fromY = 0;
        int toY = 8;
        int fromZ = 1;
        int toZ = 15;

        ModelBuilder<?> builder = this.getBuilder(modelName).texture("particle", sideTexture)
                .texture("bottom", bottomTexture).texture("top", topTexture).texture("side", sideTexture);

        if (!sliceSuffix.isEmpty()) {
            builder.texture("inside", insideTexture);
        }

        builder.element().from(fromX, fromY, fromZ).to(toX, toY, toZ).face(Direction.DOWN).texture("#bottom")
                .cullface(Direction.DOWN).end().face(Direction.UP).texture("#top").end().face(Direction.NORTH)
                .texture("#side").end().face(Direction.SOUTH).texture("#side").end().face(Direction.EAST)
                .texture("#side").end();

        if (sliceSuffix.isEmpty()) {
            builder.element().from(fromX, fromY, fromZ).to(toX, toY, toZ).face(Direction.WEST).texture("#side").end();
        } else {
            builder.element().from(fromX, fromY, fromZ).to(toX, toY, toZ).face(Direction.WEST).texture("#inside").end();
        }
    }

    public void candleCake(RegistryObject<Block> cakeBlock, Block candleBlock) {
        String cakeName = ForgeRegistries.BLOCKS.getKey(cakeBlock.get()).getPath();
        String candleName = ForgeRegistries.BLOCKS.getKey(candleBlock).getPath();

        String modelName = candleName + "_" + cakeName;
        String litModelName = modelName + "_lit";

        String candleTexture = "minecraft:block/" + candleName;
        String cakeBottomTexture = "allyoucaneat:block/" + cakeName + "_bottom";
        String cakeSideTexture = "allyoucaneat:block/" + cakeName + "_side";
        String cakeTopTexture = "allyoucaneat:block/" + cakeName + "_top";

        this.getBuilder(modelName).parent(new ModelFile.UncheckedModelFile("minecraft:block/template_cake_with_candle"))
                .texture("candle", candleTexture).texture("bottom", cakeBottomTexture).texture("side", cakeSideTexture)
                .texture("top", cakeTopTexture).texture("particle", cakeSideTexture);

        this.getBuilder(litModelName)
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/template_cake_with_candle"))
                .texture("candle", candleTexture + "_lit").texture("bottom", cakeBottomTexture)
                .texture("side", cakeSideTexture).texture("top", cakeTopTexture).texture("particle", cakeSideTexture);
    }

    public void pizza(RegistryObject<Block> pizzaBlock) {
        generatePizzaModel(pizzaBlock, "");

        for (int slice = 1; slice <= 3; slice++) {
            generatePizzaModel(pizzaBlock, "_slice" + slice);
        }
    }

    private void generatePizzaModel(RegistryObject<Block> pizzaBlock, String slice) {
        String pizzaName = ForgeRegistries.BLOCKS.getKey(pizzaBlock.get()).getPath();

        String bottomTexture = "allyoucaneat:block/" + pizzaName + "_bottom";
        String sideTexture = "allyoucaneat:block/" + pizzaName + "_side";
        String topTexture = "allyoucaneat:block/" + pizzaName + "_top";
        String insideTexture = "allyoucaneat:block/" + pizzaName + "_inner";

        ModelBuilder<?> builder = this.getBuilder(pizzaName + slice).texture("particle", bottomTexture)
                .texture("bottom", bottomTexture).texture("inside", insideTexture).texture("side", sideTexture)
                .texture("top", topTexture);

        if (slice.isEmpty()) {
            builder.element().from(1, 0, 1).to(15, 3, 15).face(Direction.DOWN).texture("#bottom")
                    .cullface(Direction.DOWN).end().face(Direction.UP).texture("#top").end().face(Direction.NORTH)
                    .texture("#side").end().face(Direction.SOUTH).texture("#side").end().face(Direction.EAST)
                    .texture("#side").end().face(Direction.WEST).texture("#side").end();
        }

        if (slice.equals("_slice1")) {
            pizzaElement(builder);

            builder.element().from(8, 0, 8).to(15, 3, 15).face(Direction.NORTH).texture("#side")
                    .uvs(1.0f, 13.0f, 8.0f, 16.0f).end().face(Direction.EAST).texture("#side")
                    .uvs(1.0f, 13.0f, 8.0f, 16.0f).end().face(Direction.SOUTH).texture("#side")
                    .uvs(8.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.WEST).texture("#inside")
                    .uvs(8.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.UP).texture("#top")
                    .uvs(8.0f, 8.0f, 15.0f, 15.0f).end().face(Direction.DOWN).texture("#bottom")
                    .uvs(8.0f, 1.0f, 15.0f, 8.0f).end();
        }

        if (slice.equals("_slice2")) {
            pizzaElement(builder);
        }

        if (slice.equals("_slice3")) {
            builder.element().from(1, 0, 1).to(8, 3, 8).face(Direction.NORTH).texture("#side")
                    .uvs(8.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.EAST).texture("#inside")
                    .uvs(8.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.SOUTH).texture("#inside")
                    .uvs(1.0f, 13.0f, 8.0f, 16.0f).end().face(Direction.WEST).texture("#side")
                    .uvs(1.0f, 13.0f, 8.0f, 16.0f).end().face(Direction.UP).texture("#top").uvs(1.0f, 1.0f, 8.0f, 8.0f)
                    .end().face(Direction.DOWN).texture("#bottom").uvs(1.0f, 8.0f, 8.0f, 15.0f).end();
        }
    }

    private void pizzaElement(ModelBuilder<?> builder) {
        builder.element().from(1, 0, 1).to(15, 3, 8).face(Direction.NORTH).texture("#side")
                .uvs(1.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.EAST).texture("#side")
                .uvs(8.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.SOUTH).texture("#inside")
                .uvs(1.0f, 13.0f, 15.0f, 16.0f).end().face(Direction.WEST).texture("#side")
                .uvs(1.0f, 13.0f, 8.0f, 16.0f).end().face(Direction.UP).texture("#top").uvs(1.0f, 1.0f, 15.0f, 8.0f)
                .end().face(Direction.DOWN).texture("#bottom").uvs(1.0f, 8.0f, 15.0f, 15.0f).end();
    }

    public void layeredCauldron(RegistryObject<Block> cauldron) {
        String cauldronName = ForgeRegistries.BLOCKS.getKey(cauldron.get()).getPath();

        String contentTexture = "allyoucaneat:block/" + cauldronName.replace("_cauldron", "") + "_still";
        String cauldronBottomTexture = "minecraft:block/cauldron_bottom";
        String cauldronSideTexture = "minecraft:block/cauldron_side";
        String cauldronTopTexture = "minecraft:block/cauldron_top";
        String cauldronInsideTexture = "minecraft:block/cauldron_inner";

        this.getBuilder(cauldronName + "_full")
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/template_cauldron_full"))
                .texture("content", contentTexture).texture("bottom", cauldronBottomTexture)
                .texture("side", cauldronSideTexture).texture("top", cauldronTopTexture)
                .texture("particle", cauldronSideTexture).texture("inside", cauldronInsideTexture);

        this.getBuilder(cauldronName + "_level1")
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/template_cauldron_level1"))
                .texture("content", contentTexture).texture("bottom", cauldronBottomTexture)
                .texture("side", cauldronSideTexture).texture("top", cauldronTopTexture)
                .texture("particle", cauldronSideTexture).texture("inside", cauldronInsideTexture);

        this.getBuilder(cauldronName + "_level2")
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/template_cauldron_level2"))
                .texture("content", contentTexture).texture("bottom", cauldronBottomTexture)
                .texture("side", cauldronSideTexture).texture("top", cauldronTopTexture)
                .texture("particle", cauldronSideTexture).texture("inside", cauldronInsideTexture);
    }

    public void waterLiquidBlock(RegistryObject<LiquidBlock> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .texture("particle", "minecraft:block/water_still");
    }

    public void wineBottle(RegistryObject<Block> block) {
        for (int level = 1; level <= 3; level++) {
            generateWineBottleModel(block, "_level" + level);
        }
    }

    public void generateWineBottleModel(RegistryObject<Block> block, String level) {
        String bottleName = ForgeRegistries.BLOCKS.getKey(block.get()).getPath();

        ModelBuilder<?> builder = this.getBuilder(bottleName + level)
                .texture("bottle", "allyoucaneat:block/" + bottleName).texture("particle", "minecraft:block/glass")
                .renderType("cutout_mipped");

        if (level.equals("_level1")) {
            wineBottleElement(builder);

            builder.element().from(6.1f, 0.1f, 6.1f).to(9.9f, 3.4f, 9.9f).face(Direction.NORTH).texture("#bottle")
                    .uvs(8.0f, 8.5f, 9.5f, 10.0f).end().face(Direction.EAST).texture("#bottle")
                    .uvs(6.5f, 8.5f, 8f, 10.0f).end().face(Direction.SOUTH).texture("#bottle")
                    .uvs(11.0f, 8.5f, 12.5f, 10.0f).end().face(Direction.WEST).texture("#bottle")
                    .uvs(9.5f, 8.5f, 11.0f, 10.0f).end().face(Direction.UP).texture("#bottle")
                    .uvs(9.5f, 8.5f, 8.0f, 7.0f).end().face(Direction.DOWN).texture("#bottle")
                    .uvs(11.0f, 7.0f, 9.5f, 8.5f).end();
        }

        if (level.equals("_level2")) {
            wineBottleElement(builder);

            builder.element().from(6.1f, 0.1f, 6.1f).to(9.9f, 7.4f, 9.9f).face(Direction.NORTH).texture("#bottle")
                    .uvs(8.0f, 8.5f, 9.5f, 12.0f).end().face(Direction.EAST).texture("#bottle")
                    .uvs(6.5f, 8.5f, 8f, 12.0f).end().face(Direction.SOUTH).texture("#bottle")
                    .uvs(11.0f, 8.5f, 12.5f, 12.0f).end().face(Direction.WEST).texture("#bottle")
                    .uvs(9.5f, 8.5f, 11.0f, 12.0f).end().face(Direction.UP).texture("#bottle")
                    .uvs(9.5f, 8.5f, 8.0f, 7.0f).end().face(Direction.DOWN).texture("#bottle")
                    .uvs(11.0f, 7.0f, 9.5f, 8.5f).end();
        }

        if (level.equals("_level3")) {
            wineBottleElement(builder);

            builder.element().from(6.1f, 0.1f, 6.1f).to(9.9f, 11.0f, 9.9f).face(Direction.NORTH).texture("#bottle")
                    .uvs(8.0f, 8.5f, 9.5f, 13.5f).end().face(Direction.EAST).texture("#bottle")
                    .uvs(6.5f, 8.5f, 8f, 13.5f).end().face(Direction.SOUTH).texture("#bottle")
                    .uvs(11.0f, 8.5f, 12.5f, 13.5f).end().face(Direction.WEST).texture("#bottle")
                    .uvs(9.5f, 8.5f, 11.0f, 13.5f).end().face(Direction.UP).texture("#bottle")
                    .uvs(9.5f, 8.5f, 8.0f, 7.0f).end().face(Direction.DOWN).texture("#bottle")
                    .uvs(11.0f, 7.0f, 9.5f, 8.5f).end();
        }
    }

    public void emptyWineBottle(RegistryObject<Block> block) {
        ModelBuilder<?> builder = this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .texture("bottle", "allyoucaneat:block/red_wine_bottle").texture("particle", "minecraft:block/glass")
                .renderType("cutout_mipped");

        wineBottleElement(builder);
    }

    private void wineBottleElement(ModelBuilder<?> builder) {
        builder.element().from(6, 0, 6).to(10, 13, 10).face(Direction.NORTH).texture("#bottle")
                .uvs(2.0f, 2.0f, 4.0f, 8.5f).end().face(Direction.EAST).texture("#bottle").uvs(0.0f, 2.0f, 2.0f, 8.5f)
                .end().face(Direction.SOUTH).texture("#bottle").uvs(6.0f, 2.0f, 8.0f, 8.5f).end().face(Direction.WEST)
                .texture("#bottle").uvs(4.0f, 2.0f, 6.0f, 8.5f).end().face(Direction.UP).texture("#bottle")
                .uvs(4.0f, 2.0f, 2.0f, 0.0f).end().face(Direction.DOWN).texture("#bottle").uvs(6.0f, 0.0f, 4.0f, 2.0f)
                .end();

        builder.element().from(7, 13, 7).to(9, 16, 9).face(Direction.NORTH).texture("#bottle")
                .uvs(9.0f, 1.0f, 10.0f, 2.5f).end().face(Direction.EAST).texture("#bottle").uvs(8.0f, 1.0f, 9.0f, 2.5f)
                .end().face(Direction.SOUTH).texture("#bottle").uvs(11.0f, 1.0f, 12.0f, 2.5f).end().face(Direction.WEST)
                .texture("#bottle").uvs(10.0f, 1.0f, 11.0f, 2.5f).end().face(Direction.UP).texture("#bottle")
                .uvs(10.0f, 1.0f, 9.0f, 0.0f).end().face(Direction.DOWN).texture("#bottle")
                .uvs(11.0f, 0.0f, 10.0f, 1.0f).end();
    }
}
