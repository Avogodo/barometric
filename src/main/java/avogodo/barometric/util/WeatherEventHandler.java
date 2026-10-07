package avogodo.barometric.util;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventHandler {

    public static List<WeatherEvent> OVERRIDES = new ArrayList<>();

    /// adds specified WeatherEvents to a list to be checked through when fetching the active event
    // NOTE: this is *not* a Registry and probably will not work with external compatibility
    // TODO: make a damn registry
    public static void registerOverride(WeatherEvent override){
        OVERRIDES.add(override);
    }
    public static void registerOverrides(List<WeatherEvent> overrides){
        OVERRIDES.addAll(overrides);
    }

    /// gets the current primary event (active event with the highest priority)
    public static WeatherEvent getPrimaryEvent(World world){
        WeatherEvent o = OVERRIDES.getFirst();
        for (WeatherEvent r : OVERRIDES){
            if (r.getPriority() > o.getPriority() && r.activeCondition(world)){
                o = r;
            }
        }
        if (o.activeCondition(world)) {
            return o;
        }
        return null;
    }

    /// fetches the descriptor of the active event, falling back to "Clear" if there is none
    public static Text getPrimaryDescriptor(World world) {
        if (getPrimaryEvent(world) != null) {
            return getPrimaryEvent(world).getDescriptor();
        }
        return Text.literal("Clear");
    }

}
