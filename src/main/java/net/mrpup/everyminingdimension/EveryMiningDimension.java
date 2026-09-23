package net.mrpup.everyminingdimension;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.mrpup.everyminingdimension.block.ModBlocks;
import net.mrpup.everyminingdimension.config.ModMonsterConfig;
import net.mrpup.everyminingdimension.item.CreativeModTab;
import net.mrpup.everyminingdimension.item.ModItems;
import net.mrpup.everyminingdimension.world.dimension.ModDimensions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@Mod(EveryMiningDimension.MOD_ID)
public class EveryMiningDimension {
    public static final String MOD_ID = "everyminingdimension";

    public EveryMiningDimension(IEventBus modEventBus, ModContainer modContainer) {

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CreativeModTab.register(modEventBus);
        ModDimensions.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, ModMonsterConfig.SPEC);

        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityJoinLevel(EntityJoinLevelEvent event) {

        Level world = event.getLevel();
        ResourceKey<Level> dimension = world.dimension();

        if (event.getEntity() instanceof Enemy) {
            if (!ModMonsterConfig.SPAWN_MONSTER.get()) {
                if (dimension == ModDimensions.OVERWORLD_MINING_LEVEL ||
                        dimension == ModDimensions.END_MINING_LEVEL ||
                        dimension == ModDimensions.NETHER_MINING_DIMENSION_LEVEL) {

                    event.setCanceled(true);
                }
            }
        }

        if (event.getEntity() instanceof Animal) {
            if (!ModMonsterConfig.SPAWN_ANIMAL.get()) {
                if (dimension == ModDimensions.OVERWORLD_MINING_LEVEL ||
                        dimension == ModDimensions.END_MINING_LEVEL ||
                        dimension == ModDimensions.NETHER_MINING_DIMENSION_LEVEL) {

                    event.setCanceled(true);
                }
            }
        }
    }
}
