package avogodo.barometric.weather;

import avogodo.barometric.util.WeatherEvent;
import net.minecraft.world.World;

public class RainWeatherEvent extends WeatherEvent {

    @Override
    public String getIdentifier() {
        return "minecraft:rain";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getRadioDescriptor() {
        return "Rain";
    }


}
