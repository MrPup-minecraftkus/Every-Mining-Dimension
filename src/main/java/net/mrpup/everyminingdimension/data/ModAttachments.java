package net.mrpup.everyminingdimension.data;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.Identifier;
import net.mrpup.everyminingdimension.EveryMiningDimension;

public class ModAttachments {
    public static final AttachmentType<Long> OVERWORLD_PORTAL_POS = AttachmentRegistry.create(
            Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "overworld_portal_pos"),
            builder -> builder
                    .persistent(Codec.LONG)
                    .copyOnDeath()
    );

    public static void register() {

    }
}
