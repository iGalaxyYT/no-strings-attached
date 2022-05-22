package dev.igalaxy.nostringsattached.fabric;

import dev.igalaxy.nostringsattached.NoStringsAttached;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        NoStringsAttached.init();
    }
}
