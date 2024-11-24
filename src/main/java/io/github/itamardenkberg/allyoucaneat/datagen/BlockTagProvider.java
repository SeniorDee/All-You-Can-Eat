package io.github.itamardenkberg.allyoucaneat.datagen;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.core.init.BlockInit;
import io.github.itamardenkberg.allyoucaneat.core.init.ItemInit;
import io.github.itamardenkberg.allyoucaneat.core.init.TagInit;
import io.github.itamardenkberg.allyoucaneat.core.integrations.farmersdelight.init.FDBlockInit;
import io.github.itamardenkberg.allyoucaneat.core.integrations.farmersdelight.init.FDItemInit;
import io.github.itamardenkberg.allyoucaneat.datagen.integration.farmersdelight.FDBlockTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModList;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AllYouCanEat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // AYCE
        this.tag(TagInit.Blocks.HAZEL_LOGS)
                .add(BlockInit.HAZEL_LOG.get(), BlockInit.STRIPPED_HAZEL_LOG.get(), BlockInit.HAZEL_WOOD.get(),
                        BlockInit.STRIPPED_HAZEL_WOOD.get());

        // Forge
        this.tag(TagInit.Blocks.BRICKS).add(Blocks.BRICKS);
        this.tag(TagInit.Blocks.CROPS)
                .add(BlockInit.BLACK_GRAPE_CROP.get(), BlockInit.TOMATO_CROP.get(), BlockInit.WHITE_GRAPE_CROP.get(),
                        BlockInit.BROWN_WHEAT_CROP.get(), BlockInit.STRAWBERRY_BUSH.get());
        this.tag(Tags.Blocks.FENCE_GATES).add(BlockInit.HAZEL_FENCE_GATE.get());
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(BlockInit.HAZEL_FENCE_GATE.get());

        // Minecraft
        this.tag(BlockTags.CANDLE_CAKES)
                .add(BlockInit.CANDLE_CHOCOLATE_CAKE.get(), BlockInit.WHITE_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.ORANGE_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.MAGENTA_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.YELLOW_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.LIME_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.PINK_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.GRAY_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.CYAN_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.PURPLE_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.BLUE_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.BROWN_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.GREEN_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.RED_CANDLE_CHOCOLATE_CAKE.get(), BlockInit.BLACK_CANDLE_CHOCOLATE_CAKE.get(),
                        BlockInit.CANDLE_STRAWBERRY_CAKE.get(), BlockInit.WHITE_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.ORANGE_CANDLE_STRAWBERRY_CAKE.get(), BlockInit.MAGENTA_CANDLE_STRAWBERRY_CAKE.get()
                        , BlockInit.LIGHT_BLUE_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.YELLOW_CANDLE_STRAWBERRY_CAKE.get(), BlockInit.LIME_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.PINK_CANDLE_STRAWBERRY_CAKE.get(), BlockInit.GRAY_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.LIGHT_GRAY_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.CYAN_CANDLE_STRAWBERRY_CAKE.get(), BlockInit.PURPLE_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.BLUE_CANDLE_STRAWBERRY_CAKE.get(), BlockInit.BROWN_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.GREEN_CANDLE_STRAWBERRY_CAKE.get(), BlockInit.RED_CANDLE_STRAWBERRY_CAKE.get(),
                        BlockInit.BLACK_CANDLE_STRAWBERRY_CAKE.get());
        this.tag(BlockTags.CROPS).addTag(TagInit.Blocks.CROPS);
        this.tag(BlockTags.FENCE_GATES).add(BlockInit.HAZEL_FENCE_GATE.get());
        this.tag(BlockTags.LEAVES).add(BlockInit.HAZEL_LEAVES.get());
        this.tag(BlockTags.FENCES).add(BlockInit.HAZEL_FENCE.get());
        this.tag(BlockTags.LOGS).addTag(TagInit.Blocks.HAZEL_LOGS);
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(TagInit.Blocks.HAZEL_LOGS);
        this.tag(BlockTags.PLANKS).add(BlockInit.HAZEL_PLANKS.get());
        this.tag(BlockTags.SAPLINGS).add(BlockInit.HAZEL_SAPLING.get());
        this.tag(BlockTags.STANDING_SIGNS).add(BlockInit.HAZEL_SIGN.get());
        this.tag(BlockTags.WALL_SIGNS).add(BlockInit.HAZEL_WALL_SIGN.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(BlockInit.HAZEL_BUTTON.get());
        this.tag(BlockTags.WOODEN_DOORS).add(BlockInit.HAZEL_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(BlockInit.HAZEL_FENCE.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(BlockInit.HAZEL_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_SLABS).add(BlockInit.HAZEL_SLAB.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(BlockInit.HAZEL_STAIRS.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(BlockInit.HAZEL_TRAPDOOR.get());
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(BlockInit.HAZEL_LOG.get());
        this.tag(BlockTags.MAINTAINS_FARMLAND).addTag(TagInit.Blocks.CROPS);
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(BlockInit.BROWN_HAY_BLOCK.get());
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(BlockInit.HAZEL_HANGING_SIGN.get());
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(BlockInit.HAZEL_WALL_HANGING_SIGN.get());

        // Serene Seasons
        if (ModList.get().isLoaded("sereneseasons")) {
            this.tag(TagInit.Blocks.AUTUMN_CROPS)
                    .add(BlockInit.BLACK_GRAPE_CROP.get(), BlockInit.WHITE_GRAPE_CROP.get(),
                            BlockInit.HAZEL_SAPLING.get(), BlockInit.BROWN_WHEAT_CROP.get());
            this.tag(TagInit.Blocks.SUMMER_CROPS)
                    .add(BlockInit.BLACK_GRAPE_CROP.get(), BlockInit.WHITE_GRAPE_CROP.get(),
                            BlockInit.HAZEL_SAPLING.get(), BlockInit.BROWN_WHEAT_CROP.get(),
                            BlockInit.TOMATO_CROP.get(), BlockInit.STRAWBERRY_BUSH.get());
        }

        // Farmer's Delight
        if (ModList.get().isLoaded("farmersdelight")) {
            this.tag(BlockTags.MINEABLE_WITH_AXE).add(FDBlockInit.HAZEL_CABINET.get());
        }
    }
}
