package io.github.itamardenkberg.allyoucaneat.common.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class ShapelessRecipeHelper extends ShapelessRecipeBuilder {
    public ShapelessRecipeHelper(RecipeCategory pCategory, ItemLike pResult, int pCount) {
        super(pCategory, pResult, pCount);
    }

    public ShapelessRecipeBuilder requires(TagKey<Item> tag, int quantity) {
        for (int i = 0; i < quantity; ++i) {
            this.requires(Ingredient.of(tag));
        }

        return this;
    }
}
