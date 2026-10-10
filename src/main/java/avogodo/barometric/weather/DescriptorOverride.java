package avogodo.barometric.weather;

import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class DescriptorOverride {
    public DescriptorOverride() {}

    public abstract boolean activeCondition(World world, BlockPos pos);

    public abstract int getPriority();
    public abstract String getIdentifier();
    public abstract Text getDescriptor();
}
