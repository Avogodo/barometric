package avogodo.barometric.mixin;

import avogodo.barometric.util.WeatherEventHandler;
import avogodo.barometric.util.WindHandler;
import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void barometric$pushEntitiesWithWind(CallbackInfo ci) {
		Entity entity = (Entity) (Object) this;
		Vec3d v = WindHandler.getPushDirection(entity.getEntityWorld(), entity);
		if (!Objects.equals(v, new Vec3d(0, 0, 0))) {
			entity.addVelocity(v);
		}
	}
}