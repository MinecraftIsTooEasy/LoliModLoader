package net.xiaoyu233.fml.reload.mixins.util;

import net.minecraft.LogAgent;
import net.xiaoyu233.fml.util.LogProxy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LogAgent.class)
public class LogTransform {

    @Overwrite
    public void logInfo(String par1Str) {
        LogProxy.logger.info(par1Str);
    }

    @Overwrite
    public void logSevere(String par1Str) {
        LogProxy.logger.error(par1Str);
    }

    @Overwrite
    public void logSevereException(String par1Str, Throwable par2Throwable) {
        LogProxy.logger.error(par1Str,par2Throwable);
    }

    @Overwrite
    public void logWarning(String par1Str) {
        LogProxy.logger.warn(par1Str);
    }

    @Overwrite
    public void logWarningException(String par1Str, Throwable par2Throwable) {
        LogProxy.logger.warn(par1Str,par2Throwable);
    }

    @Overwrite
    public void logWarningFormatted(String par1Str, Object... par2ArrayOfObj) {
        LogProxy.logger.warn(par1Str,par2ArrayOfObj);
    }
}
