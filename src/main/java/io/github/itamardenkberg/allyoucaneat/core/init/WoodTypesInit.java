package io.github.itamardenkberg.allyoucaneat.core.init;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class WoodTypesInit {
	public static WoodType HAZEL = WoodType.register(new WoodType(AllYouCanEat.MOD_ID + ":hazel", BlockSetType.OAK));
}
