package fuzs.blockrunner.common;

import fuzs.blockrunner.common.config.ClientConfig;
import fuzs.blockrunner.common.init.ModRegistry;
import fuzs.puzzleslib.common.api.config.v3.ConfigHolder;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockRunner implements ModConstructor {
    public static final String MOD_ID = "blockrunner";
    public static final String MOD_NAME = "Block Runner";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ConfigHolder CONFIG = ConfigHolder.builder(MOD_ID).client(ClientConfig.class);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
