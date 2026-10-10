package avogodo.barometric;

import avogodo.barometric.item.BarometricItems;
import avogodo.barometric.util.*;
import avogodo.barometric.weather.events.*;
import avogodo.barometric.weather.overrides.SnowDescriptorOverride;
import avogodo.barometric.weather.overrides.SnowstormDescriptorOverride;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Barometric implements ModInitializer {
	public static final String MOD_ID = "barometric";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static float TEST = 90;

	@Override
	public void onInitialize() {
		BarometricItems.init();
		WeatherEventHandler.registerEvents(List.of(new RainWeatherEvent(), new ThunderWeatherEvent(), new DerechoWeatherEvent(), new NetherWeatherEvent(), new EndWeatherEvent(), new LabyrinthWeatherEvent()));
		WeatherEventHandler.registerOverrides(List.of(new SnowDescriptorOverride(), new SnowstormDescriptorOverride()));
	}

	public static ItemStack getRadio(PlayerEntity player) {
		PlayerInventory inv = player.getInventory();
		for (int i = 0; i <= inv.size(); i++){
			if (inv.getStack(i).isOf(BarometricItems.WEATHER_RADIO)) {
				return inv.getStack(i);
			}
		}
		return null;
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
