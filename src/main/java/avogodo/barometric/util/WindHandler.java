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
        a = e && currentSpeed <= event.windSpeedMinimum() ? (float) (a+Math.random()/3) : a;
        a = e && currentSpeed >= event.windSpeedMaximum() ?(float) (a-Math.random()/3) : a;
        a = !e && currentSpeed >= 10 ? a-(float) (a+Math.random()) : a;
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

    // ...
    public static String getCardinalDirection(int degree, World world) {
        if (WeatherEventHandler.getPrimaryEvent(world) != null && WeatherEventHandler.getPrimaryEvent(world).omnidirectionalWinds()) {
            return "Omnidirectional"; //hm...
        }
        if (WindHandler.getWindSpeed(world) < 0.5) {
            return ""; //blanks at 0mph
        }
        if (135<= degree && degree <=225) {
            return "N";
        } else
        if (225< degree && degree <315) {
            return "E";
        }
        if ((315<= degree && degree <=360) || (0<= degree && degree <=45)) {
            return "S";
        }
        if (45< degree && degree <135) {
            return "W";
        }
        return "Err";
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
