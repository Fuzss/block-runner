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
    public static final Identifier SPEED_MODIFIER_BLOCK_SPEED_IDENTIFIER = BlockRunner.id("block_speed");
    static final double MAX_SPEED_VALUE = 8.0;
    public static final Codec<BlockSpeed> SPEED_CODEC = Codec.doubleRange(0, MAX_SPEED_VALUE)
            .xmap(BlockSpeed::new, BlockSpeed::speed);
    public static final Codec<BlockSpeed> CODEC = Codec.withAlternative(RecordCodecBuilder.create(in -> in.group(Codec.doubleRange(
            0,
            MAX_SPEED_VALUE).fieldOf("speed").forGetter(BlockSpeed::speed)).apply(in, BlockSpeed::new)), SPEED_CODEC);

    public static boolean hasBlockSpeed(Holder<Block> holder) {
        return DataMapLookup.getData(ModRegistry.BLOCK_SPEED_DATA_MAP_TYPE, holder) != null;
    }

    public static double getSpeedFactor(Holder<Block> holder) {
        BlockSpeed blockSpeed = DataMapLookup.getData(ModRegistry.BLOCK_SPEED_DATA_MAP_TYPE, holder);
        return blockSpeed != null ? blockSpeed.speed() : 1.0;
    }
}
