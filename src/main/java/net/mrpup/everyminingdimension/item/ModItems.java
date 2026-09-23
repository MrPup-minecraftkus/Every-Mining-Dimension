package net.mrpup.everyminingdimension.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.mrpup.everyminingdimension.EveryMiningDimension;
import net.mrpup.everyminingdimension.block.ModBlocks;

import java.util.function.Function;

public class ModItems {

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, name));
        T item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static final Item TELEPORT_OVERWORLD_MINING_DIMENSION = register(
            "teleport_overworld_mining_dimension",
            settings -> new BlockItem(ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION, settings),
            new Item.Properties()
    );

    public static final Item TELEPORT_NETHER_MINING_DIMENSION = register(
            "teleport_nether_mining_dimension",
            settings -> new BlockItem(ModBlocks.TELEPORT_NETHER_MINING_DIMENSION, settings),
            new Item.Properties()
    );

    public static final Item TELEPORT_END_MINING_DIMENSION = register(
            "teleport_end_mining_dimension",
            settings -> new BlockItem(ModBlocks.TELEPORT_END_MINING_DIMENSION, settings),
            new Item.Properties()
    );


    public static void register() {

    }
}
