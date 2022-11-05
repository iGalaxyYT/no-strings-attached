package dev.igalaxy.nostringsattached.mixin

import dev.igalaxy.nostringsattached.NoStringsAttached
import dev.igalaxy.nostringsattached.NoStringsAttached.Companion.config
import dev.igalaxy.nostringsattached.NoStringsAttached.Companion.dimension
import dev.igalaxy.nostringsattached.NoStringsAttached.Companion.selectedItem
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.WorldRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.item.Items
import net.minecraft.util.math.Matrix4f
import net.minecraft.world.dimension.DimensionTypes
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(WorldRenderer::class)
class WorldRendererMixin {
    @Inject(at = [At("HEAD")], method = ["renderLayer"], cancellable = true)
    private fun renderLayer(renderLayer: RenderLayer, matrices: MatrixStack, cameraX: Double, cameraY: Double, cameraZ: Double, positionMatrix: Matrix4f, ci: CallbackInfo) {
        if (!config.enableMod) return;
        if (renderLayer == RenderLayer.getTripwire()) {
            if ((dimension == DimensionTypes.OVERWORLD || dimension == DimensionTypes.OVERWORLD_CAVES) && config.hideInOverworld ||
                dimension == DimensionTypes.THE_NETHER && config.hideInNether ||
                dimension == DimensionTypes.THE_END && config.hideInEnd
            ) {
                if (!(config.showWhenHolding && selectedItem == Items.STRING)) {
                    ci.cancel()
                }
            }
        }
    }
}