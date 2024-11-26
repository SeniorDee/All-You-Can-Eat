package seniordee.allyoucaneat.core.init;

import seniordee.allyoucaneat.AllYouCanEat;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodTypesInit {
    public static WoodType HAZEL = WoodType.register(new WoodType(AllYouCanEat.MOD_ID + ":hazel", BlockSetType.OAK));
    public static WoodType FIG = WoodType.register(new WoodType(AllYouCanEat.MOD_ID + ":fig", BlockSetType.OAK));
}
