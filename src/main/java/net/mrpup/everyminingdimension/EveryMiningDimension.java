package net.mrpup.everyminingdimension;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.monster.Enemy;
import net.mrpup.everyminingdimension.block.ModBlocks;
import net.mrpup.everyminingdimension.config.ModConfig;
import net.mrpup.everyminingdimension.data.ModAttachments;
import net.mrpup.everyminingdimension.item.CreativeModTab;
import net.mrpup.everyminingdimension.item.ModItems;
import net.mrpup.everyminingdimension.world.dimension.ModDimensions;

public class EveryMiningDimension implements ModInitializer {
	public static final String MOD_ID = "everyminingdimension";

	@Override
	public void onInitialize() {
        ModConfig.load();
        ModAttachments.register();
        ModBlocks.register();
        ModItems.register();
        CreativeModTab.register();
        ModDimensions.register();

        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (!world.dimension().identifier().getNamespace().equals(MOD_ID)) return;

            ModConfig config = ModConfig.get();

            if (entity instanceof Enemy && !config.spawnMonsterInMiningDimensions) {
                entity.discard();
            } else if (entity instanceof Animal && !config.spawnAnimalInMiningDimensions) {
                entity.discard();
            }
        });
	}

}
