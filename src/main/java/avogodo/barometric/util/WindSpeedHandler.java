package avogodo.barometric.util;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class WindSpeedHandler {
    public static float calculateWindSpeed(float currentSpeed, World world) {
        WeatherEvent event = WeatherEventHandler.getPrimaryEvent(world);
        float multiplier = event != null ? event.windSpeedMultiplier() : 1;
        float a = Math.random() < 0.05 ? (float) (Math.random() - 0.5) * multiplier : 0;
        a = event != null && currentSpeed <= event.windSpeedMinimum() ? a+event.windSpeedMinimum()*0.5f : a;
        a = event != null && currentSpeed >= event.windSpeedMaximum() ? a-event.windSpeedMaximum()*0.5f : a;
        a = event == null && currentSpeed >= 10 ? a-5 : a;
        return (currentSpeed + a >= 0 ? currentSpeed + a : 0);
    }
}
