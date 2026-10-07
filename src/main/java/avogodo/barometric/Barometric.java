package avogodo.barometric;

import avogodo.barometric.component.BarometricComponentTypes;
import avogodo.barometric.item.BarometricItems;
import avogodo.barometric.util.*;
import avogodo.barometric.weather.events.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.gui.hud.bar.Bar;
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

	@Override
	public void onInitialize() {
		BarometricItems.init();
		BarometricComponentTypes.init();
		WeatherEventHandler.registerOverrides(List.of(new RainWeatherEvent(), new ThunderWeatherEvent(), new NetherWeatherEvent(), new EndWeatherEvent(), new LabyrinthWeatherEvent()));
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
