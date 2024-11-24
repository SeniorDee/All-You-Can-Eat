package seniordee.allyoucaneat.common.tileentities;

import seniordee.allyoucaneat.core.init.TileEntitiesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WhiteWineCauldronTileEntity extends BlockEntity {
	public WhiteWineCauldronTileEntity(BlockPos pos, BlockState state) {
		super(TileEntitiesInit.WHITE_WINE_CAULDRON_TILE_ENTITY.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
}