package dev.igalaxy.nostringsattached.config

import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config

@Config(name = "nostringsattached")
class NoStringsAttachedConfig : ConfigData {
    var enableMod = true
    var showWhenHolding = true
    var hideInOverworld = true
    var hideInNether = true
    var hideInEnd = true
}