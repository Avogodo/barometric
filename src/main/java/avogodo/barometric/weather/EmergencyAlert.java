package avogodo.barometric.weather;

import net.minecraft.text.Text;
import net.minecraft.world.World;

public abstract class EmergencyAlert {
    public EmergencyAlert() {

    }
    public abstract boolean activeCondition(World world);

    public abstract int getPriority();
    public abstract String getIdentifier();
    public abstract WeatherEvent getEvent();

    public abstract Text getDescriptor();
    public abstract Text getSuggestions();

    public abstract int getCooldown();

}
