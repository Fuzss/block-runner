package fuzs.blockrunner.common.helper;

import fuzs.blockrunner.common.world.level.block.data.BlockSpeed;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlockSpeedAttributeHelper {

    public static void removeBlockSpeed(LivingEntity livingEntity) {
        AttributeInstance attribute = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            if (attribute.getModifier(BlockSpeed.SPEED_MODIFIER_BLOCK_SPEED_ID) != null) {
                attribute.removeModifier(BlockSpeed.SPEED_MODIFIER_BLOCK_SPEED_ID);
            }
        }
    }

    public static void tryAddBlockSpeed(LivingEntity livingEntity) {
        if (!(livingEntity instanceof Player player) || !player.getAbilities().flying) {
            BlockState blockState = livingEntity.getBlockStateOn();
            if (!blockState.isAir()) {
                // check the block the entity is directly on to be able to support very thin blocks such as carpet
                Holder.Reference<Block> holder = blockState.getBlock().builtInRegistryHolder();
                double speed = BlockSpeed.getBlockSpeed(holder);
                AttributeInstance attribute = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
                if (attribute == null || speed == BlockSpeed.DEFAULT_SPEED) {
                    return;
                }

                double baseValue = attribute.getBaseValue();
                speed = speed * baseValue - baseValue;
                attribute.addTransientModifier(new AttributeModifier(BlockSpeed.SPEED_MODIFIER_BLOCK_SPEED_ID,
                        speed,
                        AttributeModifier.Operation.ADD_VALUE));
            }
        }
    }
}
