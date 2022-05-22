package dev.igalaxy.nostringsattached.forge;

import dev.igalaxy.nostringsattached.NoStringsAttached;
import dev.igalaxy.nostringsattached.config.NoStringsAttachedConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(NoStringsAttached.MOD_ID)
public class ForgeEntrypoint {
    public ForgeEntrypoint() {
        NoStringsAttached.init();

        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () ->
                new ConfigGuiHandler.ConfigGuiFactory(
                        (mc, screen) -> AutoConfig.getConfigScreen(NoStringsAttachedConfig.class, screen).get()
                )
        );
    }
}
