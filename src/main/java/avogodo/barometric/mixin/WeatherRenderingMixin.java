package avogodo.barometric.mixin;

import avogodo.barometric.util.WeatherEventHandler;
import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.state.WeatherRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(WeatherRendering.class)
public class WeatherRenderingMixin {
	@Shadow
	private void renderPieces(VertexConsumer vertexConsumer, List<WeatherRendering.Piece> pieces, Vec3d pos, float intensity, int range, float gradient) {}

	@Inject(method = "renderPrecipitation", at = @At("TAIL"))
	private void barometric$derechoRainRenderer(VertexConsumerProvider vertexConsumers, Vec3d pos, WeatherRenderState state, CallbackInfo ci) {
		WeatherEvent event = WeatherEventHandler.getPrimaryEvent(MinecraftClient.getInstance().world);
		if (!state.rainPieces.isEmpty() && event != null && event.rainTexture() != null) {
			RenderLayer renderLayer = RenderLayers.weather(event.rainTexture(), MinecraftClient.usesImprovedTransparency());
			renderPieces(vertexConsumers.getBuffer(renderLayer), state.rainPieces, pos, 1.0F, state.radius, state.intensity);
		}
	}
}