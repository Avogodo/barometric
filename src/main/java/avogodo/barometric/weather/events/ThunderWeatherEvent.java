package avogodo.barometric.weather.events;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class ThunderWeatherEvent extends RainWeatherEvent {
    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:thunder";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("Thunder");
    }

    @Override
    public boolean activeCondition(World world) {
        return world.isThundering();
    }

    @Override
    public float windSpeedMinimum() {
        return 20;
    }

    @Override
    public float windSpeedMaximum() {
        return 50;
    }

    @Override
    public float windSpeedRate() {
        return 0.05f;
    }
}
