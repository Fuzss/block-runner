package fuzs.blockrunner.common.data.tags;

import fuzs.blockrunner.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.puzzleslib.common.api.data.v3.tags.AbstractTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemIds;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class ModBlockTagsProvider extends AbstractTagsProvider<Block> {

    public ModBlockTagsProvider(DataProviderContext context) {
        super(Registries.BLOCK, context);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(ModRegistry.VERY_SLOW_BLOCKS_BLOCK_TAG);
        this.tag(ModRegistry.SLOW_BLOCKS_BLOCK_TAG);
        this.tag(ModRegistry.SLIGHTLY_SLOW_BLOCKS_BLOCK_TAG);
        this.tag(ModRegistry.SLIGHTLY_QUICK_BLOCKS_BLOCK_TAG).addTag(BlockTags.STONE_BRICKS);
        this.tag(ModRegistry.QUICK_BLOCKS_BLOCK_TAG).add(BlockItemIds.DIRT_PATH.block());
        this.tag(ModRegistry.VERY_QUICK_BLOCKS_BLOCK_TAG);
    }
}
