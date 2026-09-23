package net.mrpup.everyminingdimension.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.mrpup.everyminingdimension.EveryMiningDimension;
import net.mrpup.everyminingdimension.block.ModBlocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeModTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EveryMiningDimension.MOD_ID);


    public static final Supplier<CreativeModeTab> EVERY_MINING_DIMENSION = CREATIVE_MODE_TABS.register("every_mining_dimension",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION.get()))
                    .title(Component.translatable("itemGroup.every_mining_dimension"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.TELEPORT_OVERWORLD_MINING_DIMENSION.get());
                        pOutput.accept(ModBlocks.TELEPORT_NETHER_MINING_DIMENSION.get());
                        pOutput.accept(ModBlocks.TELEPORT_END_MINING_DIMENSION.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}