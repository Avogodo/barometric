package avogodo.barometric.util;

import avogodo.barometric.cca.WindComponent;
import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.world.World;

public class WindHandler {
    // i'd advise against trying to decipher whatever the hell i was thinking here. at least it works.
    public static float updateWindSpeed(float currentSpeed, World world) {
        WeatherEvent event = WeatherEventHandler.getPrimaryEvent(world);
        boolean e = event != null;
        float multiplier = e ? event.windSpeedMultiplier() : 1;
        float r = e ? event.windSpeedRate() : 0.01f;
        float a = Math.random() < r ? (float) (Math.random() - 0.5) * multiplier : 0;
        a = e && currentSpeed <= event.windSpeedMinimum() ? a+event.windSpeedMinimum()*0.5f : a;
        a = e && currentSpeed >= event.windSpeedMaximum() ? a-event.windSpeedMaximum()*0.5f : a;
        a = !e && currentSpeed >= 10 ? a-5 : a;
        return (currentSpeed + a >= 0 ? currentSpeed + a : 0);
    }

    // the same thing except it windspeed bounds are replaced by 0 < x < 360
    public static int updateWindDirection(int currentDirection, World world) {
        WeatherEvent event = WeatherEventHandler.getPrimaryEvent(world);
        boolean e = event != null;
        float multiplier = e ? event.windSpeedMultiplier() : 1;
        float r = e ? event.windSpeedRate() : 0.01f;
        float a = Math.random() < r ? (float) (Math.random() - 0.5) * multiplier : 0;
        if (0 > currentDirection+a) {
            return 360;
        }
        if (360 < currentDirection+a) {
            return 0;
        }
        return currentDirection + a >= 0 ? (int) (currentDirection + a) : 0;
    }

    // more incomprehensible math
    public static String getCardinalDirection(int degree, World world) {
        if (WeatherEventHandler.getPrimaryEvent(world) != null && WeatherEventHandler.getPrimaryEvent(world).omnidirectionalWinds()) {
            return "Omnidirectional"; //hm...
        }
        if (WindHandler.getWindSpeed(world) < 0.5) {
            return ""; //blanks at 0mph
        }
        double n = degree % 360;
        n = n < 0 ? n + 360 : n;
        String[] d = {"N", "E", "S", "W"};
        int i = (int) Math.floor((n + 45) / 90) % 4;
        return d[i];
    }

    /// fetches the current wind speed in the specified world
    public static float getWindSpeed(World world) {
        return WindComponent.get(world).getSpeed();
    }
    /// fetches the current wind direction in the specified world
    public static int getWindDirection(World world) {
        return WindComponent.get(world).getDirection();
    }
    }
