package avogodo.barometric.mixin;

import avogodo.barometric.component.WindSpeedComponent;
import avogodo.barometric.util.WindSpeedHandler;
import net.minecraft.resource.ResourceManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void barometric$modifyCloudTexture(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
		ServerWorld world = (ServerWorld) (Object) this;
		WindSpeedComponent component = WindSpeedComponent.get(world);
		component.setValue(WindSpeedHandler.calculateWindSpeed(component.getValue(), world));
	}
}