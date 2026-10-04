package avogodo.barometric.util;

import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class RadioHandler {

    public static List<RadioOverride> OVERRIDES = new ArrayList<>();


    public static void registerOverride(RadioOverride override){
        OVERRIDES.add(override);
    }

    public static RadioOverride getPrimaryOverride(World world){
        RadioOverride o = OVERRIDES.getFirst();
        for (RadioOverride r : OVERRIDES){
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
        if (getPrimaryOverride(world) != null) {
            return getPrimaryOverride(world).getDescriptor();
        }
        return "Clear";
    }

}
