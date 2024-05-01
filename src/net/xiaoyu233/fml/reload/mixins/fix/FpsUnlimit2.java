package net.xiaoyu233.fml.reload.mixins.fix;

import net.minecraft.EntityRenderer;
import net.xiaoyu233.fml.config.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityRenderer.class)
public class FpsUnlimit2 {
    @Overwrite
    public static int performanceToFps(int par0) {
        return Configs.Client.FPS_LIMIT.get();
    }
}
