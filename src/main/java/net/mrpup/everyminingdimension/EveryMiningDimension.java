package net.mrpup.everyminingdimension;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.mrpup.everyminingdimension.block.ModBlocks;
import net.mrpup.everyminingdimension.config.ModMonsterConfig;
import net.mrpup.everyminingdimension.item.CreativeModTab;
import net.mrpup.everyminingdimension.item.ModItems;
import net.mrpup.everyminingdimension.world.EntityEvent;
import net.mrpup.everyminingdimension.world.dimension.ModDimensions;

@Mod(EveryMiningDimension.MOD_ID)
public final class EveryMiningDimension {

    public static final String MOD_ID = "everyminingdimension";

    public EveryMiningDimension(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();

        ModBlocks.BLOCKS.register(modBusGroup);
        ModItems.ITEMS.register(modBusGroup);
        CreativeModTab.CREATIVE_MODE_TABS.register(modBusGroup);
        ModDimensions.register(modBusGroup);
        EntityEvent.register();

        context.registerConfig(ModConfig.Type.COMMON, ModMonsterConfig.SPEC);
    }

}
