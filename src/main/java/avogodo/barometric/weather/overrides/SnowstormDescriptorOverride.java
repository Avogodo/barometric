package avogodo.barometric.weather.overrides;

import avogodo.barometric.weather.DescriptorOverride;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class SnowstormDescriptorOverride extends DescriptorOverride {
    @Override
    public boolean activeCondition(World world, BlockPos pos) {
        return world.isThundering() && world.getBiome(pos).value().getPrecipitation(pos, 64) == Biome.Precipitation.SNOW;
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:snowstorm";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("❄ Snowstorm");
    }
}
