package fuzs.blockrunner.common.world.level.block.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fuzs.blockrunner.common.BlockRunner;
import fuzs.blockrunner.common.init.ModRegistry;
import fuzs.multiloaderdataextensions.common.api.v2.DataMapLookup;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

public record BlockSpeed(double speed) {
    public static final Identifier SPEED_MODIFIER_BLOCK_SPEED_ID = BlockRunner.id("block_speed");
    public static final double DEFAULT_SPEED = 1.0;
    private static final double MAX_SPEED = 8.0;
    public static final Codec<BlockSpeed> SPEED_CODEC = Codec.doubleRange(0.0, MAX_SPEED)
            .xmap(BlockSpeed::new, BlockSpeed::speed);
    public static final Codec<BlockSpeed> CODEC = Codec.withAlternative(RecordCodecBuilder.create(instance -> instance.group(
                    Codec.doubleRange(0.0, MAX_SPEED).fieldOf("speed").forGetter(BlockSpeed::speed))
            .apply(instance, BlockSpeed::new)), SPEED_CODEC);

    public static boolean hasBlockSpeed(Holder<Block> holder) {
        return DataMapLookup.getData(ModRegistry.BLOCK_SPEED_DATA_MAP_TYPE, holder) != null;
    }

    public static double getBlockSpeed(Holder<Block> holder) {
        BlockSpeed blockSpeed = DataMapLookup.getData(ModRegistry.BLOCK_SPEED_DATA_MAP_TYPE, holder);
        return blockSpeed != null ? blockSpeed.speed() : DEFAULT_SPEED;
    }
}
