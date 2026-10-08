package avogodo.barometric.mixin;

import avogodo.barometric.util.WindHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.CloudRenderer;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CloudRenderer.class)
public class CloudRendererMixin {
	@ModifyConstant(method = "renderClouds", constant = @Constant(floatValue = 0.030000001f))
	private float getCloudSpeed(float cloudSpeed) {
		return cloudSpeed;
	}
}