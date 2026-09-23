package net.mrpup.everyminingdimension.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.mrpup.everyminingdimension.EveryMiningDimension;
import net.mrpup.everyminingdimension.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems(EveryMiningDimension.MOD_ID);

    public static final DeferredHolder<Item, BlockItem> TELEPORT_OVERWORLD_MINING_DIMENSION = ITEMS.register(
            "teleport_overworld_mining_dimension", () -> new BlockItem(ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION.get(), new Item.Properties().stacksTo(1))
    );

    public static final DeferredHolder<Item, BlockItem> TELEPORT_NETHER_MINING_DIMENSION = ITEMS.register(
            "teleport_nether_mining_dimension", () -> new BlockItem(ModBlocks.TELEPORT_NETHER_MINING_DIMENSION.get(), new Item.Properties().stacksTo(1))
    );

    public static final DeferredHolder<Item, BlockItem> TELEPORT_END_MINING_DIMENSION = ITEMS.register(
            "teleport_end_mining_dimension", () -> new BlockItem(ModBlocks.TELEPORT_END_MINING_DIMENSION.get(), new Item.Properties().stacksTo(1))
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
