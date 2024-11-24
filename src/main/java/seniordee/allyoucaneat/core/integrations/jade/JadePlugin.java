package seniordee.allyoucaneat.core.integrations.jade;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.blocks.MilkCauldronBlock;
import seniordee.allyoucaneat.common.tileentities.MilkCauldronTileEntity;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
	public static final ResourceLocation CHEESE_PROCESS_TIME = new ResourceLocation(AllYouCanEat.MOD_ID,
			"cheese_process_time");

	@Override
	public void register(IWailaCommonRegistration registration) {
		registration.registerBlockDataProvider(ComponentProvider.INSTANCE, MilkCauldronTileEntity.class);
	}

	@Override
	public void registerClient(IWailaClientRegistration registration) {
		registration.registerBlockComponent(ComponentProvider.INSTANCE, MilkCauldronBlock.class);
	}
}
