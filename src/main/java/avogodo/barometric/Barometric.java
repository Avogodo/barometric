package avogodo.barometric;

import avogodo.barometric.item.BarometricItems;
import avogodo.barometric.util.*;
import avogodo.barometric.weather.RainWeatherEvent;
import avogodo.barometric.weather.radiooverrides.RainRadioOverride;
import avogodo.barometric.weather.radiooverrides.ThunderRadioOverride;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Barometric implements ModInitializer {
	public static final String MOD_ID = "barometric";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static List<WeatherEvent> WEATHER_MAP = new ArrayList<>();

	@Override
	public void onInitialize() {
		BarometricItems.initialize();
		BarometricRegistries.initialize();
		RadioHandler.registerOverride(new RainRadioOverride());
		RadioHandler.registerOverride(new ThunderRadioOverride());
		//BarometricWeather.registerWeatherEvent("minecraft:rain", new RainWeatherEvent());
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
