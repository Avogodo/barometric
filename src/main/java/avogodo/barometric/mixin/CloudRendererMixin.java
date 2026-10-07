package avogodo.barometric.mixin;

import net.minecraft.client.render.CloudRenderer;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CloudRenderer.class)
public class CloudRendererMixin {
	@ModifyConstant(method = "renderClouds", constant = @Constant(floatValue = 0.030000001f))
	private float getCloudSpeed(float cloudSpeed) {
		return cloudSpeed;
	}
	@Inject(method = "prepare(Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)Ljava/lang/Object;", at = @At("HEAD"), cancellable = true)
	private void barometric$modifyCloudTexture(ResourceManager manager, Profiler profiler, CallbackInfoReturnable<Object> cir) {
	}
}