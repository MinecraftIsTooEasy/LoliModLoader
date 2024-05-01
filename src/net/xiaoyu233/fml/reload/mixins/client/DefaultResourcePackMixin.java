package net.xiaoyu233.fml.reload.mixins.client;

import net.minecraft.DefaultResourcePack;
import net.minecraft.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.File;
import java.io.InputStream;

@Mixin(DefaultResourcePack.class)
public abstract class DefaultResourcePackMixin {
    @Shadow @Final private File fileAssets;

    @Shadow protected abstract InputStream getResourceStream(ResourceLocation resourceLocation);

//    @Redirect(method = "getPackMetadata", at = @At(value = "INVOKE", target = "Ljava/lang/Class;getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;"))
//    private InputStream redirectGetPackMetadata(Class<?> c, String path){
//        return DefaultResourcePack.class.getClassLoader().findResources(path);
//    }
    @Redirect(method = "getInputStream", at = @At(value = "INVOKE", target = "Lnet/minecraft/DefaultResourcePack;getResourceStream(Lnet/minecraft/ResourceLocation;)Ljava/io/InputStream;"))
    private InputStream redirectFixLanguageLoad(DefaultResourcePack t, ResourceLocation resourceLocation){
        String resourcePath = resourceLocation.getResourcePath();
        if (this.fileAssets.toString().contains("\\legacy") && resourcePath.contains(".lang") && !resourcePath.contains("en_US")){
            return null;
        }else {
            return this.getResourceStream(resourceLocation);
        }
    }
}
