package net.mrpup.everyminingdimension.world.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.mrpup.everyminingdimension.EveryMiningDimension;

public class ModDimensions {
    public static final ResourceKey<DimensionType> OVERWORLD_MINING_DIMENSION_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "overworld_mining_dimension_type"));

    public static final ResourceKey<Level> OVERWORLD_MINING_LEVEL =
            ResourceKey.create(Registries.DIMENSION,
                    Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "overworld_mining_dimension"));

    public static final ResourceKey<DimensionType> NETHER_MINING_DIMENSION_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "nether_mining_dimension_type"));

    public static final ResourceKey<Level> NETHER_MINING_DIMENSION_LEVEL =
            ResourceKey.create(Registries.DIMENSION,
                    Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "nether_mining_dimension"));

    public static final ResourceKey<DimensionType> END_MINING_DIMENSION_TYPE =
            ResourceKey.create(Registries.DIMENSION_TYPE,
                    Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "end_mining_dimension_type"));

    public static final ResourceKey<Level> END_MINING_LEVEL =
            ResourceKey.create(Registries.DIMENSION,
                    Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "end_mining_dimension"));

    public static void register(BusGroup modEventBus) {

    }
}

