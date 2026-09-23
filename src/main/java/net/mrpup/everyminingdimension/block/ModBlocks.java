package net.mrpup.everyminingdimension.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.mrpup.everyminingdimension.EveryMiningDimension;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, Block.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
        return block;
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, name));
    }

    public static final Block TELEPORT_OVERWORLD_MINING_DIMENSION = register(
            "teleport_overworld_mining_dimension",
            OverworldMiningTeleport::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(2f).requiresCorrectToolForDrops(),
            true
    );

    public static final Block TELEPORT_NETHER_MINING_DIMENSION = register(
            "teleport_nether_mining_dimension",
            NetherMiningTeleport::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(2f).requiresCorrectToolForDrops(),
            true
    );

    public static final Block TELEPORT_END_MINING_DIMENSION = register(
            "teleport_end_mining_dimension",
            EndMiningTeleport::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(2f).requiresCorrectToolForDrops(),
            true
    );

    public static void register() {

    }
}
