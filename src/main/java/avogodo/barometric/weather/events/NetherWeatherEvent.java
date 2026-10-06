package avogodo.barometric.weather.events;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.function.Predicate;

public class NetherWeatherEvent extends WeatherEvent {
    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public String getIdentifier() {
        return "minecraft:nether";
    }

    @Override
    public String getDescriptor() {
        return "Arid";
    }

    @Override
    public boolean activeCondition(World world) {
        Predicate<RegistryKey<DimensionType>> p = d -> d.equals(DimensionTypes.THE_NETHER);
        return world.getDimensionEntry().matches(p);
    }

    @Override
    public float windSpeedMultiplier() {
        return 1;
    }

    @Override
    public float windSpeedMinimum() {
        return 0;
    }

    @Override
    public float windSpeedMaximum() {
        return 10;
    }
}

