package avogodo.barometric.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.World;

public abstract class WeatherEvent {
    public WeatherEvent() {

    }
    public abstract String getIdentifier();

    public abstract int getPriority();
    public abstract String getRadioDescriptor();

    public boolean isActive() {
        return false; //change when the weather class is made
    }
}
