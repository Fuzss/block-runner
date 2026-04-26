package fuzs.blockrunner.common.client;

import fuzs.blockrunner.common.client.handler.BlockSpeedTooltipHandler;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.client.event.v1.gui.ItemTooltipCallback;

public class BlockRunnerClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        ItemTooltipCallback.EVENT.register(BlockSpeedTooltipHandler::onItemTooltip);
    }
}
