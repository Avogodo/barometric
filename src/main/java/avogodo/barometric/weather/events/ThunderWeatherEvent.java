package avogodo.barometric.weather.events;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.world.World;

public class ThunderWeatherEvent extends WeatherEvent {
    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:thunder";
    }

    @Override
    public String getDescriptor() {
        return "Thunder";
    }

    @Override
    public boolean activeCondition(World world) {
        return world.isThundering();
    }

    @Override
    public float windSpeedMultiplier() {
        return 1.5f;
    }

    @Override
    public float windSpeedMinimum() {
        return 20;
    }

    @Override
    public float windSpeedMaximum() {
        return 50;
    }
}
