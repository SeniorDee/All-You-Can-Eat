package seniordee.allyoucaneat.core.integrations.jade;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.common.tileentities.MilkCauldronTileEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

public enum ComponentProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public ResourceLocation getUid() {
        return JadePlugin.CHEESE_PROCESS_TIME;
    }

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        if (accessor.getServerData().contains("Cheese Process Time")) {
            IElementHelper elements = tooltip.getElementHelper();
            IElement icon = elements.item(new ItemStack(Items.CLOCK), 0.5f).size(new Vec2(10, 10))
                    .translate(new Vec2(0, -1));
            icon.message(null);
            tooltip.add(icon);
            tooltip.append(Component.translatable("jade." + AllYouCanEat.MOD_ID + ".cheese_process_time",
					30 - (accessor.getServerData()
                    .getInt("Cheese Process Time") / 20)));
        }
    }

    @Override
    public void appendServerData(CompoundTag data, BlockAccessor entity) {
        MilkCauldronTileEntity cauldron = (MilkCauldronTileEntity) entity.getBlockEntity();
        data.putInt("Cheese Process Time", cauldron.progress);
    }
}
