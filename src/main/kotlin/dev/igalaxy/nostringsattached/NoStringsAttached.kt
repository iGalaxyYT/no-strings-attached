package dev.igalaxy.nostringsattached

import dev.igalaxy.nostringsattached.config.NoStringsAttachedConfig
import me.shedaniel.autoconfig.AutoConfig
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer
import net.fabricmc.api.ModInitializer
import net.minecraft.client.network.ClientPlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.Items
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.dimension.DimensionTypes

class NoStringsAttached : ModInitializer {
    companion object {
        var clientPlayerEntity: ClientPlayerEntity? = null

        val selectedItem: Item
            get() = if (clientPlayerEntity == null) Items.AIR
                else clientPlayerEntity!!.mainHandStack.item

        val dimension: RegistryKey<DimensionType>
            get() = if (clientPlayerEntity == null) DimensionTypes.OVERWORLD
                else clientPlayerEntity!!.clientWorld.dimensionKey

        val config: NoStringsAttachedConfig
            get() = AutoConfig.getConfigHolder(NoStringsAttachedConfig::class.java).config
    }

    override fun onInitialize() {
        AutoConfig.register(NoStringsAttachedConfig::class.java, ::JanksonConfigSerializer)
    }
}