package fuzs.blockrunner.common.data.client;

import fuzs.blockrunner.common.client.handler.BlockSpeedTooltipHandler;
import fuzs.blockrunner.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.client.data.v2.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations(TranslationBuilder builder) {
        builder.add(BlockSpeedTooltipHandler.KEY_SPEED_MULTIPLIER, "Speed Multiplier: %s");
        builder.add(ModRegistry.VERY_SLOW_BLOCKS_BLOCK_TAG, "Very Slow Blocks");
        builder.add(ModRegistry.SLOW_BLOCKS_BLOCK_TAG, "Slow Blocks");
        builder.add(ModRegistry.SLIGHTLY_SLOW_BLOCKS_BLOCK_TAG, "Slightly Slow Blocks");
        builder.add(ModRegistry.SLIGHTLY_QUICK_BLOCKS_BLOCK_TAG, "Slight Quick Blocks");
        builder.add(ModRegistry.QUICK_BLOCKS_BLOCK_TAG, "Quick Blocks");
        builder.add(ModRegistry.VERY_QUICK_BLOCKS_BLOCK_TAG, "Very Quick Blocks");
    }
}
