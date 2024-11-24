package seniordee.allyoucaneat.datagen.advancement;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.core.init.ItemInit;
import seniordee.allyoucaneat.core.init.TagInit;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.function.Consumer;

public class AdvancementGenerator implements ForgeAdvancementProvider.AdvancementGenerator {

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver,
                         ExistingFileHelper existingFileHelper) {
        Advancement root = Advancement.Builder.advancement()
                .display(ItemInit.RED_WINE_BOTTLE.get(),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".root.title"),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".root.description"),
                        new ResourceLocation(AllYouCanEat.MOD_ID + ":textures/guis/advancements/backgrounds" +
                                "/hazel.png"), FrameType.TASK, false, false, false)
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(saver, AllYouCanEat.MOD_ID + ":allyoucaneat/root");
        Advancement chocolate = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.CHOCOLATE_BAR.get(),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".chocolate.title"),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".chocolate.description"),
                        null, FrameType.TASK, true, true, false)
                .addCriterion("chocolate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.CHOCOLATE_BAR.get(),
                                ItemInit.WHITE_CHOCOLATE_BAR.get(), ItemInit.CHORUS_CHOCOLATE_BAR.get()))
                .save(saver, AllYouCanEat.MOD_ID + ":allyoucaneat/chocolate");
        Advancement get_grapes = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.BLACK_GRAPE.get(), Component.translatable("advancements." + AllYouCanEat.MOD_ID +
                        ".get_grapes.title"), Component.translatable("advancements." + AllYouCanEat.MOD_ID +
                        ".get_grapes.description"), null, FrameType.TASK, true, true, false)
                .addCriterion("get_grapes",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.BLACK_GRAPE.get(),
                                ItemInit.WHITE_GRAPE.get()))
                .save(saver, AllYouCanEat.MOD_ID + ":allyoucaneat/get_grapes");
        Advancement drink_soul_shake = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.SOUL_SHAKE.get(),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".drink_soul_shake.title"),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".drink_soul_shake" +
                                ".description"), null, FrameType.TASK, true, true, false)
                .addCriterion("drink_soul_shake",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.SOUL_SHAKE.get()))
                .save(saver, AllYouCanEat.MOD_ID + ":allyoucaneat/drink_soul_shake");
        Advancement drink_hot_chocolate = Advancement.Builder.advancement().parent(chocolate)
                .display(ItemInit.HOT_CHOCOLATE.get(),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".drink_hot_chocolate.title"),
                        Component.translatable("advancements." + AllYouCanEat.MOD_ID + ".drink_hot_chocolate" +
                                ".description"), null, FrameType.TASK, true, true, true)
                .addCriterion("drink_hot_chocolate",
                        ConsumeItemTrigger.TriggerInstance.usedItem(ItemInit.HOT_CHOCOLATE.get()))
                .save(saver, AllYouCanEat.MOD_ID + ":allyoucaneat/drink_hot_chocolate");
    }
}
