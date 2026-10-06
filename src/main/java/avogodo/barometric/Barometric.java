package avogodo.barometric;

import avogodo.barometric.item.BarometricItems;
import avogodo.barometric.util.*;
import avogodo.barometric.weather.events.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Barometric implements ModInitializer {
	public static final String MOD_ID = "barometric";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BarometricItems.initialize();
		WeatherEventHandler.registerOverrides(List.of(new RainWeatherEvent(), new ThunderWeatherEvent(), new NetherWeatherEvent(), new EndWeatherEvent()));
		//BarometricWeather.registerWeatherEvent("minecraft:rain", new RainWeatherEvent());
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
