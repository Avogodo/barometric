package avogodo.barometric.util;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventHandler {

    public static List<WeatherEvent> OVERRIDES = new ArrayList<>();


    public static void registerOverride(WeatherEvent override){
        OVERRIDES.add(override);
    }
    public static void registerOverrides(List<WeatherEvent> overrides){
        OVERRIDES.addAll(overrides);
    }

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
    public static String getPrimaryDescriptor(World world) {
        if (getPrimaryEvent(world) != null) {
            return getPrimaryEvent(world).getDescriptor();
        }
        return "Clear";
    }

}
