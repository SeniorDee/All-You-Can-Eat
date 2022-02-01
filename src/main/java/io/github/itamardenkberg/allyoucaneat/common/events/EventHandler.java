package io.github.itamardenkberg.allyoucaneat.common.events;

import java.lang.reflect.Field;
import java.util.Arrays;

import io.github.itamardenkberg.allyoucaneat.AllYouCanEat;
import io.github.itamardenkberg.allyoucaneat.core.config.CommonConfig;
import io.github.itamardenkberg.allyoucaneat.core.init.ItemInit;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = AllYouCanEat.MOD_ID, bus = Bus.FORGE)
public class EventHandler {
	@SubscribeEvent
	public static void onPlayerLogging(ClientPlayerNetworkEvent.LoggedInEvent event) {
		ItemInit.addSeeds();
		ItemInit.compstables();
	}

	@SubscribeEvent
	public static void onBlockBroken(BlockEvent.BreakEvent event)
			throws IllegalArgumentException, IllegalAccessException {
		CommonConfig config = new CommonConfig();
		if (!event.getWorld().isRemote()) {
			if ((event.getPlayer().getHeldItemMainhand().getItem() != Items.SHEARS)
					&& (!event.getPlayer().isCreative())) {
				if (event.getState().getBlock() == Blocks.GRASS || event.getState().getBlock() == Blocks.TALL_GRASS
						|| event.getState().getBlock() == Blocks.FERN
						|| event.getState().getBlock() == Blocks.LARGE_FERN) {
					for (Item seed : ItemInit.seeds) {
						Field[] fields = CommonConfig.class.getFields();
						Field[] filteredList = Arrays.stream(fields).filter(x -> x.getName().contains(seed.toString()))
								.toArray(Field[]::new);
						for (Field fieldInfo : filteredList) {;
							if (fieldInfo.getName().contains(seed.toString())
									&& fieldInfo.getType() == ConfigValue.class) {
								@SuppressWarnings("unchecked")
								ConfigValue<? extends Integer> value = (ConfigValue<? extends Integer>) fieldInfo.get(config);
								if (Math.random() <= ((int) value.get()) / 100.0d) {
									event.getWorld().setBlockState(event.getPos(), Blocks.AIR.getDefaultState(), 2);
									event.getWorld()
											.addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
													event.getPos().getY(), event.getPos().getZ(), new ItemStack(seed)));
								}
							}
						}
					}
				}
			}
		}
	}
}