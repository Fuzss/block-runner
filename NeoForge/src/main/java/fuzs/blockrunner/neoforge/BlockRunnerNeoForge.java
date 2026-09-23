package fuzs.blockrunner.neoforge;

import fuzs.blockrunner.common.BlockRunner;
import fuzs.blockrunner.common.data.tags.ModBlockTagsProvider;
import fuzs.blockrunner.neoforge.data.ModDataMapProvider;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import net.neoforged.fml.common.Mod;

@Mod(BlockRunner.MOD_ID)
public class BlockRunnerNeoForge {

    public BlockRunnerNeoForge() {
        ModConstructor.construct(BlockRunner.MOD_ID, BlockRunner::new);
        DataProviderBuilder.of(BlockRunner.MOD_ID).addProvider(ModBlockTagsProvider::new, ModDataMapProvider::new);
    }
}
