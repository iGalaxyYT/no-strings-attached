package dev.igalaxy.nostringsattached;

import dev.igalaxy.nostringsattached.config.NoStringsAttachedConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoStringsAttached {
    public static final String MOD_ID = "nostringsattached";
    public static final Logger LOGGER = LoggerFactory.getLogger("No Strings Attached");

    public static LocalPlayer localPlayer;
    
    public static void init() {
        AutoConfig.register(NoStringsAttachedConfig.class, JanksonConfigSerializer::new);
    }

    public static NoStringsAttachedConfig getConfig() {
        return AutoConfig.getConfigHolder(NoStringsAttachedConfig.class).getConfig();
    }

    public static Item getSelectedItem() {
        if (localPlayer == null) return Items.AIR;
        return localPlayer.getMainHandItem().getItem();
    }
}
