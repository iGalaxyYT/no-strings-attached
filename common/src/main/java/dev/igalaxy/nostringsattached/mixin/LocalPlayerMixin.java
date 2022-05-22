package dev.igalaxy.nostringsattached.mixin;

import dev.igalaxy.nostringsattached.NoStringsAttached;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void modifyTick(CallbackInfo ci) {
        NoStringsAttached.localPlayer = ((LocalPlayer)(Object)this);
    }
}
