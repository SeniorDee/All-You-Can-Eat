package io.github.itamardenkberg.allyoucaneat.common.entities.vehicle;

import io.github.itamardenkberg.allyoucaneat.core.init.EntityTypesInit;
import io.github.itamardenkberg.allyoucaneat.core.init.ItemInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ChestBoatEntity extends ChestBoat {
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class,
			EntityDataSerializers.INT);

	public ChestBoatEntity(EntityType<? extends ChestBoat> entityType, Level level) {
		super(entityType, level);
	}

	public ChestBoatEntity(Level world, double x, double y, double z) {
		this(EntityTypesInit.CHEST_BOAT_ENTITY.get(), world);
		this.setPos(x, y, z);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	@Override
	public Item getDropItem() {
		switch (getModVariant()) {
			case HAZEL -> {
				return ItemInit.HAZEL_CHEST_BOAT.get();
			}
		}

		return super.getDropItem();
	}

	public void setVariant(BoatEntity.Type variant) {
		this.entityData.set(DATA_ID_TYPE, variant.ordinal());
	}

	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, BoatEntity.Type.HAZEL.ordinal());
	}

	protected void addAdditionalSaveData(CompoundTag compound) {
		compound.putString("Type", this.getModVariant().getSerializedName());
	}

	protected void readAdditionalSaveData(CompoundTag compound) {
		if (compound.contains("Type", 8)) {
			this.setVariant(BoatEntity.Type.byName(compound.getString("Type")));
		}
	}

	public BoatEntity.Type getModVariant() {
		return BoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
	}
}