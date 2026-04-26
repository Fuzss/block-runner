package fuzs.blockrunner.fabric.client;

import fuzs.blockrunner.common.BlockRunner;
import fuzs.blockrunner.common.client.BlockRunnerClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class BlockRunnerFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(BlockRunner.MOD_ID, BlockRunnerClient::new);
    }
}
