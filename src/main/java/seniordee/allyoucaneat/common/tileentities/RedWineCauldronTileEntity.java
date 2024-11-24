package io.github.itamardenkberg.allyoucaneat.common.tileentities;

import io.github.itamardenkberg.allyoucaneat.core.init.TileEntitiesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RedWineCauldronTileEntity extends BlockEntity {
	public RedWineCauldronTileEntity(BlockPos pos, BlockState state) {
		super(TileEntitiesInit.RED_WINE_CAULDRON_TILE_ENTITY.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
}