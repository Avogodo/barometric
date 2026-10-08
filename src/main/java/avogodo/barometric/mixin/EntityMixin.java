package avogodo.barometric.mixin;

import avogodo.barometric.util.WeatherEventHandler;
import avogodo.barometric.util.WindHandler;
import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "tick", at = @At("HEAD"))
	private void barometric$pushEntitiesWithWind(CallbackInfo ci) {
		Entity entity = (Entity) (Object) this;
		World world = entity.getEntityWorld();
		float speed = WindHandler.getWindSpeed(world);
		WeatherEvent event = WeatherEventHandler.getPrimaryEvent(world);
		float r = (float) (WindHandler.getWindDirection(world) * Math.PI / 180f);
		if (speed > 15 && world.isSkyVisible(entity.getBlockPos()) && (event == null || !event.cancelWindMovement())) {
			entity.addVelocity(-MathHelper.sin(r) / 100, 0, MathHelper.cos(r) / 100);
		}
	}
}