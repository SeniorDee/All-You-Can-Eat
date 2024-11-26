package seniordee.allyoucaneat.core.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.world.features.tree.custom.FigFoliagePlacer;

public class FoliagePlacerInit {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, AllYouCanEat.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<FigFoliagePlacer>> FIG_FOLIAGE_PLACE =
            FOLIAGE_PLACER.register("fig_foliage_placer", () -> new FoliagePlacerType<>(FigFoliagePlacer.CODEC));
}
