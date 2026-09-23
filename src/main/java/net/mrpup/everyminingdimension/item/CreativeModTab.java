package net.mrpup.everyminingdimension.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mrpup.everyminingdimension.EveryMiningDimension;
import net.mrpup.everyminingdimension.block.ModBlocks;


public class CreativeModTab {


    public static final CreativeModeTab EVERY_MINING_DIMENSION = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "every_mining_dimension"),
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                    .icon(() -> new ItemStack(ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION.asItem()))
                    .title(Component.translatable("itemGroup.every_mining_dimension"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION.asItem());
                        entries.accept(ModBlocks.TELEPORT_NETHER_MINING_DIMENSION.asItem());
                        entries.accept(ModBlocks.TELEPORT_END_MINING_DIMENSION.asItem());
                    }).build());


    public static void register() {

    }
}