package seniordee.allyoucaneat.common.blocks;

import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.BlockStatePropertiesInit;
import seniordee.allyoucaneat.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WineBottleBlock extends Block implements SimpleWaterloggedBlock {
	public static final IntegerProperty LEVEL = BlockStatePropertiesInit.LEVEL_0_3;
	public static final BooleanProperty WATERLOGGED;
	private static final VoxelShape SHAPE = Block.box(6, 0, 6, 10, 16, 10);
	private static final VoxelShape INSIDE = box(6.1, 0, 6.1, 9.899999999999999, 11, 9.9);

	public WineBottleBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(
				(BlockState) ((BlockState) this.stateDefinition.any()).setValue(LEVEL, 3).setValue(WATERLOGGED, false));
	}

	public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	public VoxelShape getInteractionShape(BlockState state, BlockGetter reader, BlockPos pos) {
		return INSIDE;
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return (Boolean) state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		ItemStack stack = player.getItemInHand(hand);
		if (stack.isEmpty()) {
			return InteractionResult.PASS;
		} else {
			int i = (Integer) state.getValue(LEVEL);
			Item item = stack.getItem();
			if (item == ItemInit.RED_WINE_GLASS.get() || item == ItemInit.WHITE_WINE_GLASS.get()) {
				if (i < 3 && !world.isClientSide) {
					if (item == ItemInit.RED_WINE_GLASS.get()
							&& world.getBlockState(pos).getBlock() == BlockInit.RED_WINE_BOTTLE.get()) {
						player.setItemInHand(hand, new ItemStack(ItemInit.WINE_GLASS.get()));
						this.setWineLevel(world, pos, state, i + 1);
						world.playSound((Player) null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
					} else if (item == ItemInit.WHITE_WINE_GLASS.get()
							&& world.getBlockState(pos).getBlock() == BlockInit.WHITE_WINE_BOTTLE.get()) {
						player.setItemInHand(hand, new ItemStack(ItemInit.WINE_GLASS.get()));
						this.setWineLevel(world, pos, state, i + 1);
						world.playSound((Player) null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
					} else if (i < 1 && !world.isClientSide) {
						world.setBlock(pos, (BlockState) BlockInit.WINE_BOTTLE.get().defaultBlockState(), 11);
					}
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			} else if (item == ItemInit.RED_WINE_BUCKET.get() || item == ItemInit.WHITE_WINE_BUCKET.get()) {
				if (i < 2 && !world.isClientSide) {
					if (item == ItemInit.RED_WINE_BUCKET.get()
							&& world.getBlockState(pos).getBlock() == BlockInit.RED_WINE_BOTTLE.get()) {
						player.setItemInHand(hand, new ItemStack(Items.BUCKET));
						this.setWineLevel(world, pos, state, i + 2);
						world.playSound((Player) null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
					} else if (item == ItemInit.WHITE_WINE_BUCKET.get()
							&& world.getBlockState(pos).getBlock() == BlockInit.WHITE_WINE_BOTTLE.get()) {
						player.setItemInHand(hand, new ItemStack(Items.BUCKET));
						this.setWineLevel(world, pos, state, i + 2);
						world.playSound((Player) null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
					} else if (i < 1 && !world.isClientSide) {
						world.setBlock(pos, (BlockState) BlockInit.WINE_BOTTLE.get().defaultBlockState(), 11);
					}
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			} else if (item == ItemInit.WINE_GLASS.get()) {
				if (i > 0 && !world.isClientSide) {
					if (world.getBlockState(pos).getBlock() == BlockInit.RED_WINE_BOTTLE.get()) {
						ItemStack newItem = new ItemStack(ItemInit.RED_WINE_GLASS.get());
						stack.shrink(1);
						if (stack.isEmpty()) {
							player.setItemInHand(hand, newItem);
						} else if (!player.getInventory().add(newItem)) {
							player.drop(newItem, false);
						}
					} else if (world.getBlockState(pos).getBlock() == BlockInit.WHITE_WINE_BOTTLE.get()) {
						ItemStack newItem = new ItemStack(ItemInit.WHITE_WINE_GLASS.get());
						stack.shrink(1);
						if (stack.isEmpty()) {
							player.setItemInHand(hand, newItem);
						} else if (!player.getInventory().add(newItem)) {
							player.drop(newItem, false);
						}
					}
					this.setWineLevel(world, pos, state, i - 1);
					world.playSound((Player) null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else if (i < 1 && !world.isClientSide) {
					world.setBlock(pos, (BlockState) BlockInit.WINE_BOTTLE.get().defaultBlockState(), 11);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			} else if (item == Items.BUCKET) {
				if (i >= 3 && !world.isClientSide) {
					if (world.getBlockState(pos).getBlock() == BlockInit.RED_WINE_BOTTLE.get()) {
						ItemStack newItem = new ItemStack(ItemInit.RED_WINE_BUCKET.get());
						stack.shrink(1);
						if (stack.isEmpty()) {
							player.setItemInHand(hand, newItem);
						} else if (!player.getInventory().add(newItem)) {
							player.drop(newItem, false);
						}
					} else if (world.getBlockState(pos).getBlock() == BlockInit.WHITE_WINE_BOTTLE.get()) {
						ItemStack newItem = new ItemStack(ItemInit.WHITE_WINE_BUCKET.get());
						stack.shrink(1);
						if (stack.isEmpty()) {
							player.setItemInHand(hand, newItem);
						} else if (!player.getInventory().add(newItem)) {
							player.drop(newItem, false);
						}
					}
					this.setWineLevel(world, pos, state, i - 2);
					world.playSound((Player) null, pos, SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else if (i < 1 && !world.isClientSide) {
					world.setBlock(pos, (BlockState) BlockInit.WINE_BOTTLE.get().defaultBlockState(), 11);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			} else if (item == stack.getItem()) {
				if (i < 1 && !world.isClientSide) {
					world.setBlock(pos, (BlockState) BlockInit.WINE_BOTTLE.get().defaultBlockState(), 11);
				}
				return InteractionResult.sidedSuccess(world.isClientSide);
			} else {
				return InteractionResult.PASS;
			}
		}

	}

	public void setWineLevel(Level world, BlockPos pos, BlockState state, int i) {
		world.setBlock(pos, (BlockState) state.setValue(LEVEL, Mth.clamp(i, 0, 3)), 2);
		world.updateNeighbourForOutputSignal(pos, this);
	}

	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	public int getAnalogOutputSignal(BlockState state, Level world, BlockPos pos) {
		return (Integer) state.getValue(LEVEL);
	}

	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(new Property[] { LEVEL, WATERLOGGED });
	}

	static {
		WATERLOGGED = BlockStateProperties.WATERLOGGED;
	}
}
