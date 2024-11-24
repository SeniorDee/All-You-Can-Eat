package io.github.itamardenkberg.allyoucaneat.datagen;

import io.github.itamardenkberg.allyoucaneat.datagen.loot.BlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class LootTableProvider {
    public static net.minecraft.data.loot.LootTableProvider create(PackOutput output) {
        return new net.minecraft.data.loot.LootTableProvider(output, Set.of(),
                List.of(new net.minecraft.data.loot.LootTableProvider.SubProviderEntry(BlockLootTables::new,
                        LootContextParamSets.BLOCK)));
    }


}
