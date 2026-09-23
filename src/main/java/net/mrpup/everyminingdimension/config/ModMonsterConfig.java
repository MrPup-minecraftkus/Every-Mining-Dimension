package net.mrpup.everyminingdimension.config;


import net.minecraftforge.common.ForgeConfigSpec;

public class ModMonsterConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue SPAWN_MONSTER;
    public static final ForgeConfigSpec.BooleanValue SPAWN_ANIMAL;

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
