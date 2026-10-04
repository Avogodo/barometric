package avogodo.barometric.util;

import net.minecraft.world.World;

public abstract class RadioOverride {
    public RadioOverride() {

    }
    public abstract int getPriority();

    public abstract String getIdentifier();
    public abstract String getDescriptor();


    public abstract boolean activeCondition(World world);

}
