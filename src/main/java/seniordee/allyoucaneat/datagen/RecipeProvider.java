package seniordee.allyoucaneat.datagen;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.recipes.ShapelessRecipeHelper;
import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.ItemInit;
import io.github.itamardenkberg.allyoucaneat.core.init.TagInit;
import io.github.itamardenkberg.allyoucaneat.core.integrations.farmersdelight.init.FDBlockInit;
import io.github.itamardenkberg.allyoucaneat.core.integrations.farmersdelight.init.FDItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.ModList;

import java.util.function.Consumer;

public class RecipeProvider extends net.minecraft.data.recipes.RecipeProvider implements IConditionBuilder {
    public RecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> writer) {
        generateModBlockFamilies(writer, FeatureFlagSet.of(FeatureFlags.VANILLA));

        ShapelessRecipeHelper.shapeless(RecipeCategory.MISC, ItemInit.BLACK_GRAPE_SEEDS.get())
                .requires(TagInit.Items.FRUITS_BLACK_GRAPES)
                .unlockedBy("has_black_grape", has(TagInit.Items.FRUITS_BLACK_GRAPES)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.MISC, ItemInit.WHITE_GRAPE_SEEDS.get())
                .requires(TagInit.Items.FRUITS_WHITE_GRAPES)
                .unlockedBy("has_white_grape", has(TagInit.Items.FRUITS_WHITE_GRAPES)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.MISC, ItemInit.TOMATO_SEEDS.get())
                .requires(TagInit.Items.VEGETABLES_TOMATO)
                .unlockedBy("has_tomato", has(TagInit.Items.VEGETABLES_TOMATO)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.MISC, ItemInit.BROWN_WHEAT.get(), 9)
                .requires(ItemInit.BROWN_HAY_BLOCK.get())
                .unlockedBy("has_brown_hay_block", has(ItemInit.BROWN_HAY_BLOCK.get())).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.CHOCOLATE_BAR.get(), 3)
                .requires(TagInit.Items.MILK).requires(Ingredient.of(TagInit.Items.SUGAR), 2)
                .requires(Items.COCOA_BEANS, 3).unlockedBy("has_milk", has(TagInit.Items.MILK))
                .unlockedBy("has_sugar", has(TagInit.Items.SUGAR)).unlockedBy("has_cocoa", has(Items.COCOA_BEANS))
                .save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.WHITE_CHOCOLATE_BAR.get(), 3)
                .requires(Ingredient.of(TagInit.Items.MILK), 2).requires(Ingredient.of(TagInit.Items.SUGAR), 2)
                .requires(Items.COCOA_BEANS, 2).unlockedBy("has_milk", has(TagInit.Items.MILK))
                .unlockedBy("has_sugar", has(TagInit.Items.SUGAR)).unlockedBy("has_cocoa", has(Items.COCOA_BEANS))
                .save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.CHOCOLATE_BAR_WITH_NUTS.get())
                .requires(TagInit.Items.DESERTS_CHOCOLATE).requires(Ingredient.of(TagInit.Items.NUTS), 2)
                .unlockedBy("has_chocolate", has(TagInit.Items.DESERTS_CHOCOLATE))
                .unlockedBy("has_nuts", has(TagInit.Items.NUTS)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.CHOCOLATE_COVERED_STRAWBERRY.get(), 1)
                .requires(TagInit.Items.FRUITS_STRAWBERRIES).requires(TagInit.Items.DESERTS_CHOCOLATE)
                .unlockedBy("has_strawberry", has(TagInit.Items.FRUITS_STRAWBERRIES))
                .unlockedBy("has_chocolate", has(TagInit.Items.DESERTS_CHOCOLATE)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.WHITE_CHOCOLATE_COVERED_STRAWBERRY.get(), 1)
                .requires(TagInit.Items.FRUITS_STRAWBERRIES).requires(TagInit.Items.DESERTS_WHITE_CHOCOLATE)
                .unlockedBy("has_strawberry", has(TagInit.Items.FRUITS_STRAWBERRIES))
                .unlockedBy("has_white_chocolate", has(TagInit.Items.DESERTS_WHITE_CHOCOLATE)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.CHORUS_CHOCOLATE_BAR.get(), 3)
                .requires(TagInit.Items.MILK).requires(Ingredient.of(TagInit.Items.SUGAR), 2)
                .requires(Items.COCOA_BEANS).requires(Items.CHORUS_FRUIT, 2)
                .unlockedBy("has_milk", has(TagInit.Items.MILK)).unlockedBy("has_sugar", has(TagInit.Items.SUGAR))
                .unlockedBy("has_cocoa", has(Items.COCOA_BEANS)).unlockedBy("has_chorus_fruit", has(Items.CHORUS_FRUIT))
                .save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.CHORUS_CHOCOLATE_COVERED_STRAWBERRY.get(), 1)
                .requires(TagInit.Items.FRUITS_STRAWBERRIES).requires(TagInit.Items.DESERTS_CHORUS_CHOCOLATE)
                .unlockedBy("has_strawberry", has(TagInit.Items.FRUITS_STRAWBERRIES))
                .unlockedBy("has_chorus_chocolate", has(TagInit.Items.DESERTS_CHORUS_CHOCOLATE)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.HOT_CHOCOLATE.get()).requires(TagInit.Items.MILK)
                .requires(Items.GLASS_BOTTLE).requires(Items.COCOA_BEANS)
                .unlockedBy("has_milk", has(TagInit.Items.MILK)).unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
                .unlockedBy("has_cocoa", has(Items.COCOA_BEANS)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.MARSHMALLOW_ON_A_STICK.get())
                .requires(ItemInit.GELATIN.get()).requires(TagInit.Items.SUGAR).requires(Items.WATER_BUCKET)
                .requires(Items.STICK).unlockedBy("has_gelatin", has(ItemInit.GELATIN.get()))
                .unlockedBy("has_water_bucket", has(Items.WATER_BUCKET)).unlockedBy("has_stick", has(Items.STICK))
                .save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.MILK_BOTTLE.get(), 4)
                .requires(TagInit.Items.MILK_BUCKET).requires(Items.GLASS_BOTTLE, 4)
                .unlockedBy("has_milk_bucket", has(TagInit.Items.MILK_BUCKET))
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, Items.MILK_BUCKET).requires(Items.BUCKET)
                .requires(Ingredient.of(TagInit.Items.MILK_BOTTLE), 4)
                .unlockedBy("has_milk_bottle", has(TagInit.Items.MILK_BOTTLE))
                .unlockedBy("has_bucket", has(Items.BUCKET)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.SOUL_SHAKE.get())
                .requires(ItemInit.SOUL_BOTTLE.get()).requires(TagInit.Items.MILK).requires(TagInit.Items.SUGAR)
                .unlockedBy("has_milk", has(TagInit.Items.MILK))
                .unlockedBy("has_soul_bottle", has(ItemInit.SOUL_BOTTLE.get()))
                .unlockedBy("has_sugar", has(TagInit.Items.SUGAR)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.STRAWBERRY_JAM.get())
                .requires(TagInit.Items.FRUITS_STRAWBERRIES).requires(Items.GLASS_BOTTLE)
                .requires(Ingredient.of(TagInit.Items.SUGAR), 2)
                .unlockedBy("has_strawberry", has(TagInit.Items.FRUITS_STRAWBERRIES))
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE))
                .unlockedBy("has_sugar", has(TagInit.Items.SUGAR)).save(writer);
        ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.SUGARED_STRAWBERRY.get())
                .requires(TagInit.Items.FRUITS_STRAWBERRIES).requires(Ingredient.of(TagInit.Items.SUGAR), 3)
                .unlockedBy("has_strawberry", has(TagInit.Items.FRUITS_STRAWBERRIES))
                .unlockedBy("has_sugar", has(TagInit.Items.SUGAR)).save(writer);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemInit.CHOCOLATE_CAKE.get()).define('A', TagInit.Items.MILK)
                .define('B', TagInit.Items.SUGAR).define('C', Tags.Items.CROPS_WHEAT)
                .define('D', TagInit.Items.FRUITS_STRAWBERRIES).define('E', Tags.Items.EGGS).pattern("ADA")
                .pattern("BEB").pattern("CCC").unlockedBy("has_egg", has(Tags.Items.EGGS)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemInit.STRAWBERRY_CAKE.get()).define('A', TagInit.Items.MILK)
                .define('B', TagInit.Items.SUGAR).define('C', Tags.Items.CROPS_WHEAT)
                .define('D', TagInit.Items.DESERTS_CHOCOLATE).define('E', Tags.Items.EGGS).pattern("ADA").pattern("BEB")
                .pattern("CCC").unlockedBy("has_egg", has(Tags.Items.EGGS)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemInit.PIZZA.get()).define('#', TagInit.Items.CHEESE)
                .define('V', TagInit.Items.VEGETABLES_TOMATO).define('C', TagInit.Items.COOKED_BEEF)
                .define('W', Tags.Items.CROPS_WHEAT).pattern("###").pattern("VCV").pattern("WWW")
                .unlockedBy("has_tomato", has(TagInit.Items.VEGETABLES_TOMATO))
                .unlockedBy("has_wheat", has(Tags.Items.CROPS_WHEAT))
                .unlockedBy("has_cooked_beef", has(TagInit.Items.COOKED_BEEF))
                .unlockedBy("has_cheese", has(TagInit.Items.CHEESE)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemInit.RAISIN_COOKIE.get())
                .define('#', TagInit.Items.BROWN_WHEAT).define('A', TagInit.Items.RAISINS).pattern("#A#")
                .unlockedBy("has_raisins", has(TagInit.Items.RAISINS))
                .unlockedBy("has_brown_wheat", has(TagInit.Items.BROWN_WHEAT)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemInit.RED_WINE_BOTTLE.get())
                .define('#', TagInit.Items.FRUITS_BLACK_GRAPES).define('A', ItemInit.WINE_BOTTLE.get()).pattern("###")
                .pattern("#A#").pattern("###").unlockedBy("has_black_grape", has(TagInit.Items.FRUITS_BLACK_GRAPES))
                .unlockedBy("has_wine_bottle", has(ItemInit.WINE_BOTTLE.get())).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ItemInit.WHITE_WINE_BOTTLE.get())
                .define('#', TagInit.Items.FRUITS_WHITE_GRAPES).define('A', ItemInit.WINE_BOTTLE.get()).pattern("###")
                .pattern("#A#").pattern("###").unlockedBy("has_white_grape", has(TagInit.Items.FRUITS_WHITE_GRAPES))
                .unlockedBy("has_wine_bottle", has(ItemInit.WINE_BOTTLE.get())).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.WINE_BOTTLE.get(), 3).define('#', Items.GLASS)
                .pattern("# #").pattern("# #").pattern(" # ").unlockedBy("has_glass", has(Items.GLASS)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.WINE_GLASS.get(), 3).define('#', Items.GLASS_PANE)
                .pattern("# #").pattern(" # ").unlockedBy("has_glass_pane", has(Items.GLASS_PANE)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.SOUL_BOTTLE.get()).define('#', Items.SOUL_SAND)
                .define('G', Items.GLASS_BOTTLE).pattern("###").pattern("#G#").pattern("###")
                .unlockedBy("has_soul_sand", has(Items.SOUL_SAND))
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE)).save(writer);

        threeByThreePackerWithTags(writer, RecipeCategory.BUILDING_BLOCKS, BlockInit.BROWN_HAY_BLOCK.get(),
                TagInit.Items.BROWN_WHEAT, "has_brown_wheat");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.BONE), RecipeCategory.FOOD, ItemInit.GELATIN.get(),
                        0.3F, 200)
                .unlockedBy("has_bone", has(Items.BONE)).save(writer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TagInit.Items.FRUITS_GRAPES), RecipeCategory.FOOD,
                        ItemInit.RAISINS.get(), 0.1F, 200)
                .unlockedBy("has_grapes", has(TagInit.Items.FRUITS_GRAPES)).save(writer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ItemInit.MARSHMALLOW_ON_A_STICK.get()), RecipeCategory.FOOD
                        , ItemInit.ROASTED_MARSHMALLOW_ON_A_STICK.get(), 0.3F, 200)
                .unlockedBy("has_marshmallow", has(ItemInit.MARSHMALLOW_ON_A_STICK.get())).save(writer);

        woodenBoat(writer, ItemInit.HAZEL_BOAT.get(), ItemInit.HAZEL_PLANKS.get());

        chestBoat(writer, ItemInit.HAZEL_CHEST_BOAT.get(), ItemInit.HAZEL_BOAT.get());

        hangingSign(writer, ItemInit.HAZEL_HANGING_SIGN_ITEM.get(), BlockInit.STRIPPED_HAZEL_LOG.get());

        woodFromLogs(writer, BlockInit.HAZEL_WOOD.get(), BlockInit.HAZEL_LOG.get());
        woodFromLogs(writer, BlockInit.STRIPPED_HAZEL_WOOD.get(), BlockInit.STRIPPED_HAZEL_LOG.get());

        // Minecraft
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.BREAD).define('#', Tags.Items.CROPS_WHEAT).pattern("###")
                .unlockedBy("has_wheat", has(Tags.Items.CROPS_WHEAT)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Blocks.CAKE).define('A', TagInit.Items.MILK)
                .define('B', TagInit.Items.SUGAR).define('C', Tags.Items.CROPS_WHEAT).define('E', Tags.Items.EGGS)
                .pattern("AAA").pattern("BEB").pattern("CCC").unlockedBy("has_egg", has(Tags.Items.EGGS)).save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, Items.COOKIE, 8).define('#', Tags.Items.CROPS_WHEAT)
                .define('X', Items.COCOA_BEANS).pattern("#X#").unlockedBy("has_cocoa", has(Items.COCOA_BEANS))
                .save(writer);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Blocks.TARGET).define('H', TagInit.Items.HAY_BLOCKS)
                .define('R', Items.REDSTONE).pattern(" R ").pattern("RHR").pattern(" R ")
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .unlockedBy("has_hay_block", has(TagInit.Items.HAY_BLOCKS)).save(writer);

        // Farmer's Delight
        if (ModList.get().isLoaded("farmersdelight")) {
            ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.PIZZA.get())
                    .requires(FDItemInit.PIZZA_SLICE.get(), 4)
                    .unlockedBy("has_pizza_slice", has(FDItemInit.PIZZA_SLICE.get()))
                    .save(writer, AllYouCanEat.MOD_ID + ":integrations/farmersdelight/pizza_from_slices");
            ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.CHOCOLATE_CAKE.get())
                    .requires(FDItemInit.CHOCOLATE_CAKE_SLICE.get(), 7)
                    .unlockedBy("has_chocolate_cake_slice", has(FDItemInit.CHOCOLATE_CAKE_SLICE.get()))
                    .save(writer, AllYouCanEat.MOD_ID + ":integrations/farmersdelight/chocolate_cake_from_slices");
            ShapelessRecipeHelper.shapeless(RecipeCategory.FOOD, ItemInit.STRAWBERRY_CAKE.get())
                    .requires(FDItemInit.STRAWBERRY_CAKE_SLICE.get(), 7)
                    .unlockedBy("has_strawberry_cake_slice", has(FDItemInit.STRAWBERRY_CAKE_SLICE.get()))
                    .save(writer, AllYouCanEat.MOD_ID + ":integrations/farmersdelight/strawberry_cake_from_slices");
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, FDBlockInit.HAZEL_CABINET.get()).pattern("___")
                    .pattern("D D").pattern("___").define('_', ItemInit.HAZEL_SLAB.get())
                    .define('D', ItemInit.HAZEL_TRAPDOOR.get())
                    .unlockedBy("has_hazel_trapdoor", has(ItemInit.HAZEL_TRAPDOOR.get())).group("fd_cabinet")
                    .save(writer, AllYouCanEat.MOD_ID + ":integrations/farmersdelight/hazel_cabinet");
        }
    }

    protected static void threeByThreePackerWithTags(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                     RecipeCategory pCategory, ItemLike pPacked,
                                                     TagKey<Item> pUnpacked, String pCriterionName) {
        ShapelessRecipeHelper.shapeless(pCategory, pPacked).requires(Ingredient.of(pUnpacked), 9)
                .unlockedBy(pCriterionName, has(pUnpacked)).save(pFinishedRecipeConsumer);
    }

    protected void generateModBlockFamilies(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                            FeatureFlagSet pEnabledFeatures) {
        BlockFamiliesGenerator.getAllFamilies().filter((family) -> {
            return family.shouldGenerateRecipe(pEnabledFeatures);
        }).forEach((family) -> {
            generateRecipes(pFinishedRecipeConsumer, family);
        });
    }
}
