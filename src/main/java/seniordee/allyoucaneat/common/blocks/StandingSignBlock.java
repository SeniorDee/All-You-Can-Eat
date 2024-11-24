package seniordee.allyoucaneat.common.blocks;

import seniordee.allyoucaneat.common.tileentities.SignTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class StandingSignBlock extends net.minecraft.world.level.block.StandingSignBlock {

	public StandingSignBlock(Properties properties, WoodType type) {
		super(properties, type);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SignTileEntity(pos, state);
	}
}
