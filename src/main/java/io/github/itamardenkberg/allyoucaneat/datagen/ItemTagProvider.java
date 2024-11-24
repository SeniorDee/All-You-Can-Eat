package io.github.itamardenkberg.allyoucaneat.datagen;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.core.init.BlockInit;
import io.github.itamardenkberg.allyoucaneat.core.init.ItemInit;
import io.github.itamardenkberg.allyoucaneat.core.init.TagInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {

    public ItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                           CompletableFuture<TagLookup<Block>> pBlockTags,
                           @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, AllYouCanEat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        // AYCE
        this.tag(TagInit.Items.HAZEL_LOGS)
                .add(ItemInit.HAZEL_LOG.get(), ItemInit.STRIPPED_HAZEL_LOG.get(), ItemInit.HAZEL_WOOD.get(),
                        ItemInit.STRIPPED_HAZEL_WOOD.get());

        // Forge
        this.tag(TagInit.Items.CROPS_BROWN_WHEAT).add(ItemInit.BROWN_WHEAT.get());
        this.tag(TagInit.Items.CROPS_TOMATO).add(ItemInit.TOMATO.get());
        this.tag(TagInit.Items.DESERTS_CHOCOLATE).add(ItemInit.CHOCOLATE_BAR.get());
        this.tag(TagInit.Items.DESERTS_CHOCOLATE_WITH_NUTS).add(ItemInit.CHOCOLATE_BAR_WITH_NUTS.get());
        this.tag(TagInit.Items.DESERTS_CHORUS_CHOCOLATE).add(ItemInit.CHORUS_CHOCOLATE_BAR.get());
        this.tag(TagInit.Items.DESERTS_WHITE_CHOCOLATE).add(ItemInit.WHITE_CHOCOLATE_BAR.get());
        this.tag(TagInit.Items.FRUITS_BLACK_GRAPES).add(ItemInit.BLACK_GRAPE.get());
        this.tag(TagInit.Items.FRUITS_GRAPES).addTag(TagInit.Items.FRUITS_BLACK_GRAPES)
                .addTag(TagInit.Items.FRUITS_WHITE_GRAPES);
        this.tag(TagInit.Items.FRUITS_HAZELNUTS).add(ItemInit.HAZELNUT.get());
        this.tag(TagInit.Items.FRUITS_STRAWBERRIES).add(ItemInit.STRAWBERRY.get());
        this.tag(TagInit.Items.FRUITS_WHITE_GRAPES).add(ItemInit.WHITE_GRAPE.get());
        this.tag(TagInit.Items.SEEDS_BROWN_WHEAT).add(ItemInit.BROWN_WHEAT_SEEDS.get());
        this.tag(TagInit.Items.SEEDS_GRAPE).add(ItemInit.WHITE_GRAPE_SEEDS.get(), ItemInit.BLACK_GRAPE_SEEDS.get());
        this.tag(TagInit.Items.SEEDS_TOMATO).add(ItemInit.TOMATO_SEEDS.get());
        this.tag(TagInit.Items.VEGETABLES_TOMATO).add(ItemInit.TOMATO.get());
        this.tag(TagInit.Items.BRICKS).addTag(Tags.Items.INGOTS_BRICK);
        this.tag(TagInit.Items.CHEESE).add(ItemInit.CHEESE.get());
        this.tag(TagInit.Items.CHOCOLATE).addTag(TagInit.Items.DESERTS_CHOCOLATE)
                .addTag(TagInit.Items.DESERTS_CHORUS_CHOCOLATE).addTag(TagInit.Items.DESERTS_CHOCOLATE_WITH_NUTS)
                .addTag(TagInit.Items.DESERTS_WHITE_CHOCOLATE);
        this.tag(TagInit.Items.FOODS).add(ItemInit.RED_WINE_GLASS.get(), ItemInit.WHITE_WINE_GLASS.get())
                .addTag(TagInit.Items.FRUITS).addTag(TagInit.Items.VEGETABLES).addTag(TagInit.Items.NUTS)
                .addTag(TagInit.Items.MARSHMALLOWS).addTag(TagInit.Items.SUGAR).addTag(Tags.Items.EGGS)
                .addTag(TagInit.Items.WHEAT).addTag(TagInit.Items.CHOCOLATE)
                .addTag(TagInit.Items.CHOCOLATE_COVERED_STRAWBERRIES).addTag(TagInit.Items.RAISINS)
                .addTag(TagInit.Items.COOKIES).addTag(TagInit.Items.CHEESE)
                .add(ItemInit.SUGARED_STRAWBERRY.get(), ItemInit.STRAWBERRY_JAM.get(), ItemInit.HOT_CHOCOLATE.get(),
                        ItemInit.CHILI_PEPPER.get(), ItemInit.PARROTFRUIT.get(), ItemInit.SOUL_SHAKE.get());
        this.tag(TagInit.Items.FRUITS).addTag(TagInit.Items.FRUITS_STRAWBERRIES).addTag(TagInit.Items.NUTS)
                .addTag(TagInit.Items.FRUITS_GRAPES);
        this.tag(TagInit.Items.HAY_BLOCKS).add(Items.HAY_BLOCK, ItemInit.BROWN_HAY_BLOCK.get());
        this.tag(TagInit.Items.HOT_CHOCOLATE).add(ItemInit.HOT_CHOCOLATE.get());
        this.tag(TagInit.Items.MARSHMALLOWS)
                .add(ItemInit.MARSHMALLOW_ON_A_STICK.get(), ItemInit.ROASTED_MARSHMALLOW_ON_A_STICK.get());
        this.tag(TagInit.Items.MILK).add(ItemInit.MILK_BOTTLE.get());
        this.tag(TagInit.Items.NUTS).add(ItemInit.HAZELNUT.get());
        this.tag(Tags.Items.SEEDS).addTag(TagInit.Items.SEEDS_TOMATO).addTag(TagInit.Items.SEEDS_GRAPE)
                .addTag(TagInit.Items.SEEDS_BROWN_WHEAT);
        this.tag(TagInit.Items.SUGAR).add(Items.SUGAR);
        this.tag(TagInit.Items.WHEAT).addTag(Tags.Items.CROPS_WHEAT).addTag(TagInit.Items.CROPS_BROWN_WHEAT);
        this.tag(TagInit.Items.WINES).add(ItemInit.RED_WINE_BOTTLE.get(), ItemInit.WHITE_WINE_BOTTLE.get());
        this.tag(TagInit.Items.BROWN_WHEAT).add(ItemInit.BROWN_WHEAT.get());
        this.tag(Tags.Items.CROPS).addTag(TagInit.Items.CROPS_BROWN_WHEAT).addTag(TagInit.Items.FRUITS_STRAWBERRIES)
                .addTag(TagInit.Items.FRUITS_GRAPES);
        this.tag(TagInit.Items.RAISINS).add(ItemInit.RAISINS.get());
        this.tag(TagInit.Items.GRAIN).addTag(TagInit.Items.BROWN_WHEAT);
        this.tag(Tags.Items.FENCE_GATES_WOODEN).add(ItemInit.HAZEL_FENCE_GATE.get());
        this.tag(Tags.Items.FENCE_GATES).add(ItemInit.HAZEL_FENCE_GATE.get());
        this.tag(TagInit.Items.MILK_BOTTLE).add(ItemInit.MILK_BOTTLE.get());
        this.tag(TagInit.Items.MILK_BUCKET).add(Items.MILK_BUCKET);
        this.tag(TagInit.Items.COOKED_BEEF).add(Items.COOKED_BEEF);
        this.tag(TagInit.Items.COOKIES).add(Items.COOKIE, ItemInit.RAISIN_COOKIE.get());
        this.tag(TagInit.Items.BERRIES).addTag(TagInit.Items.FRUITS_STRAWBERRIES)
                .addTag(TagInit.Items.CHOCOLATE_COVERED_STRAWBERRIES);
        this.tag(TagInit.Items.VEGETABLES).addTag(TagInit.Items.VEGETABLES_TOMATO);
        this.tag(TagInit.Items.CHOCOLATE_COVERED_STRAWBERRIES)
                .add(ItemInit.CHOCOLATE_COVERED_STRAWBERRY.get(), ItemInit.WHITE_CHOCOLATE_COVERED_STRAWBERRY.get(),
                        ItemInit.CHORUS_CHOCOLATE_COVERED_STRAWBERRY.get());

        // Minecraft
        this.tag(ItemTags.BOATS).add(ItemInit.HAZEL_BOAT.get(), ItemInit.HAZEL_CHEST_BOAT.get());
        this.tag(ItemTags.FENCE_GATES).add(ItemInit.HAZEL_FENCE_GATE.get());
        this.tag(ItemTags.FENCES).add(ItemInit.HAZEL_FENCE.get());
        this.tag(ItemTags.LEAVES).add(ItemInit.HAZEL_LEAVES.get());
        this.tag(ItemTags.LOGS).addTag(TagInit.Items.HAZEL_LOGS);
        this.tag(ItemTags.LOGS_THAT_BURN).addTag(TagInit.Items.HAZEL_LOGS);
        this.tag(ItemTags.PLANKS).add(ItemInit.HAZEL_PLANKS.get());
        this.tag(ItemTags.SAPLINGS).add(ItemInit.HAZEL_SAPLING.get());
        this.tag(ItemTags.SIGNS).add(ItemInit.HAZEL_SIGN_ITEM.get());
        this.tag(ItemTags.WOODEN_BUTTONS).add(ItemInit.HAZEL_BUTTON.get());
        this.tag(ItemTags.WOODEN_DOORS).add(ItemInit.HAZEL_DOOR.get());
        this.tag(ItemTags.WOODEN_FENCES).add(ItemInit.HAZEL_FENCE.get());
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES).add(ItemInit.HAZEL_PRESSURE_PLATE.get());
        this.tag(ItemTags.WOODEN_SLABS).add(ItemInit.HAZEL_SLAB.get());
        this.tag(ItemTags.WOODEN_STAIRS).add(ItemInit.HAZEL_STAIRS.get());
        this.tag(ItemTags.WOODEN_TRAPDOORS).add(ItemInit.HAZEL_TRAPDOOR.get());
        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).addTag(TagInit.Items.SEEDS_TOMATO)
                .addTag(TagInit.Items.SEEDS_BROWN_WHEAT);
        this.tag(ItemTags.FOX_FOOD).addTag(TagInit.Items.FRUITS_STRAWBERRIES);

        // Serene Seasons
        if (ModList.get().isLoaded("sereneseasons")) {
            this.tag(TagInit.Items.AUTUMN_CROPS)
                    .add(ItemInit.BLACK_GRAPE_SEEDS.get(), ItemInit.WHITE_GRAPE_SEEDS.get(),
                            ItemInit.HAZEL_SAPLING.get(), ItemInit.BROWN_WHEAT_SEEDS.get());
            this.tag(TagInit.Items.SUMMER_CROPS)
                    .add(ItemInit.BLACK_GRAPE_SEEDS.get(), ItemInit.WHITE_GRAPE_SEEDS.get(),
                            ItemInit.HAZEL_SAPLING.get(), ItemInit.BROWN_WHEAT_SEEDS.get(),
                            ItemInit.TOMATO_SEEDS.get(), ItemInit.STRAWBERRY.get());
        }
    }
}
