package seniordee.allyoucaneat.core.integrations.farmersdelight.init;

import seniordee.allyoucaneat.AllYouCanEat;
import seniordee.allyoucaneat.core.init.BlockInit;
import seniordee.allyoucaneat.core.init.FoodInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;

public class FDItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            AllYouCanEat.MOD_ID);

    public static final RegistryObject<Item> PIZZA_SLICE = ITEMS.register("pizza_slice",
            () -> new Item(new Item.Properties().food(FoodInit.PIZZA_SLICE)));

    public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = ITEMS.register("chocolate_cake_slice",
            () -> new Item(new Item.Properties().food(FoodValues.CAKE_SLICE)));

    public static final RegistryObject<Item> STRAWBERRY_CAKE_SLICE = ITEMS.register("strawberry_cake_slice",
            () -> new Item(new Item.Properties().food(FoodValues.CAKE_SLICE)));

    // Blocks
    public static final RegistryObject<BlockItem> HAZEL_CABINET = ITEMS.register("hazel_cabinet",
            () -> new BlockItem(FDBlockInit.HAZEL_CABINET.get(), new Item.Properties()));

    public static final RegistryObject<BlockItem> FIG_CABINET = ITEMS.register("fig_cabinet",
            () -> new BlockItem(FDBlockInit.FIG_CABINET.get(), new Item.Properties()));
}
