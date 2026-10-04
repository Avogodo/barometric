package avogodo.barometric.util;

import avogodo.barometric.Barometric;
import avogodo.barometric.component.BarometricWeatherComponent;
import net.minecraft.world.World;

public class BarometricWeather {


    public static void registerWeatherEvent(String identifier, WeatherEvent event) {
        Barometric.WEATHER_MAP.add(event);
    }

    public static void tryQueueWeatherEvent(WeatherEvent event, World world) {
//        if (event.getPriority() >= Barometric.WEATHER_MAP.get(BarometricWeatherComponent.get(world).getValue()).getPriority()) {
//            BarometricWeatherComponent.get(world).setValue(event.getIdentifier());
//        }
    }

    public static void clearWeatherEvent(World world) {
        BarometricWeatherComponent.get(world).setValue("");
    }

//    public static WeatherEvent getActiveEvent(World world) {
//        return Barometric.WEATHER_MAP.get(BarometricWeatherComponent.get(world).getValue());
//    }
}

