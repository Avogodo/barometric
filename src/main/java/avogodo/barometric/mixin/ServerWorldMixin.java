package avogodo.barometric.mixin;

import avogodo.barometric.cca.WindComponent;
import avogodo.barometric.util.WindHandler;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void barometric$modifyCloudTexture(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
		ServerWorld world = (ServerWorld) (Object) this;
		WindComponent component = WindComponent.get(world);
		component.setSpeed(WindHandler.updateWindSpeed(component.getSpeed(), world));
		component.setDirection(WindHandler.updateWindDirection(component.getDirection(), world));
	}
}