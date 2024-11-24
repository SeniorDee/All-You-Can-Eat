package seniordee.allyoucaneat.core.init;

import seniordee.allyoucaneat.AllYouCanEat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class TagInit {
    public static class Blocks {

        // ACYE
        public static final TagKey<Block> CROPS = register("crops");
        public static final TagKey<Block> HAZEL_LOGS = register("hazel_logs");

        // Forge
        public static final TagKey<Block> BRICKS = registerForge("bricks");

        // Serene Seasons
        public static final TagKey<Block> AUTUMN_CROPS = registerSereneSeasons("autumn_crops");
        public static final TagKey<Block> SUMMER_CROPS = registerSereneSeasons("summer_crops");

        private static TagKey<Block> register(String name) {
            return BlockTags.create(new ResourceLocation(AllYouCanEat.MOD_ID, name));
        }

        private static TagKey<Block> registerForge(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

        private static TagKey<Block> registerSereneSeasons(String name) {
            return BlockTags.create(new ResourceLocation("sereneseasons", name));
        }
    }

    public static class Items {
        // AYCE
        public static final TagKey<Item> HAZEL_LOGS = register("hazel_logs");
        public static final TagKey<Item> CHOCOLATE_COVERED_STRAWBERRIES = register("chocolate_covered_strawberries");

        // Forge
        public static final TagKey<Item> FRUITS_GRAPES = registerForge("fruits/grapes");
        public static final TagKey<Item> FRUITS_BLACK_GRAPES = registerForge("fruits/black_grapes");
        public static final TagKey<Item> FRUITS_WHITE_GRAPES = registerForge("fruits/white_grapes");
        public static final TagKey<Item> FRUITS_HAZELNUTS = registerForge("fruits/hazelnuts");
        public static final TagKey<Item> SEEDS_GRAPE = registerForge("seeds/grape");
        public static final TagKey<Item> FOODS = registerForge("foods");
        public static final TagKey<Item> FRUITS = registerForge("fruits");
        public static final TagKey<Item> WINES = registerForge("wines");
        public static final TagKey<Item> MARSHMALLOWS = registerForge("marshmallows");
        public static final TagKey<Item> NUTS = registerForge("nuts");
        public static final TagKey<Item> SEEDS_TOMATO = registerForge("seeds/tomato");
        public static final TagKey<Item> VEGETABLES_TOMATO = registerForge("vegetables/tomato");
        public static final TagKey<Item> VEGETABLES = registerForge("vegetables");
        public static final TagKey<Item> SUGAR = registerForge("sugar");
        public static final TagKey<Item> WHEAT = registerForge("wheat");
        public static final TagKey<Item> FRUITS_STRAWBERRIES = registerForge("fruits/strawberries");
        public static final TagKey<Item> BRICKS = registerForge("bricks");
        public static final TagKey<Item> CROPS_TOMATO = registerForge("crops/tomato");
        public static final TagKey<Item> HOT_CHOCOLATE = registerForge("hot_chocolate");
        public static final TagKey<Item> MILK = registerForge("milk");
        public static final TagKey<Item> CHEESE = registerForge("cheese");
        public static final TagKey<Item> CHOCOLATE = registerForge("chocolate");
        public static final TagKey<Item> DESERTS_CHOCOLATE = registerForge("desert/chocolate");
        public static final TagKey<Item> DESERTS_WHITE_CHOCOLATE = registerForge("desert/white_chocolate");
        public static final TagKey<Item> DESERTS_CHORUS_CHOCOLATE = registerForge("desert/chorus_chocolate");
        public static final TagKey<Item> DESERTS_CHOCOLATE_WITH_NUTS = registerForge("desert/chocolate_with_nuts");
        public static final TagKey<Item> CROPS_BROWN_WHEAT = registerForge("crops/brown_wheat");
        public static final TagKey<Item> SEEDS_BROWN_WHEAT = registerForge("seeds/brown_wheat");
        public static final TagKey<Item> HAY_BLOCKS = registerForge("hay_blocks");
        public static final TagKey<Item> BROWN_WHEAT = registerForge("brown_wheat");
        public static final TagKey<Item> RAISINS = registerForge("raisins");
        public static final TagKey<Item> COOKIES = registerForge("cookies");
        public static final TagKey<Item> BERRIES = registerForge("berries");
        public static final TagKey<Item> GRAIN = registerForge("grain");
        public static final TagKey<Item> MILK_BOTTLE = registerForge("milk/milk_bottle");
        public static final TagKey<Item> MILK_BUCKET = registerForge("milk/milk");
        public static final TagKey<Item> COOKED_BEEF = registerForge("cooked_beef");

        // Serene Seasons
        public static final TagKey<Item> AUTUMN_CROPS = registerSereneSeasons("autumn_crops");
        public static final TagKey<Item> SUMMER_CROPS = registerSereneSeasons("summer_crops");

        private static TagKey<Item> register(String name) {
            return ItemTags.create(new ResourceLocation(AllYouCanEat.MOD_ID, name));
        }

        private static TagKey<Item> registerForge(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        private static TagKey<Item> registerSereneSeasons(String name) {
            return ItemTags.create(new ResourceLocation("sereneseasons", name));
        }
    }

    public static class Fluids {
        // AYCE

        // Forge
        public static final TagKey<Fluid> CHOCOLATE = registerForge("chocolate");
        public static final TagKey<Fluid> RED_WINE = registerForge("red_wine");
        public static final TagKey<Fluid> WHITE_WINE = registerForge("white_wine");

        @SuppressWarnings("unused")
        private static TagKey<Fluid> register(String name) {
            return FluidTags.create(new ResourceLocation(AllYouCanEat.MOD_ID, name));
        }

        private static TagKey<Fluid> registerForge(String name) {
            return FluidTags.create(new ResourceLocation("forge", name));
        }
    }
}
