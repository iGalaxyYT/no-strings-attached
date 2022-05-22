package dev.igalaxy.nostringsattached.mixin;

import dev.igalaxy.nostringsattached.NoStringsAttached;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateMixin {
    @Shadow public abstract Block getBlock();

    @Inject(method = "getRenderShape", at = @At("RETURN"), cancellable = true)
    private void modifyGetRenderShape(CallbackInfoReturnable<RenderShape> cir) {
        if (NoStringsAttached.getConfig().hideString && this.getBlock() == Blocks.TRIPWIRE && NoStringsAttached.getSelectedItem() != Items.STRING) {
            cir.setReturnValue(RenderShape.INVISIBLE);
        }
    }
}