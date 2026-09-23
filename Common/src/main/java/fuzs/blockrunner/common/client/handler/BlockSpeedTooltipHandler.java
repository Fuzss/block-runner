package fuzs.blockrunner.common.client.handler;

import fuzs.blockrunner.common.BlockRunner;
import fuzs.blockrunner.common.config.ClientConfig;
import fuzs.blockrunner.common.world.level.block.data.BlockSpeed;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class BlockSpeedTooltipHandler {
    public static final String KEY_SPEED_MULTIPLIER = "block.blockrunner.speedMultiplier";

    public static void onItemTooltip(ItemStack itemStack, List<Component> lines, Item.TooltipContext tooltipContext, @Nullable Player player, TooltipFlag tooltipFlag) {
        if (!BlockRunner.CONFIG.getHolder(ClientConfig.class).isAvailable() ||
                !BlockRunner.CONFIG.get(ClientConfig.class).blockSpeedItemTooltip) {
            return;
        }

        if (itemStack.getItem() instanceof BlockItem item) {
            Holder.Reference<Block> holder = item.getBlock().builtInRegistryHolder();
            if (BlockSpeed.hasBlockSpeed(holder)) {
                double speed = BlockSpeed.getBlockSpeed(holder);
                lines.add(Component.translatable(KEY_SPEED_MULTIPLIER, speed)
                        .withStyle(ChatFormatting.GRAY));
            }
        }
    }
}
