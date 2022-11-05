package dev.igalaxy.nostringsattached.mixin

import dev.igalaxy.nostringsattached.NoStringsAttached
import net.minecraft.client.network.ClientPlayerEntity
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(ClientPlayerEntity::class)
class ClientPlayerEntityMixin {
    @Inject(at = [At("HEAD")], method = ["init"])
    private fun init(ci: CallbackInfo) {
        NoStringsAttached.clientPlayerEntity = this as ClientPlayerEntity;
    }
}