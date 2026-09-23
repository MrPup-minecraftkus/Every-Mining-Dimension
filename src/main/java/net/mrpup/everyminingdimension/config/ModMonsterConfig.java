package net.mrpup.everyminingdimension.config;


import net.neoforged.neoforge.common.ModConfigSpec;

public class ModMonsterConfig {

    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue SPAWN_MONSTER;
    public static final ModConfigSpec.BooleanValue SPAWN_ANIMAL;

    static {
        BUILDER.push("Every Mining Dimension Config");

        SPAWN_MONSTER = BUILDER
                .comment("Spawning mobs in the Mining Dimensions? Default is false.")
                .define("spawnMonsterInMiningDimensions", false);

        SPAWN_ANIMAL = BUILDER
                .comment("Spawning animal in the Mining Dimensions? Default is false.")
                .define("spawnAnimalInMiningDimensions", false);

        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
