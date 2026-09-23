package net.mrpup.everyminingdimension.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.mrpup.everyminingdimension.EveryMiningDimension;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(EveryMiningDimension.MOD_ID);

    public static final DeferredBlock<Block> TELEPORT_OVERWORLD_MINING_DIMENSION =
            BLOCKS.register("teleport_overworld_mining_dimension",
                    id -> new OverworldMiningTeleport(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                                    .strength(2f)
                                    .requiresCorrectToolForDrops()
                                    .setId(ResourceKey.create(Registries.BLOCK, id))));

    public static final DeferredBlock<Block> TELEPORT_NETHER_MINING_DIMENSION =
            BLOCKS.register("teleport_nether_mining_dimension",
                    id -> new NetherMiningTeleport(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                                    .strength(2f)
                                    .requiresCorrectToolForDrops()
                                    .setId(ResourceKey.create(Registries.BLOCK, id))));

    public static final DeferredBlock<Block> TELEPORT_END_MINING_DIMENSION =
            BLOCKS.register("teleport_end_mining_dimension",
                    id -> new EndMiningTeleport(
                            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                                    .strength(2f)
                                    .requiresCorrectToolForDrops()
                                    .setId(ResourceKey.create(Registries.BLOCK, id))));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
