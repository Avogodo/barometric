package avogodo.barometric.weather;

import net.minecraft.world.World;

public abstract class WeatherEvent {
    public WeatherEvent() {

    }
    public abstract int getPriority();

    public abstract String getIdentifier();
    public abstract String getDescriptor();

    public abstract boolean activeCondition(World world);
    public abstract float windSpeedMultiplier();
    public abstract float windSpeedMinimum();
    public abstract float windSpeedMaximum();

}
