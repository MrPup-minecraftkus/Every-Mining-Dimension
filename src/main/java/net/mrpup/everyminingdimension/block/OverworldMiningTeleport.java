package net.mrpup.everyminingdimension.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.mrpup.everyminingdimension.EveryMiningDimension;

public class OverworldMiningTeleport extends Block {

    public OverworldMiningTeleport(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.PASS;

        ServerLevel serverLevel = (ServerLevel) level;

        ResourceKey<Level> overworldKey = ResourceKey.create(Registries.DIMENSION, Identifier.fromNamespaceAndPath("minecraft", "overworld"));
        ResourceKey<Level> miningKey = ResourceKey.create(Registries.DIMENSION, Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "overworld_mining_dimension"));

        if (level.dimension().equals(overworldKey)) {
            return teleportPlayer(player, serverLevel, miningKey, pos);
        } else if (level.dimension().equals(miningKey)) {
            return teleportPlayer(player, serverLevel, overworldKey, pos);
        }

        return InteractionResult.PASS;
    }

    private InteractionResult teleportPlayer(Player player, ServerLevel currentWorld, ResourceKey<Level> targetKey, BlockPos overworldPortalPos) {
        ServerLevel targetWorld = currentWorld.getServer().getLevel(targetKey);
        if (targetWorld == null) return InteractionResult.FAIL;

        BlockPos portalPos;
        if (targetKey.identifier().equals(Identifier.fromNamespaceAndPath(EveryMiningDimension.MOD_ID, "overworld_mining_dimension"))) {
            portalPos = new BlockPos(overworldPortalPos.getX(), 64, overworldPortalPos.getZ());
            targetWorld.setBlock(portalPos, this.defaultBlockState(), 3);
            player.getPersistentData().putLong("overworldPortalPos", overworldPortalPos.asLong());
        } else {
            if (player.getPersistentData().contains("overworldPortalPos")) {
                portalPos = BlockPos.of(player.getPersistentData().getLong("overworldPortalPos").orElse(0L));
            } else {
                portalPos = new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ());
            }
        }

        final Vec3 vecPos = new Vec3(portalPos.getX() + 0.5, portalPos.getY(), portalPos.getZ() + 0.5);

        TeleportTransition transition = new TeleportTransition(
                targetWorld,
                vecPos,
                player.getDeltaMovement(),
                player.getYRot(),
                player.getXRot(),
                TeleportTransition.DO_NOTHING
        );

        player.teleport(transition);

        return InteractionResult.SUCCESS;
    }
}
