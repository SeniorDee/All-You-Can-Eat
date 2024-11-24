package seniordee.allyoucaneat.common.entities.vehicle;

import java.util.function.IntFunction;

import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.EntityTypesInit;
import seniordee.allyoucaneat.core.init.ItemInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class BoatEntity extends Boat {
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class,
			EntityDataSerializers.INT);

	public BoatEntity(EntityType<? extends Boat> entityType, Level level) {
		super(entityType, level);
	}

	public BoatEntity(Level world, double x, double y, double z) {
		this(EntityTypesInit.BOAT_ENTITY.get(), world);
		this.setPos(x, y, z);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	@Override
	public Item getDropItem() {
		return switch (getModVariant()) {
			case HAZEL -> ItemInit.HAZEL_BOAT.get();
		};
	}

	public void setVariant(Type variant) {
		this.entityData.set(DATA_ID_TYPE, variant.ordinal());
	}

	public Type getModVariant() {
		return Type.byId(this.entityData.get(DATA_ID_TYPE));
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, Type.HAZEL.ordinal());
	}

	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", this.getModVariant().getSerializedName());
	}

	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Type", 8)) {
			this.setVariant(Type.byName(compound.getString("Type")));
		}
	}

	public static enum Type implements StringRepresentable {
		HAZEL(BlockInit.HAZEL_PLANKS.get(), "hazel");

		private final String name;
		private final Block planks;
		public static final StringRepresentable.EnumCodec<BoatEntity.Type> CODEC = StringRepresentable
				.fromEnum(BoatEntity.Type::values);
		private static final IntFunction<BoatEntity.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(),
				ByIdMap.OutOfBoundsStrategy.ZERO);

		private Type(Block planks, String name) {
			this.name = name;
			this.planks = planks;
		}

		public String getSerializedName() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

		public Block getPlanks() {
			return this.planks;
		}

		public String toString() {
			return this.name;
		}

		public static BoatEntity.Type byId(int id) {
			return BY_ID.apply(id);
		}

		public static BoatEntity.Type byName(String name) {
			return CODEC.byName(name, HAZEL);
		}
	}
}