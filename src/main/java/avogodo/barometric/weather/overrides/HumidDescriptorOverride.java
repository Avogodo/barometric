package avogodo.barometric.weather.overrides;

import avogodo.barometric.weather.DescriptorOverride;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HumidDescriptorOverride extends DescriptorOverride {
    @Override
    public boolean activeCondition(World world, BlockPos pos) {
        return !world.getBiome(pos).value().hasPrecipitation();
    }

    @Override
    public int getPriority() {
        return 6;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:humid";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("☁ Humid");
    }
}