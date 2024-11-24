package io.github.itamardenkberg.allyoucaneat.datagen;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.core.init.BlockInit;
import io.github.itamardenkberg.allyoucaneat.core.init.ItemInit;
import io.github.itamardenkberg.allyoucaneat.core.integrations.farmersdelight.init.FDItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {

    public ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AllYouCanEat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemInit.BLACK_GRAPE);
        simpleItem(ItemInit.WHITE_GRAPE);
        simpleItem(ItemInit.BLACK_GRAPE_SEEDS);
        simpleItem(ItemInit.WHITE_GRAPE_SEEDS);
        simpleItem(ItemInit.BROWN_WHEAT);
        simpleItem(ItemInit.BROWN_WHEAT_SEEDS);
        simpleItem(ItemInit.CHEESE);
        simpleItem(ItemInit.CHILI_PEPPER);
        simpleItem(ItemInit.CHOCOLATE_BAR);
        simpleItem(ItemInit.CHOCOLATE_BAR_WITH_NUTS);
        simpleItem(ItemInit.CHORUS_CHOCOLATE_BAR);
        simpleItem(ItemInit.CHORUS_CHOCOLATE_COVERED_STRAWBERRY);
        simpleItem(ItemInit.CHOCOLATE_COVERED_STRAWBERRY);
        simpleItem(ItemInit.GELATIN);
        simpleItem(ItemInit.HAZEL_BOAT);
        simpleItem(ItemInit.HAZEL_CHEST_BOAT);
        simpleItem(ItemInit.HAZELNUT);
        simpleItem(ItemInit.HOT_CHOCOLATE);
        simpleItem(ItemInit.MARSHMALLOW_ON_A_STICK);
        simpleItem(ItemInit.MILK_BOTTLE);
        simpleItem(ItemInit.PARROTFRUIT);
        simpleItem(ItemInit.RAISIN_COOKIE);
        simpleItem(ItemInit.RAISINS);
        simpleItem(ItemInit.RED_WINE_BUCKET);
        simpleItem(ItemInit.RED_WINE_GLASS);
        simpleItem(ItemInit.ROASTED_MARSHMALLOW_ON_A_STICK);
        simpleItem(ItemInit.SOUL_BOTTLE);
        simpleItem(ItemInit.SOUL_SHAKE);
        simpleItem(ItemInit.STRAWBERRY);
        simpleItem(ItemInit.STRAWBERRY_JAM);
        simpleItem(ItemInit.SUGARED_STRAWBERRY);
        simpleItem(ItemInit.TOMATO);
        simpleItem(ItemInit.TOMATO_SEEDS);
        simpleItem(ItemInit.WHITE_CHOCOLATE_BAR);
        simpleItem(ItemInit.WHITE_CHOCOLATE_COVERED_STRAWBERRY);
        simpleItem(ItemInit.WHITE_WINE_BUCKET);
        simpleItem(ItemInit.WHITE_WINE_GLASS);
        simpleItem(ItemInit.WINE_GLASS);
        simpleItem(ItemInit.HAZEL_SIGN_ITEM);
        simpleItem(ItemInit.HAZEL_HANGING_SIGN_ITEM);

        simpleBlockItem(BlockInit.PIZZA);
        simpleBlockItem(BlockInit.CHOCOLATE_CAKE);
        simpleBlockItem(BlockInit.STRAWBERRY_CAKE);
        simpleBlockItem(BlockInit.HAZEL_DOOR);
        simpleBlockItem(BlockInit.RED_WINE_BOTTLE);
        simpleBlockItem(BlockInit.WHITE_WINE_BOTTLE);
        simpleBlockItem(BlockInit.WINE_BOTTLE);

        buttonItem(BlockInit.HAZEL_BUTTON, BlockInit.HAZEL_PLANKS);

        fenceItem(BlockInit.HAZEL_FENCE, BlockInit.HAZEL_PLANKS);

        trapdoorItem(BlockInit.HAZEL_TRAPDOOR);

        evenSimplerBlockItem(BlockInit.HAZEL_STAIRS);
        evenSimplerBlockItem(BlockInit.HAZEL_SLAB);
        evenSimplerBlockItem(BlockInit.HAZEL_PRESSURE_PLATE);
        evenSimplerBlockItem(BlockInit.HAZEL_FENCE_GATE);

        saplingItem(BlockInit.HAZEL_SAPLING);

        // Farmers Delight
        if (ModList.get().isLoaded("farmersdelight")) {
            simpleItem(FDItemInit.CHOCOLATE_CAKE_SLICE);
            simpleItem(FDItemInit.STRAWBERRY_CAKE_SLICE);
            simpleItem(FDItemInit.PIZZA_SLICE);
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId()
                .getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AllYouCanEat.MOD_ID, "item/" + item.getId()
                .getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId()
                .getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AllYouCanEat.MOD_ID, "item/" + item.getId()
                .getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(AllYouCanEat.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get())
                .getPath(), modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get())
                .getPath(), modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get())
                        .getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(AllYouCanEat.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get())
                        .getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId()
                .getPath(), new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AllYouCanEat.MOD_ID, "block/" + item.getId()
                .getPath()));
    }
}
