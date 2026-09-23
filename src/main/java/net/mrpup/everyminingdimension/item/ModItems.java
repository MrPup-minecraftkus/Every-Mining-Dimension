package net.mrpup.everyminingdimension.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrpup.everyminingdimension.EveryMiningDimension;
import net.mrpup.everyminingdimension.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS ,EveryMiningDimension.MOD_ID);

    private static RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<Block> block) {
        return ITEMS.register(name, () -> new BlockItem(
                block.get(),
                new Item.Properties()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, name)))
                        .useBlockDescriptionPrefix()));
    }

    public static final RegistryObject<BlockItem> TELEPORT_OVERWORLD_MINING_DIMENSION = registerBlockItem(
            "teleport_overworld_mining_dimension", ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION);

    public static final RegistryObject<BlockItem> TELEPORT_NETHER_MINING_DIMENSION = registerBlockItem(
            "teleport_nether_mining_dimension", ModBlocks.TELEPORT_NETHER_MINING_DIMENSION);

    public static final RegistryObject<BlockItem> TELEPORT_END_MINING_DIMENSION = registerBlockItem(
            "teleport_end_mining_dimension", ModBlocks.TELEPORT_END_MINING_DIMENSION);
}
