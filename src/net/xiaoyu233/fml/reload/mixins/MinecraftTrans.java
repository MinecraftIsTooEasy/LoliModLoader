package net.xiaoyu233.fml.reload.mixins;

import net.minecraft.Minecraft;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.config.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Minecraft.class)
public class MinecraftTrans {
    @Shadow
    private static String error_message;

    @Overwrite
    public static void setErrorMessage(String text, boolean echo_to_err) {
        FishModLoader.LOGGER.error(text);
        if (Configs.Debug.DEBUG.get()){
            if (echo_to_err && (error_message == null || !error_message.equals(text))) {
                System.err.println(text);
            }
            if (error_message == null) {
                error_message = text.replaceAll("\n", "");
            }
        }
    }
}
