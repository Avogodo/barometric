package avogodo.barometric.util;

import avogodo.barometric.weather.DescriptorOverride;
import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventHandler {

    public static List<WeatherEvent> EVENTS = new ArrayList<>();
    public static List<DescriptorOverride> OVERRIDES = new ArrayList<>();

    /// adds specified WeatherEvents to a list to be checked through when fetching the active event
    // NOTE: this is *not* a Registry and probably will not work with external compatibility
    // TODO: make a damn registry
    public static void registerEvent(WeatherEvent event){
        EVENTS.add(event);
    }
    public static void registerEvents(List<WeatherEvent> events){
        EVENTS.addAll(events);
    }

    public static void registerOverride(DescriptorOverride override){
        OVERRIDES.add(override);
    }
    public static void registerOverrides(List<DescriptorOverride> overrides){
        OVERRIDES.addAll(overrides);
    }

    /// gets the current primary event (active event with the highest priority)
    public static WeatherEvent getPrimaryEvent(World world){
        WeatherEvent o = EVENTS.getFirst();
        for (WeatherEvent r : EVENTS){
            if (r.getPriority() > o.getPriority() && r.activeCondition(world)){
                o = r;
            }
        }
        if (o.activeCondition(world)) {
            return o;
        }
        return null;
    }

    /// gets the current primary override (active override with the highest priority)
    public static DescriptorOverride getPrimaryOverride(World world, BlockPos pos){
        DescriptorOverride o = OVERRIDES.getFirst();
        for (DescriptorOverride r : OVERRIDES){
            if (r.getPriority() > o.getPriority() && r.activeCondition(world, pos)){
                o = r;
            }
        }
        if (o.activeCondition(world, pos)) {
            return o;
        }
        return null;
    }

    /// fetches the descriptor of the active event or override, falling back to "Clear" if there is none
    public static Text getPrimaryDescriptor(World world, BlockPos pos) {
        WeatherEvent event = getPrimaryEvent(world);
        DescriptorOverride override = getPrimaryOverride(world, pos);
        if (event != null) {
            if (override != null && override.getPriority() >= event.getPriority()) {
                return override.getDescriptor();
            }
            return event.getDescriptor();
        }
        return Text.literal("☀ Clear");
    }

}
