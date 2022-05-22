package dev.igalaxy.nostringsattached.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "nostringsattached")
public class NoStringsAttachedConfig implements ConfigData {
    @ConfigEntry.Category("Blocks")
    public boolean hideString = true;
}
