package avogodo.barometric.weather.alerts;

import avogodo.barometric.util.WeatherEventHandler;
import avogodo.barometric.weather.EmergencyAlert;
import avogodo.barometric.weather.WeatherEvent;
import avogodo.barometric.weather.events.DerechoWeatherEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class DerechoAlert extends EmergencyAlert {
    @Override
    public boolean activeCondition(World world) {
        return WeatherEventHandler.getPrimaryEvent(world) instanceof DerechoWeatherEvent;
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getIdentifier() {
        return "barometric:derecho";
    }

    @Override
    public WeatherEvent getEvent() {
        return new DerechoWeatherEvent();
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("Extreme wind speeds, heavy rain");
    }

    @Override
    public Text getSuggestions() {
        return Text.literal("Seek shelter underneath a full-block roof");
    }

    @Override
    public int getCooldown() {
        return 30000;
    }
}
