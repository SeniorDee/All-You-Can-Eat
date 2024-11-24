package seniordee.allyoucaneat.common.tileentities;

import seniordee.allyoucaneat.core.init.TileEntitiesInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class HangingSignTileEntity extends HangingSignBlockEntity {
    public HangingSignTileEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return TileEntitiesInit.HANGING_SIGN_TILE_ENTITIES.get();
    }
}
