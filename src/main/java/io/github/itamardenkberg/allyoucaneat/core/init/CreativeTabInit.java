package io.github.itamardenkberg.allyoucaneat.core.init;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabInit {
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
			.create(Registries.CREATIVE_MODE_TAB, AllYouCanEat.MOD_ID);

	public static RegistryObject<CreativeModeTab> MAIN = CREATIVE_MODE_TABS.register("main",
			() -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.RED_WINE_BOTTLE.get()))
					.title(Component.translatable("item_group." + AllYouCanEat.MOD_ID + ".main")).withSearchBar()
					.build());
}
