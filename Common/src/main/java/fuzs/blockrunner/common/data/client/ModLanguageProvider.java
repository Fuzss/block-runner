package fuzs.blockrunner.common.data.client;

import fuzs.blockrunner.common.client.handler.BlockSpeedTooltipHandler;
import fuzs.blockrunner.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(BlockSpeedTooltipHandler.KEY_SPEED_MULTIPLIER, "Speed Multiplier: %s");
        this.add(ModRegistry.VERY_SLOW_BLOCKS_BLOCK_TAG, "Very Slow Blocks");
        this.add(ModRegistry.SLOW_BLOCKS_BLOCK_TAG, "Slow Blocks");
        this.add(ModRegistry.SLIGHTLY_SLOW_BLOCKS_BLOCK_TAG, "Slightly Slow Blocks");
        this.add(ModRegistry.SLIGHTLY_QUICK_BLOCKS_BLOCK_TAG, "Slight Quick Blocks");
        this.add(ModRegistry.QUICK_BLOCKS_BLOCK_TAG, "Quick Blocks");
        this.add(ModRegistry.VERY_QUICK_BLOCKS_BLOCK_TAG, "Very Quick Blocks");
    }
}
