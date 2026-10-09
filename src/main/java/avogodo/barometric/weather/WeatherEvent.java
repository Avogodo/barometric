package avogodo.barometric.weather;

import net.minecraft.text.Text;
import net.minecraft.world.World;

public abstract class WeatherEvent {
    public WeatherEvent() {

    }
    public abstract int getPriority();
    public abstract String getIdentifier();
    public abstract Text getDescriptor();

    /// should return true only when the event is set to be active.
    public abstract boolean activeCondition(World world);

    /// multiplies any update to the wind speed by this value.
    public float windSpeedMultiplier() {
        return 1;
    }

    /// chance per game tick to update the weather.
    public float windSpeedRate() {
        return 0.01f;
    }

    /// upper and lower bounds for the wind to (roughly) follow during the event.
    public float windSpeedMinimum() {
        return 0;
    }
    public float windSpeedMaximum() {
        return -1;
    }

    /// only under specific use cases where wind direction can be completely ignored.
    public String windDirectionOverride() {
        return null;
    }

    /// set to true if you want entities not to be moved by strong winds.
    public boolean cancelWindMovement() {return false;}
}
