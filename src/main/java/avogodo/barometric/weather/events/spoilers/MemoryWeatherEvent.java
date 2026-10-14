package avogodo.barometric.weather.events.spoilers;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.Objects;
import java.util.function.Predicate;

public class MemoryWeatherEvent extends WeatherEvent {

    // again, all i'm looking at is the dimension id.

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getIdentifier() {
        return "overseer:memory";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("☐ Emptiness");
    }

    @Override
    public boolean activeCondition(World world) {
        Predicate<RegistryKey<DimensionType>> p = d -> Objects.equals(d.getValue(), Identifier.of("overseer", "memory"));
        return world.getDimensionEntry().matches(p);
    }

    @Override
    public float windSpeedMultiplier() {
        return 0;
    }

    @Override
    public float windSpeedMaximum() {
        return 0;
    }
}
