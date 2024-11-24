package io.github.itamardenkberg.allyoucaneat.datagen;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.core.init.FluidInit;
import io.github.itamardenkberg.allyoucaneat.core.init.TagInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FluidTagProvider extends FluidTagsProvider {
    public FluidTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider,
                            @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, AllYouCanEat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Forge
        this.tag(TagInit.Fluids.RED_WINE).add(FluidInit.SOURCE_RED_WINE.get());
        this.tag(TagInit.Fluids.WHITE_WINE).add(FluidInit.SOURCE_WHITE_WINE.get());

        // Minecraft
        this.tag(FluidTags.WATER)
                .add(FluidInit.SOURCE_RED_WINE.get(), FluidInit.SOURCE_WHITE_WINE.get(),
                        FluidInit.FLOWING_RED_WINE.get(), FluidInit.FLOWING_WHITE_WINE.get());
    }
}
