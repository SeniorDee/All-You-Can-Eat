package seniordee.allyoucaneat.common.items;

import seniordee.allyoucaneat.core.init.EffectsInit;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChiliPepperItem extends Item {

	public ChiliPepperItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		if (entity instanceof ServerPlayer) {
			ServerPlayer serverplayerentity = (ServerPlayer) entity;
			CriteriaTriggers.CONSUME_ITEM.trigger(serverplayerentity, stack);
			serverplayerentity.awardStat(Stats.ITEM_USED.get(this));
		}
		if (entity instanceof Player && !((Player) entity).getAbilities().instabuild) {
			stack.shrink(1);
		}

		if (!world.isClientSide) {
			entity.addEffect(new MobEffectInstance(EffectsInit.FLAMING.get(), 600), entity);
			entity.hurt(entity.damageSources().onFire(), 0.5f);
		}

		return super.finishUsingItem(stack, world, entity);
	}
}
