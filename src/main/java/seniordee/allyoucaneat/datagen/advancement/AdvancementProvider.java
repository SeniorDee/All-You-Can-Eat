package seniordee.allyoucaneat.datagen.advancement;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AdvancementProvider extends ForgeAdvancementProvider {

    public AdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries,
                               ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper,
                List.of(new seniordee.allyoucaneat.datagen.advancement.AdvancementGenerator()));
    }
}
