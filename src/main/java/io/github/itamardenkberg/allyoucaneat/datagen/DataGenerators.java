package io.github.itamardenkberg.allyoucaneat.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.datagen.advancement.AdvancementGenerator;
import io.github.itamardenkberg.allyoucaneat.datagen.advancement.AdvancementProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AllYouCanEat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new RecipeProvider(output));
        generator.addProvider(event.includeServer(), LootTableProvider.create(output));

        generator.addProvider(event.includeClient(), new BlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new BlockModelProvider(output, existingFileHelper));

        BlockTagProvider blockTagProvider = generator.addProvider(event.includeServer(), new BlockTagProvider(output,
                lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ItemTagProvider(output, lookupProvider,
                blockTagProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new FluidTagProvider(output, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new WorldGenProvider(output, lookupProvider));

        generator.addProvider(event.includeServer(), new AdvancementProvider(output, lookupProvider,
                existingFileHelper));
    }
}
