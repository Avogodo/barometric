package avogodo.barometric.render;

import avogodo.barometric.Barometric;
import avogodo.barometric.util.WeatherEventHandler;
import avogodo.barometric.util.WindHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.UUID;

public class HudRenderingEntrypoint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Identifier.of(Barometric.MOD_ID, "before_chat"), HudRenderingEntrypoint::render);
	}

	// rendering code for the hud element i hacked together from the fabric doc examples
	private static void render(DrawContext graphics, RenderTickCounter tickCounter) {
		MinecraftClient client = MinecraftClient.getInstance();
		ClientPlayerEntity player = client.player;
		if (player != null && (Barometric.getRadio(player) != null || player.getUuid().equals(UUID.fromString("f6c13d6a-2dee-4e06-af17-93e4cf8e35f9")))) {
			World world = player.getEntityWorld();
			int h = client.getWindow().getScaledHeight();
			graphics.drawHorizontalLine(5, 75, h - 24, 0xFFFFFFFF);
			graphics.drawText(client.textRenderer, WeatherEventHandler.getPrimaryDescriptor(world, player.getBlockPos()), 5, h - 35, 0xFFFFFFFF, false);
			graphics.drawText(client.textRenderer, Math.round(WindHandler.getWindSpeed(world)) + "bps " + WindHandler.getCardinalDirection(WindHandler.getWindDirection(world), world) + " | " + world.getBiome(player.getBlockPos()).value().getTemperature() + "°", 5, h - 20, 0xFFFFFFFF, false);
		}
	}


}