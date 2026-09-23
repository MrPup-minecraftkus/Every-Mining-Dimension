package net.mrpup.everyminingdimension.world;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.mrpup.everyminingdimension.config.ModMonsterConfig;
import net.mrpup.everyminingdimension.world.dimension.ModDimensions;

public class EntityEvent {

    public static void register() {
        EntityJoinLevelEvent.BUS.addListener(EntityEvent::onEntityJoinLevel);
    }

    private static boolean onEntityJoinLevel(EntityJoinLevelEvent event) {
        Level level = event.getLevel();
        if (level.isClientSide()) return false;
        if (!isMiningDimension(level.dimension())) return false;

        if (event.getEntity() instanceof Enemy && !ModMonsterConfig.SPAWN_MONSTER.get()) {
            return true;
        }
        if (event.getEntity() instanceof Animal && !ModMonsterConfig.SPAWN_ANIMAL.get()) {
            return true;
        }
        return false;
    }

    private static boolean isMiningDimension(ResourceKey<Level> dim) {
        return dim.equals(ModDimensions.OVERWORLD_MINING_LEVEL)
                || dim.equals(ModDimensions.END_MINING_LEVEL)
                || dim.equals(ModDimensions.NETHER_MINING_DIMENSION_LEVEL);
    }
}
