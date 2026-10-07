package avogodo.barometric.weather.events;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class RainWeatherEvent extends WeatherEvent {
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:rain";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("Rainy");
    }

    @Override
    public boolean activeCondition(World world) {
        return world.isRaining();
    }

    @Override
    public float windSpeedMultiplier() {
        return 1.5f;
    }

    @Override
    public float windSpeedMinimum() {
        return 10;
    }

    @Override
    public float windSpeedMaximum() {
        return 30;
    }

    @Override
    public float windSpeedRate() {
        return 0.025f;
    }
}
