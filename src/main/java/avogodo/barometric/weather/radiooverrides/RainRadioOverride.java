package avogodo.barometric.weather.radiooverrides;

import avogodo.barometric.util.RadioOverride;
import net.minecraft.world.World;

public class RainRadioOverride extends RadioOverride {
    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:rain";
    }

    @Override
    public String getDescriptor() {
        return "Rain";
    }

    @Override
    public boolean activeCondition(World world) {
        return world.isRaining();
    }
}
