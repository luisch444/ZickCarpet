package xyz.luisch444.carpet.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.luisch444.carpet.ZickCarpetSettings;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class AbstractBlockStateMixin {

    @Inject(method = "getHardness", at = @At("HEAD"), cancellable = true)
    public void changeHardness(BlockView world, BlockPos pos, CallbackInfoReturnable<Float> ci) {
        if (world.getBlockState(pos).getBlock().equals(Blocks.END_STONE) && ZickCarpetSettings.EndStonelessHardness) {
            ci.setReturnValue(1.5f);
        } else if (world.getBlockState(pos).getBlock().equals(Blocks.DEEPSLATE) && ZickCarpetSettings.deepSlateInstaminable) {
            ci.setReturnValue(1.5f);
        }
    }
}
