package avogodo.barometric.util;

import avogodo.barometric.weather.EmergencyAlert;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class EmergencyAlertHandler {
    public static List<EmergencyAlert> ALERTS = new ArrayList<>();

    public static void registerAlert(EmergencyAlert alert){
        ALERTS.add(alert);
    }
    public static void registerAlerts(List<EmergencyAlert> alerts){
        ALERTS.addAll(alerts);
    }

    public static EmergencyAlert getPrimaryAlert(World world){
        EmergencyAlert o = ALERTS.getFirst();
        for (EmergencyAlert r : ALERTS){
            if (r.getPriority() > o.getPriority() && r.activeCondition(world)){
                o = r;
            }
        }
        if (o.activeCondition(world)) {
            return o;
        }
        return null;
    }

    public static Text getPrimaryDescriptor(World world) {
        EmergencyAlert alert = getPrimaryAlert(world);
        if (alert != null) {
            return alert.getDescriptor();
        }
        return Text.literal("Err");
    }
    public static Text getPrimarySuggestions(World world) {
        EmergencyAlert alert = getPrimaryAlert(world);
        if (alert != null) {
            return alert.getSuggestions();
        }
        return Text.literal("Err");
    }

}
