package avogodo.barometric.weather.radiooverrides;

import avogodo.barometric.util.RadioOverride;
import net.minecraft.world.World;

public class ThunderRadioOverride extends RadioOverride {
    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:thunder";
    }

    @Override
    public String getDescriptor() {
        return "Thunder";
    }

    @Override
    public boolean activeCondition(World world) {
        return world.isThundering();
    }
}
