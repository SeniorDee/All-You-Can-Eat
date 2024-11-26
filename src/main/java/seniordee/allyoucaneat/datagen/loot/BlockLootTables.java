package seniordee.allyoucaneat.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;
import seniordee.allyoucaneat.common.blocks.*;
import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.ItemInit;
import seniordee.allyoucaneat.core.integrations.farmersdelight.init.FDBlockInit;

import java.util.Set;
import java.util.stream.Stream;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    @Override
    protected void generate() {
        this.dropSelf(BlockInit.BROWN_HAY_BLOCK.get());
        this.dropSelf(BlockInit.HAZEL_BUTTON.get());
        this.dropSelf(BlockInit.HAZEL_DOOR.get());
        this.dropSelf(BlockInit.HAZEL_FENCE.get());
        this.dropSelf(BlockInit.HAZEL_FENCE_GATE.get());
        this.dropSelf(BlockInit.HAZEL_LOG.get());
        this.dropSelf(BlockInit.HAZEL_PLANKS.get());
        this.dropSelf(BlockInit.HAZEL_PRESSURE_PLATE.get());
        this.dropSelf(BlockInit.HAZEL_SAPLING.get());
        this.dropSelf(BlockInit.HAZEL_SLAB.get());
        this.dropSelf(BlockInit.HAZEL_STAIRS.get());
        this.dropSelf(BlockInit.HAZEL_TRAPDOOR.get());
        this.dropSelf(BlockInit.HAZEL_WOOD.get());
        this.dropSelf(BlockInit.STRIPPED_HAZEL_LOG.get());
        this.dropSelf(BlockInit.STRIPPED_HAZEL_WOOD.get());
        this.dropSelf(BlockInit.RED_WINE_BOTTLE.get());
        this.dropSelf(BlockInit.WHITE_WINE_BOTTLE.get());
        this.dropSelf(BlockInit.WINE_BOTTLE.get());
        this.dropSelf(BlockInit.FIG_BUTTON.get());
        this.dropSelf(BlockInit.FIG_DOOR.get());
        this.dropSelf(BlockInit.FIG_FENCE.get());
        this.dropSelf(BlockInit.FIG_FENCE_GATE.get());
        this.dropSelf(BlockInit.FIG_LOG.get());
        this.dropSelf(BlockInit.FIG_PLANKS.get());
        this.dropSelf(BlockInit.FIG_PRESSURE_PLATE.get());
        this.dropSelf(BlockInit.FIG_SAPLING.get());
        this.dropSelf(BlockInit.FIG_SLAB.get());
        this.dropSelf(BlockInit.FIG_STAIRS.get());
        this.dropSelf(BlockInit.FIG_TRAPDOOR.get());
        this.dropSelf(BlockInit.FIG_WOOD.get());
        this.dropSelf(BlockInit.STRIPPED_FIG_LOG.get());
        this.dropSelf(BlockInit.STRIPPED_FIG_WOOD.get());

        this.add(BlockInit.CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.CANDLE));
        this.add(BlockInit.BLACK_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.BLACK_CANDLE));
        this.add(BlockInit.BLUE_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(BlockInit.BROWN_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(BlockInit.CYAN_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(BlockInit.GRAY_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(BlockInit.GREEN_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(BlockInit.LIGHT_BLUE_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(BlockInit.LIGHT_GRAY_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(BlockInit.LIME_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(BlockInit.MAGENTA_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(BlockInit.ORANGE_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(BlockInit.PINK_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(BlockInit.PURPLE_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(BlockInit.RED_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(BlockInit.WHITE_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(BlockInit.YELLOW_CANDLE_CHOCOLATE_CAKE.get(), createCandleCakeDrops(Blocks.YELLOW_CANDLE));
        this.add(BlockInit.CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.CANDLE));
        this.add(BlockInit.BLACK_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.BLACK_CANDLE));
        this.add(BlockInit.BLUE_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.BLUE_CANDLE));
        this.add(BlockInit.BROWN_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.BROWN_CANDLE));
        this.add(BlockInit.CYAN_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.CYAN_CANDLE));
        this.add(BlockInit.GRAY_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.GRAY_CANDLE));
        this.add(BlockInit.GREEN_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.GREEN_CANDLE));
        this.add(BlockInit.LIGHT_BLUE_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.LIGHT_BLUE_CANDLE));
        this.add(BlockInit.LIGHT_GRAY_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.LIGHT_GRAY_CANDLE));
        this.add(BlockInit.LIME_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.LIME_CANDLE));
        this.add(BlockInit.MAGENTA_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.MAGENTA_CANDLE));
        this.add(BlockInit.ORANGE_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.ORANGE_CANDLE));
        this.add(BlockInit.PINK_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.PINK_CANDLE));
        this.add(BlockInit.PURPLE_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.PURPLE_CANDLE));
        this.add(BlockInit.RED_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.RED_CANDLE));
        this.add(BlockInit.WHITE_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.WHITE_CANDLE));
        this.add(BlockInit.YELLOW_CANDLE_STRAWBERRY_CAKE.get(), createCandleCakeDrops(Blocks.YELLOW_CANDLE));

        this.add(BlockInit.BLACK_GRAPE_CROP.get(), createCropDrops(BlockInit.BLACK_GRAPE_CROP.get(),
                ItemInit.BLACK_GRAPE.get(), ItemInit.BLACK_GRAPE_SEEDS.get(),
                lootItemCondiditionBuilder(BlockInit.BLACK_GRAPE_CROP, BlackGrapeCropBlock.AGE, 4)));

        this.add(BlockInit.WHITE_GRAPE_CROP.get(), createCropDrops(BlockInit.WHITE_GRAPE_CROP.get(),
                ItemInit.WHITE_GRAPE.get(), ItemInit.WHITE_GRAPE_SEEDS.get(),
                lootItemCondiditionBuilder(BlockInit.WHITE_GRAPE_CROP, WhiteGrapeCropBlock.AGE, 4)));

        this.add(BlockInit.TOMATO_CROP.get(), createCropDrops(BlockInit.TOMATO_CROP.get(), ItemInit.TOMATO.get(),
                ItemInit.TOMATO_SEEDS.get(), lootItemCondiditionBuilder(BlockInit.TOMATO_CROP, TomatoCropBlock.AGE,
                        4)));

        this.add(BlockInit.BROWN_WHEAT_CROP.get(), createCropDrops(BlockInit.BROWN_WHEAT_CROP.get(),
                ItemInit.BROWN_WHEAT.get(), ItemInit.BROWN_WHEAT_SEEDS.get(),
                lootItemCondiditionBuilder(BlockInit.BROWN_WHEAT_CROP, BrownWheatCropBlock.AGE, 7)));

        this.add(BlockInit.STRAWBERRY_BUSH.get(), (block) -> {
            return this.applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool()
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockInit.STRAWBERRY_BUSH.get())
                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                            .hasProperty(StrawberryBushBlock.AGE, 3)))
                            .add(LootItem.lootTableItem(ItemInit.STRAWBERRY.get()))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                    .withPool(LootPool.lootPool()
                            .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(BlockInit.STRAWBERRY_BUSH.get())
                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                            .hasProperty(StrawberryBushBlock.AGE, 2)))
                            .add(LootItem.lootTableItem(ItemInit.STRAWBERRY.get()))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                            .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
        });

        this.add(BlockInit.CHOCOLATE_CAKE.get(), noDrop());
        this.add(BlockInit.STRAWBERRY_CAKE.get(), noDrop());
        this.add(BlockInit.PIZZA.get(), noDrop());

        this.add(BlockInit.HAZEL_SIGN.get(), block -> createSingleItemTable(ItemInit.HAZEL_SIGN_ITEM.get()));
        this.add(BlockInit.HAZEL_WALL_SIGN.get(), block -> createSingleItemTable(ItemInit.HAZEL_SIGN_ITEM.get()));
        this.add(BlockInit.HAZEL_HANGING_SIGN.get(),
                block -> createSingleItemTable(ItemInit.HAZEL_HANGING_SIGN_ITEM.get()));
        this.add(BlockInit.HAZEL_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(ItemInit.HAZEL_HANGING_SIGN_ITEM.get()));
        this.add(BlockInit.FIG_SIGN.get(), block -> createSingleItemTable(ItemInit.FIG_SIGN_ITEM.get()));
        this.add(BlockInit.FIG_WALL_SIGN.get(), block -> createSingleItemTable(ItemInit.FIG_SIGN_ITEM.get()));
        this.add(BlockInit.FIG_HANGING_SIGN.get(),
                block -> createSingleItemTable(ItemInit.FIG_HANGING_SIGN_ITEM.get()));
        this.add(BlockInit.FIG_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(ItemInit.FIG_HANGING_SIGN_ITEM.get()));

        this.dropOther(BlockInit.MILK_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(BlockInit.RED_WINE_CAULDRON.get(), Blocks.CAULDRON);
        this.dropOther(BlockInit.WHITE_WINE_CAULDRON.get(), Blocks.CAULDRON);

        this.add(BlockInit.HAZEL_LEAVES.get(), (block) -> this.createHazelLeavesDrops(block, Blocks.OAK_SAPLING,
                NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(BlockInit.FIG_LEAVES.get(), (block) -> this.createFigLeavesDrops(block, Blocks.OAK_SAPLING,
                NORMAL_LEAVES_SAPLING_CHANCES));

        // Farmer's Delight
        if (ModList.get().isLoaded("farmersdelight")) {
            this.add(FDBlockInit.HAZEL_CABINET.get(), this::createNameableBlockEntityTable);
            this.add(FDBlockInit.FIG_CABINET.get(), this::createNameableBlockEntityTable);
        }
    }

    protected LootItemCondition.Builder lootItemCondiditionBuilder(RegistryObject<Block> block, IntegerProperty age,
                                                                   int value) {
        return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, value));
    }

    protected LootTable.Builder createHazelLeavesDrops(Block pOakLeavesBlock, Block pSaplingBlock, float... pChances) {
        return this.createLeavesDrops(pOakLeavesBlock, pSaplingBlock, pChances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionCondition(pOakLeavesBlock,
                                        LootItem.lootTableItem(ItemInit.HAZELNUT.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                                        0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    protected LootTable.Builder createFigLeavesDrops(Block pOakLeavesBlock, Block pSaplingBlock, float... pChances) {
        return this.createLeavesDrops(pOakLeavesBlock, pSaplingBlock, pChances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionCondition(pOakLeavesBlock, LootItem.lootTableItem(ItemInit.FIG.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                                        0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        if (ModList.get().isLoaded("farmersdelight")) {
            return Stream.concat(BlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get), FDBlockInit.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get))::iterator;
        } else {
            return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
        }
    }

}
