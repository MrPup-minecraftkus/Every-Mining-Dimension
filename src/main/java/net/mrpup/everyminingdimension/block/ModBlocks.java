package net.mrpup.everyminingdimension.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.mrpup.everyminingdimension.EveryMiningDimension;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EveryMiningDimension.MOD_ID);

    private static RegistryObject<Block> registerBlock(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties props) {
        return BLOCKS.register(name, () -> factory.apply(
                props.setId(ResourceKey.create(Registries.BLOCK,
                        Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, name)))));
    }

    public static final RegistryObject<Block> TELEPORT_OVERWORLD_MINING_DIMENSION =
            registerBlock("teleport_overworld_mining_dimension",
                    OverworldMiningTeleport::new,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                            .strength(2f)
                            .requiresCorrectToolForDrops());

    public static final RegistryObject<Block> TELEPORT_NETHER_MINING_DIMENSION =
            registerBlock("teleport_nether_mining_dimension",
                    NetherMiningTeleport::new,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                            .strength(2f)
                            .requiresCorrectToolForDrops());

    public static final RegistryObject<Block> TELEPORT_END_MINING_DIMENSION =
            registerBlock("teleport_end_mining_dimension",
                    EndMiningTeleport::new,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                            .strength(2f)
                            .requiresCorrectToolForDrops());
}
